package com.izibiz.service.service;


import com.izibiz.common.context.Context;
import com.izibiz.common.context.RequestContext;
import com.izibiz.service.adapter.InvoiceAdapter;
import com.izibiz.service.domain.Customer;
import com.izibiz.service.domain.Invoice;
import com.izibiz.service.domain.InvoiceLine;
import com.izibiz.service.domain.Product;
import com.izibiz.service.enums.ErrorCode;
import com.izibiz.service.enums.InvoiceState;
import com.izibiz.service.exception.CustomException;
import com.izibiz.service.util.CalculationUtil;
import com.izibiz.service.validation.ValidationUtil;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.*;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.JAXB;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
@Transactional
public class InvoiceService {
    @Autowired
    private InvoiceAdapter invoiceAdapter;
    @Autowired

    private CalculationUtil calculationUtil;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;


    public void setCreateDate(Invoice invoice) {

        invoice.setCreateDate(LocalDate.now());

        try (Formatter fmt = new Formatter()) {
            Calendar cal = Calendar.getInstance();
            fmt.format("%tH:%tM", cal, cal);
            invoice.setCreateTime(fmt.toString());
        }


    }


    public Invoice createInvoice(Invoice invoice, Long userId) {

        invoiceDataControl(invoice);
        RequestContext user = Context.getCurrentUser();
        Customer customer = customerService.findById(invoice.getCustomerId(), userId).get();
        calculationUtil.calculateLine(invoice.getInvoiceLines());
        calculationUtil.calculateTotalCost(invoice);
        setCreateDate(invoice);
        invoice.setUserId(userId);
        String moneyType = invoice.getMoneyType();


        InvoiceType inv = new InvoiceType();
        PartyType supplierParty = new PartyType();
        PartyNameType supplierPartyNameType = new PartyNameType();
        NameType nameType = new NameType();
        nameType.setValue(user.getUsername());
        supplierPartyNameType.setName(nameType);
        supplierParty.setPartyName(supplierPartyNameType);

        SupplierPartyType supplierPartyType = new SupplierPartyType();
        supplierPartyType.setParty(supplierParty);

        CustomerPartyType customerPartyType = new CustomerPartyType();
        PartyType customerParty = new PartyType();
        NameType nt1 = new NameType();
        nt1.setValue(customer.getName() + " " + customer.getSurname());

        PartyNameType customerPartyNameType = new PartyNameType();
        customerPartyNameType.setName(nt1);
        customerParty.setPartyName(customerPartyNameType);


        PartyIdentificationType partyIdentificationType = new PartyIdentificationType();
        IDType idType = new IDType();
        idType.setValue(customer.getIdentifier());
        partyIdentificationType.setID(idType);

        customerParty.getPartyIdentification().add(partyIdentificationType);

        ContactType contactType = new ContactType();
        TelephoneType telephoneType = new TelephoneType();
        telephoneType.setValue(customer.getTelNo());
        ElectronicMailType electronicMailType = new ElectronicMailType();
        electronicMailType.setValue(customer.getMail());
        contactType.setTelephone(telephoneType);
        contactType.setElectronicMail(electronicMailType);


        PartyTaxSchemeType partyTaxSchemeType = new PartyTaxSchemeType();
        TaxSchemeType taxSchemeType = new TaxSchemeType();
        NameType nt2 = new NameType();

        nt2.setValue(customer.getTaxAdministration());
        taxSchemeType.setName(nt2);

        partyTaxSchemeType.setTaxScheme(taxSchemeType);
        AddressType addressType = new AddressType();
        CityNameType cityNameType = new CityNameType();
        CountryType countryType = new CountryType();

        NameType nt3 = new NameType();
        nt3.setValue("Türkiye");
        countryType.setName(nt3);
        cityNameType.setValue("İstanbul");
        addressType.setCityName(cityNameType);
        addressType.setCountry(countryType);
        CitySubdivisionNameType citySubdivisionNameType = new CitySubdivisionNameType();

        citySubdivisionNameType.setValue("Başakşehir");
        addressType.setCitySubdivisionName(citySubdivisionNameType);
        BuildingNameType buildingNameType = new BuildingNameType();
        buildingNameType.setValue("14/A");
        addressType.setBuildingName(buildingNameType);
        customerParty.setPostalAddress(addressType);
        customerParty.setContact(contactType);
        customerParty.setPartyTaxScheme(partyTaxSchemeType);
        customerPartyType.setParty(customerParty);


        TaxSubtotalType taxSubtotalType = new TaxSubtotalType();
        TaxAmountType taxAmountType = new TaxAmountType();
        taxAmountType.setValue(calculationUtil.doubleToBigDecimal(invoice.getTotalTax(), 2));
        taxAmountType.setCurrencyID(moneyType);
        taxSubtotalType.setTaxAmount(taxAmountType);


        PercentType percentType = new PercentType();


        percentType.setValue(calculationUtil.doubleToBigDecimal(invoice.getTotalTax() / invoice.getTotalCost() * 100, 2));

        taxSubtotalType.setPercent(percentType);
        taxSubtotalType.setTaxAmount(taxAmountType);


        TaxableAmountType taxableAmountType = new TaxableAmountType();

        BigDecimal bgTaxableAmount = new BigDecimal(invoice.getTotalTax());


        taxableAmountType.setCurrencyID(moneyType);
        taxableAmountType.setValue(calculationUtil.doubleToBigDecimal(invoice.getTotalCost(), 2));
        taxSubtotalType.setTaxableAmount(taxableAmountType);

        TaxTotalType taxTotalType = new TaxTotalType();
        taxTotalType.setTaxAmount(taxAmountType);
        taxTotalType.getTaxSubtotal().add(taxSubtotalType);

        MonetaryTotalType monetaryTotalType = new MonetaryTotalType();

        PayableAmountType payableAmountType = new PayableAmountType();


        payableAmountType.setValue(calculationUtil.doubleToBigDecimal(invoice.getTotalCost(), 2));
        payableAmountType.setCurrencyID(moneyType);
        monetaryTotalType.setPayableAmount(payableAmountType);
        TaxInclusiveAmountType taxInclusiveAmountType = new TaxInclusiveAmountType();
        taxInclusiveAmountType.setValue(calculationUtil.doubleToBigDecimal(invoice.getTotalCost() - invoice.getTotalTax(), 2));
        taxInclusiveAmountType.setCurrencyID(moneyType);
        monetaryTotalType.setTaxInclusiveAmount(taxInclusiveAmountType);

        TaxExclusiveAmountType taxExclusiveAmountType = new TaxExclusiveAmountType();
        taxExclusiveAmountType.setValue(calculationUtil.doubleToBigDecimal(invoice.getTotalCost(), 2));
        taxExclusiveAmountType.setCurrencyID(moneyType);
        monetaryTotalType.setTaxExclusiveAmount(taxExclusiveAmountType);

        inv.setLegalMonetaryTotal(monetaryTotalType);
        inv.getTaxTotal().add(taxTotalType);
        inv.setAccountingSupplierParty(supplierPartyType);
        inv.setAccountingCustomerParty(customerPartyType);

        int invoiceLineNo = 1;


        //FATURA SATIRLARININ XML'E EKLENDİĞİ ALAN
        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()) {
            Product product = invoiceLine.getProduct();
            BigDecimal lineCost = calculationUtil.doubleToBigDecimal(invoiceLine.getLineCost(), 2);
            BigDecimal lineTax = calculationUtil.doubleToBigDecimal(invoiceLine.getLineTaxCost(), 2);
            Double vatRate = Double.valueOf(product.getVatRate());

            InvoiceLineType invoiceLineType = new InvoiceLineType();
            IDType idType1 = new IDType();
            LineExtensionAmountType lineExtensionAmountType = new LineExtensionAmountType();
            lineExtensionAmountType.setValue(lineCost);
            AllowanceChargeType allowanceChargeType = new AllowanceChargeType();
            BaseAmountType baseAmountType = new BaseAmountType();
            baseAmountType.setValue(lineCost.subtract(lineTax));
            allowanceChargeType.setBaseAmount(baseAmountType);

            TaxTotalType taxTotalType1 = new TaxTotalType();
            TaxAmountType taxAmountType1 = new TaxAmountType();
            taxAmountType1.setValue(lineTax);
            taxAmountType1.setCurrencyID(moneyType);

            taxTotalType1.setTaxAmount(taxAmountType1);

            TaxSubtotalType taxSubtotalType1 = new TaxSubtotalType();
            TaxableAmountType taxableAmountType1 = new TaxableAmountType();
            taxableAmountType1.setCurrencyID(moneyType);

            taxableAmountType1.setValue(lineCost.subtract(lineTax));
            taxSubtotalType1.setTaxableAmount(taxableAmountType1);

            taxSubtotalType1.setTaxAmount(taxAmountType1);
            PercentType percentType1 = new PercentType();
            percentType1.setValue(calculationUtil.doubleToBigDecimal(vatRate, 1));
            taxSubtotalType1.setPercent(percentType1);
            TaxSchemeType taxSchemeType1 = new TaxSchemeType();
            NameType nameType1 = new NameType();
            nameType1.setValue("KDV");
            taxSchemeType1.setName(nameType1);
            TaxCategoryType taxCategoryType = new TaxCategoryType();
            taxCategoryType.setTaxScheme(taxSchemeType1);
            taxSubtotalType1.setTaxCategory(taxCategoryType);
            taxTotalType1.getTaxSubtotal().add(taxSubtotalType1);
            ItemType itemType = new ItemType();
            NameType nameType2 = new NameType();
            nameType2.setValue(product.getName());
            itemType.setName(nameType2);

            PriceType priceType = new PriceType();
            PriceAmountType priceAmountType = new PriceAmountType();
            priceAmountType.setValue(calculationUtil.doubleToBigDecimal(product.getUnitPrice(), 2));
            priceAmountType.setCurrencyID(moneyType);
            priceType.setPriceAmount(priceAmountType);


            idType1.setValue(String.valueOf(invoiceLineNo));
            invoiceLineType.setID(idType1);
            InvoicedQuantityType invoicedQuantityType = new InvoicedQuantityType();
            invoicedQuantityType.setValue(calculationUtil.doubleToBigDecimal(product.getQuantity() * invoiceLine.getPiece(), 2));
            invoicedQuantityType.setUnitCode(product.getUnit());

            invoiceLineType.setInvoicedQuantity(invoicedQuantityType);

            invoiceLineType.setLineExtensionAmount(lineExtensionAmountType);
            invoiceLineType.getLineExtensionAmount().setCurrencyID(moneyType);
            invoiceLineType.getAllowanceCharge().add(allowanceChargeType);
            invoiceLineType.setTaxTotal(taxTotalType1);
            invoiceLineType.setItem(itemType);
            invoiceLineType.setPrice(priceType);

            inv.getInvoiceLine().add(invoiceLineType);
            invoiceLineNo++;

        }

