package com.izibiz.service.mapper;

import com.izibiz.repository.entity.InvoiceEntity;
import com.izibiz.service.domain.Invoice;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceEntity fromDomainToEntity(Invoice invoice);
    Invoice fromEntityToDomain(InvoiceEntity invoiceEntity);
    List<Invoice> fromListEntityToDomain(List<InvoiceEntity> invoiceEntityList);
}
