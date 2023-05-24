package com.izibiz.service.service;


import com.izibiz.service.adapter.InvoiceAdapter;
import com.izibiz.service.domain.Invoice;
import com.izibiz.service.enums.ErrorCode;
import com.izibiz.service.enums.InvoiceState;
import com.izibiz.service.exception.CustomException;
import com.izibiz.service.util.CalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;
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


    public void setCreateDate(Invoice invoice) {

        invoice.setCreateDate(LocalDate.now());

        try (Formatter fmt = new Formatter()) {
            Calendar cal = Calendar.getInstance();
            fmt.format("%tH:%tM", cal, cal);
            invoice.setCreateTime(fmt.toString());
        }


    }

    public Invoice createInvoice(Invoice invoice, Long userId) {

        calculationUtil.calculateLine(invoice.getInvoiceLines());
        calculationUtil.calculateTotalCost(invoice);
        setCreateDate(invoice);
        invoice.setUserId(userId);
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
               ! invoice.getInvoiceLines().stream().map(invoiceLine -> {

                    if (invoiceLine.getProduct() == null) return false;
                    else if (invoiceLine.getPiece() == 0) return false;
                    else if (productService.productDataControl(invoiceLine.getProduct())) return false;
                    else return true;
                }).collect(Collectors.toList()).contains(false)) {
            throw (new CustomException(("Ürün bilgileri eksik!"),
                ErrorCode.MISSING_PARAMETER));
        }
        return true;


    }

    public Invoice updateInvoice(Invoice invoice) {
        if(invoiceDataControl(invoice)){
          return  invoiceAdapter.save(invoice);

        }
        else throw (new CustomException(("Fatura güncellenirken bir hata oluştu"),ErrorCode.UNEXPECTED_SITUATION));

    }
}
