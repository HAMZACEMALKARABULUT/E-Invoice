package com.izibiz.service.mapper;

import com.izibiz.repository.entity.InvoiceEntity;
import com.izibiz.repository.entity.InvoiceLineEntity;
import com.izibiz.repository.entity.ProductEntity;
import com.izibiz.service.domain.Invoice;
import com.izibiz.service.domain.InvoiceLine;
import com.izibiz.service.domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-10T20:22:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public InvoiceEntity fromDomainToEntity(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceEntity invoiceEntity = new InvoiceEntity();

        invoiceEntity.setId( invoice.getId() );
        invoiceEntity.setCustomerId( invoice.getCustomerId() );
        invoiceEntity.setTotalCost( invoice.getTotalCost() );
        invoiceEntity.setTotalTlCost( invoice.getTotalTlCost() );
        invoiceEntity.setTotalTax( invoice.getTotalTax() );
        invoiceEntity.setCreateDate( invoice.getCreateDate() );
        invoiceEntity.setCreateTime( invoice.getCreateTime() );
        invoiceEntity.setMoneyType( invoice.getMoneyType() );
        invoiceEntity.setUuid( invoice.getUuid() );
        invoiceEntity.setStatus( invoice.getStatus() );
        invoiceEntity.setUserId( invoice.getUserId() );
        invoiceEntity.setInvoiceLines( invoiceLineListToInvoiceLineEntityList( invoice.getInvoiceLines() ) );

        return invoiceEntity;
    }

    @Override
    public Invoice fromEntityToDomain(InvoiceEntity invoiceEntity) {
        if ( invoiceEntity == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setId( invoiceEntity.getId() );
        invoice.setCustomerId( invoiceEntity.getCustomerId() );
        invoice.setTotalCost( invoiceEntity.getTotalCost() );
        invoice.setTotalTlCost( invoiceEntity.getTotalTlCost() );
        invoice.setTotalTax( invoiceEntity.getTotalTax() );
        invoice.setCreateDate( invoiceEntity.getCreateDate() );
        invoice.setCreateTime( invoiceEntity.getCreateTime() );
        invoice.setMoneyType( invoiceEntity.getMoneyType() );
        invoice.setUuid( invoiceEntity.getUuid() );
        invoice.setStatus( invoiceEntity.getStatus() );
        invoice.setUserId( invoiceEntity.getUserId() );
        invoice.setInvoiceLines( invoiceLineEntityListToInvoiceLineList( invoiceEntity.getInvoiceLines() ) );

        return invoice;
    }

    @Override
    public List<Invoice> fromListEntityToDomain(List<InvoiceEntity> invoiceEntityList) {
        if ( invoiceEntityList == null ) {
            return null;
        }

        List<Invoice> list = new ArrayList<Invoice>( invoiceEntityList.size() );
        for ( InvoiceEntity invoiceEntity : invoiceEntityList ) {
            list.add( fromEntityToDomain( invoiceEntity ) );
        }

        return list;
    }

    protected ProductEntity productToProductEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( product.getId() );
        productEntity.setName( product.getName() );
        productEntity.setBarcode( product.getBarcode() );
        productEntity.setUnitPrice( product.getUnitPrice() );
        productEntity.setQuantity( product.getQuantity() );
        productEntity.setUnit( product.getUnit() );
        productEntity.setVatRate( product.getVatRate() );
        productEntity.setBrand( product.getBrand() );
        productEntity.setUserId( product.getUserId() );

        return productEntity;
    }

    protected InvoiceLineEntity invoiceLineToInvoiceLineEntity(InvoiceLine invoiceLine) {
        if ( invoiceLine == null ) {
            return null;
        }

        InvoiceLineEntity invoiceLineEntity = new InvoiceLineEntity();

        invoiceLineEntity.setId( invoiceLine.getId() );
        invoiceLineEntity.setPiece( invoiceLine.getPiece() );
        invoiceLineEntity.setInvoiceId( invoiceLine.getInvoiceId() );
        invoiceLineEntity.setLineCost( invoiceLine.getLineCost() );
        invoiceLineEntity.setLineTaxCost( invoiceLine.getLineTaxCost() );
        invoiceLineEntity.setProduct( productToProductEntity( invoiceLine.getProduct() ) );

        return invoiceLineEntity;
    }

    protected List<InvoiceLineEntity> invoiceLineListToInvoiceLineEntityList(List<InvoiceLine> list) {
        if ( list == null ) {
            return null;
        }

        List<InvoiceLineEntity> list1 = new ArrayList<InvoiceLineEntity>( list.size() );
        for ( InvoiceLine invoiceLine : list ) {
            list1.add( invoiceLineToInvoiceLineEntity( invoiceLine ) );
        }

        return list1;
    }

    protected Product productEntityToProduct(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productEntity.getId() );
        product.setName( productEntity.getName() );
        product.setBarcode( productEntity.getBarcode() );
        product.setUnitPrice( productEntity.getUnitPrice() );
        product.setQuantity( productEntity.getQuantity() );
        product.setUnit( productEntity.getUnit() );
        product.setVatRate( productEntity.getVatRate() );
        product.setBrand( productEntity.getBrand() );
        product.setUserId( productEntity.getUserId() );

        return product;
    }

    protected InvoiceLine invoiceLineEntityToInvoiceLine(InvoiceLineEntity invoiceLineEntity) {
        if ( invoiceLineEntity == null ) {
            return null;
        }

        InvoiceLine invoiceLine = new InvoiceLine();

        invoiceLine.setId( invoiceLineEntity.getId() );
        invoiceLine.setPiece( invoiceLineEntity.getPiece() );
        invoiceLine.setInvoiceId( invoiceLineEntity.getInvoiceId() );
        invoiceLine.setLineCost( invoiceLineEntity.getLineCost() );
        invoiceLine.setLineTaxCost( invoiceLineEntity.getLineTaxCost() );
        invoiceLine.setProduct( productEntityToProduct( invoiceLineEntity.getProduct() ) );

        return invoiceLine;
    }

    protected List<InvoiceLine> invoiceLineEntityListToInvoiceLineList(List<InvoiceLineEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<InvoiceLine> list1 = new ArrayList<InvoiceLine>( list.size() );
        for ( InvoiceLineEntity invoiceLineEntity : list ) {
            list1.add( invoiceLineEntityToInvoiceLine( invoiceLineEntity ) );
        }

        return list1;
    }
}
