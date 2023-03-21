package service;

import dao.InvoiceDao;
import entity.Invoice;
import enums.InvoiceState;

import java.util.List;
import java.util.Optional;

public class InvoiceService {
   InvoiceDao invoiceDao=new InvoiceDao();
    public  void saveInvoice(Invoice invoice){

         invoiceDao.saveInvoice(invoice);



    }
    public List<Invoice> getInvoiceListByState() {

        return invoiceDao.getInvoiceListByState();
    }
    public List<Invoice> getInvoiceListByState(InvoiceState state) {

        return invoiceDao.getInvoiceListByState(state);
    }

    public void setInvoiceState(Invoice invoice, InvoiceState state){
        invoiceDao.setInvoiceState(invoice,state);
    }

    public Optional<Invoice> findInvoiceById(String id){

       return  invoiceDao.findInvoiceById( Long.parseLong(id));

    }

    public Invoice updateDraftInvoice(Invoice invoice ) {
        return   invoiceDao.updateDraftInvoice(invoice);
    }
}
