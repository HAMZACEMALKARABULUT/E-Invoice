package com.izibiz.service.adapter.impl;

import com.izibiz.repository.repository.InvoiceRepository;
import com.izibiz.service.adapter.InvoiceAdapter;
import com.izibiz.service.domain.Invoice;
import com.izibiz.service.mapper.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class InvoiceAdapterImpl implements InvoiceAdapter {
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findInvoiceByStatusAndUserId(String status, Long userId) {

        return invoiceMapper.fromListEntityToDomain(invoiceRepository.findInvoiceByStatusAndUserId(status, userId));
    }

    @Override
    public Optional<Invoice> findByIdAndUserId(Long id, Long userId) {
        return invoiceRepository.findByIdAndUserId(id,userId).map(invoiceMapper::fromEntityToDomain);
    }

    @Override
    public List<Invoice> findByUserId(Long userId) {
        return invoiceMapper.fromListEntityToDomain(invoiceRepository.findByUserId(userId));
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceMapper.fromEntityToDomain(invoiceRepository.save
                (invoiceMapper.fromDomainToEntity(invoice)));
    }


}
