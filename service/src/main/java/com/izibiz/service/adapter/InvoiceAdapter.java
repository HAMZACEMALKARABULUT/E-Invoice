package com.izibiz.service.adapter;

import com.izibiz.service.domain.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceAdapter {

    List<Invoice> findInvoiceByStatusAndUserId(String status, Long id);

    Optional<Invoice> findByIdAndUserId(Long id, Long userId);
    List<Invoice> findByUserId(Long userId);
    Invoice save(Invoice invoice);


}
