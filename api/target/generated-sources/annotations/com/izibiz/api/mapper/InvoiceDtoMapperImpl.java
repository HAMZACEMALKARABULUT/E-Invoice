package com.izibiz.api.mapper;

import com.izibiz.api.dto.InvoiceDto;
import com.izibiz.api.dto.InvoiceLineDto;
import com.izibiz.api.dto.ProductDto;
import com.izibiz.service.domain.Invoice;
import com.izibiz.service.domain.InvoiceLine;
import com.izibiz.service.domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-06T21:54:06+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class InvoiceDtoMapperImpl implements InvoiceDtoMapper {

    @Override
    public InvoiceDto toDto(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceDto invoiceDto = new InvoiceDto();

        invoiceDto.setId( invoice.getId() );
        invoiceDto.setCustomerId( invoice.getCustomerId() );
        invoiceDto.setTotalCost( invoice.getTotalCost() );
        invoiceDto.setTotalTlCost( invoice.getTotalTlCost() );
        invoiceDto.setTotalTax( invoice.getTotalTax() );
        invoiceDto.setCreateDate( invoice.getCreateDate() );
        invoiceDto.setCreateTime( invoice.getCreateTime() );
        invoiceDto.setMoneyType( invoice.getMoneyType() );
        invoiceDto.setUuid( invoice.getUuid() );
        invoiceDto.setStatus( invoice.getStatus() );
        invoiceDto.setUserId( invoice.getUserId() );
        invoiceDto.setInvoiceLines( invoiceLineListToInvoiceLineDtoList( invoice.getInvoiceLines() ) );

        return invoiceDto;
    }

    @Override
    public Invoice toInvoice(InvoiceDto invoiceDto) {
        if ( invoiceDto == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setId( invoiceDto.getId() );
        invoice.setCustomerId( invoiceDto.getCustomerId() );
        invoice.setTotalCost( invoiceDto.getTotalCost() );
        invoice.setTotalTlCost( invoiceDto.getTotalTlCost() );
        invoice.setTotalTax( invoiceDto.getTotalTax() );
        invoice.setCreateDate( invoiceDto.getCreateDate() );
        invoice.setCreateTime( invoiceDto.getCreateTime() );
        invoice.setMoneyType( invoiceDto.getMoneyType() );
        invoice.setUuid( invoiceDto.getUuid() );
        invoice.setStatus( invoiceDto.getStatus() );
        invoice.setUserId( invoiceDto.getUserId() );
        invoice.setInvoiceLines( invoiceLineDtoListToInvoiceLineList( invoiceDto.getInvoiceLines() ) );

        return invoice;
    }

    @Override
    public List<Invoice> toInvoiceList(List<InvoiceDto> invoiceDtoList) {
        if ( invoiceDtoList == null ) {
            return null;
        }

        List<Invoice> list = new ArrayList<Invoice>( invoiceDtoList.size() );
        for ( InvoiceDto invoiceDto : invoiceDtoList ) {
            list.add( toInvoice( invoiceDto ) );
        }

        return list;
    }

    @Override
    public List<InvoiceDto> toInvoiceDtoList(List<Invoice> invoiceDtoList) {
        if ( invoiceDtoList == null ) {
            return null;
        }

        List<InvoiceDto> list = new ArrayList<InvoiceDto>( invoiceDtoList.size() );
        for ( Invoice invoice : invoiceDtoList ) {
            list.add( toDto( invoice ) );
        }

        return list;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setBarcode( product.getBarcode() );
        productDto.setUnitPrice( product.getUnitPrice() );
        productDto.setQuantity( product.getQuantity() );
        productDto.setUnit( product.getUnit() );
        productDto.setVatRate( product.getVatRate() );
        productDto.setBrand( product.getBrand() );
        productDto.setUserId( product.getUserId() );

        return productDto;
    }

    protected InvoiceLineDto invoiceLineToInvoiceLineDto(InvoiceLine invoiceLine) {
        if ( invoiceLine == null ) {
            return null;
        }

        InvoiceLineDto invoiceLineDto = new InvoiceLineDto();

        invoiceLineDto.setId( invoiceLine.getId() );
        invoiceLineDto.setPiece( invoiceLine.getPiece() );
        invoiceLineDto.setInvoiceId( invoiceLine.getInvoiceId() );
        invoiceLineDto.setLineCost( invoiceLine.getLineCost() );
        invoiceLineDto.setLineTaxCost( invoiceLine.getLineTaxCost() );
        invoiceLineDto.setProduct( productToProductDto( invoiceLine.getProduct() ) );

        return invoiceLineDto;
    }

    protected List<InvoiceLineDto> invoiceLineListToInvoiceLineDtoList(List<InvoiceLine> list) {
        if ( list == null ) {
            return null;
        }

        List<InvoiceLineDto> list1 = new ArrayList<InvoiceLineDto>( list.size() );
        for ( InvoiceLine invoiceLine : list ) {
            list1.add( invoiceLineToInvoiceLineDto( invoiceLine ) );
        }

        return list1;
    }

    protected Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setName( productDto.getName() );
        product.setBarcode( productDto.getBarcode() );
        product.setUnitPrice( productDto.getUnitPrice() );
        product.setQuantity( productDto.getQuantity() );
        product.setUnit( productDto.getUnit() );
        product.setVatRate( productDto.getVatRate() );
        product.setBrand( productDto.getBrand() );
        product.setUserId( productDto.getUserId() );

        return product;
    }

    protected InvoiceLine invoiceLineDtoToInvoiceLine(InvoiceLineDto invoiceLineDto) {
        if ( invoiceLineDto == null ) {
            return null;
        }

        InvoiceLine invoiceLine = new InvoiceLine();

        invoiceLine.setId( invoiceLineDto.getId() );
        invoiceLine.setPiece( invoiceLineDto.getPiece() );
        invoiceLine.setInvoiceId( invoiceLineDto.getInvoiceId() );
        invoiceLine.setLineCost( invoiceLineDto.getLineCost() );
        invoiceLine.setLineTaxCost( invoiceLineDto.getLineTaxCost() );
        invoiceLine.setProduct( productDtoToProduct( invoiceLineDto.getProduct() ) );

        return invoiceLine;
    }

    protected List<InvoiceLine> invoiceLineDtoListToInvoiceLineList(List<InvoiceLineDto> list) {
        if ( list == null ) {
            return null;
        }

        List<InvoiceLine> list1 = new ArrayList<InvoiceLine>( list.size() );
        for ( InvoiceLineDto invoiceLineDto : list ) {
            list1.add( invoiceLineDtoToInvoiceLine( invoiceLineDto ) );
        }

        return list1;
    }
}
