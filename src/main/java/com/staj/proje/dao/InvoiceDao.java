package com.staj.proje.dao;

import com.staj.proje.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDao extends JpaRepository<Invoice,Long> {


    List<Invoice> findInvoiceByStatusAndUserId(String status, Long id);
}
