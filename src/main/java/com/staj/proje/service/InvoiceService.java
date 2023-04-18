package com.staj.proje.service;

import com.staj.proje.dao.InvoiceDao;
import com.staj.proje.entity.Invoice;
import com.staj.proje.enums.InvoiceState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class InvoiceService {
    @Autowired
    InvoiceDao invoiceDao;

    public  Invoice saveInvoice(Invoice invoice){
      return  invoiceDao.save(invoice);}

    public List<Invoice> findInvoiceByStatusAndUserId(InvoiceState status, Long userId) {
        return invoiceDao.findInvoiceByStatusAndUserId(status.toString(),userId);
    }

    public void setInvoiceState(Invoice invoice, InvoiceState status){
        invoice.setStatus(status.toString());
        invoiceDao.save(invoice);
    }

    public Optional<Invoice> findInvoiceById(String id){

       return  invoiceDao.findById( Long.parseLong(id));

    }


}
