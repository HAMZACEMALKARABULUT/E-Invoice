package com.izibiz.api.mapper;

import com.izibiz.api.dto.InvoiceDto;
import com.izibiz.service.domain.Invoice;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceDtoMapper {
    InvoiceDto toDto(Invoice invoice);
    Invoice toInvoice(InvoiceDto invoiceDto);

    List<Invoice> toInvoiceList(List<InvoiceDto> invoiceDtoList);
    List<InvoiceDto> toInvoiceDtoList(List<Invoice> invoiceDtoList);

}