        ProfileIDType profileIDType = new ProfileIDType();
        profileIDType.setValue("Temel Fatura");
        IssueTimeType issueTimeType=new IssueTimeType();
        issueTimeType.setValue();

        IssueDateType issueDateType = new IssueDateType();


        XMLGregorianCalendar xmlGregorianCalendar = null;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();


        gregorianCalendar.setTime(new Date());


        try {
            xmlGregorianCalendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gregorianCalendar);
        }
        catch (Exception e) {
         e.printStackTrace();
        }

        issueDateType.setValue(xmlGregorianCalendar);
        //xml kaydetme aşaması

        UUIDType uuid = new UUIDType();
        uuid.setValue(invoice.getUuid());
        inv.setUUID(uuid);
        inv.setProfileID(profileIDType);
        inv.setIssueDate(issueDateType);
        File savedInvoice = new File(uuid.getValue() + ".xml");
        JAXB.marshal(inv, savedInvoice);

        //invoice.setPath(savedInvoice.getAbsolutePath());
        System.out.println("faturanın kayıt edildiği path:" + savedInvoice.getAbsolutePath());
        return invoiceAdapter.save(invoice);
    }


    public Invoice setInvoiceStatus(Long id, Long userId, InvoiceState status) {

        Optional<Invoice> invoice = findInvoiceById(id, userId);
        if (invoice.isPresent()) {
            invoice.get().setStatus(status.toString());
            return invoiceAdapter.save(invoice.get());
        } else {
            throw (new CustomException(("Bu id'ye sahip faturanız bulunmamaktadır"),
                    ErrorCode.RECORD_NOT_FOUND));
        }
    }

    public List<Invoice> getInvoices(Long userId) {

        return invoiceAdapter.findByUserId(userId);
    }


    public List<Invoice> getInvoicesByStatus(String status, Long userId) {
        return invoiceAdapter.findInvoiceByStatusAndUserId(status, userId);
    }


    public Optional<Invoice> findInvoiceById(Long id, Long userId) {

        return invoiceAdapter.findByIdAndUserId(id, userId);
    }

    public boolean invoiceDataControl(Invoice invoice) {

        if (invoice == null) {
            throw (new CustomException(("Fatura bilgisi eksik !"),
                    ErrorCode.MISSING_PARAMETER));
        } else if (invoice.getInvoiceLines().isEmpty()) {
            throw (new CustomException(("Fatura Satır bilgileri eksik !"),
                    ErrorCode.MISSING_PARAMETER));


        } else if (
                !invoice.getInvoiceLines().stream().map(invoiceLine -> {

                    if (invoiceLine.getProduct() == null) return false;
                    else if (invoiceLine.getPiece() == 0) return false;
                    else if (productService.productDataControl(invoiceLine.getProduct())) return false;
                    else return true;
                }).collect(Collectors.toList()).contains(false)) {
            throw (new CustomException(("Ürün bilgileri eksik!"),
                    ErrorCode.MISSING_PARAMETER));
        } else if (invoice == null || !ValidationUtil.isUuid(invoice.getUuid())) {
            throw (new CustomException("Uuid uygun formatta olmalıdır .", ErrorCode.MISSING_PARAMETER));
        }
        return true;
    }

    public Invoice updateInvoice(Invoice invoice) {
        if (invoiceDataControl(invoice)) {
            return invoiceAdapter.save(invoice);
        } else throw (new CustomException(("Fatura güncellenirken bir hata oluştu"), ErrorCode.UNEXPECTED_SITUATION));

    }
}
