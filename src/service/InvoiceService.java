package service;

import dao.InvoiceDao;
import entity.Invoice;

public class InvoiceService {
  static InvoiceDao invoiceDao=new InvoiceDao();
    public  Invoice saveInvoice(Invoice invoice){

        return invoiceDao.saveInvoice(invoice);



    }



}
