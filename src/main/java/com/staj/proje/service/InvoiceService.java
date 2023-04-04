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

    public  void saveInvoice(Invoice invoice){
        invoiceDao.save(invoice);}

    public List<Invoice> getInvoiceListByState(InvoiceState status) {

        return invoiceDao.findInvoiceByStatus(status.toString());

    }

    public void setInvoiceState(Invoice invoice, InvoiceState status){
        invoice.setStatus(status.toString());
        invoiceDao.save(invoice);
    }

    public Optional<Invoice> findInvoiceById(String id){

       return  invoiceDao.findById( Long.parseLong(id));

    }

    public Invoice updateDraftInvoice(Invoice invoice ) {
        return   invoiceDao.save(invoice);
    }
}
