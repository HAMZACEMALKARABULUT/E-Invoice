package service;

import dao.InvoiceDao;
import entity.Invoice;
import enums.InvoiceState;

public class InvoiceService {
   InvoiceDao invoiceDao=new InvoiceDao();
    public  void saveInvoice(Invoice invoice){

         invoiceDao.saveInvoice(invoice);



    }
    public boolean listInvoicesByState(InvoiceState invoiceState) {

        return invoiceDao.listInvoicesByState(invoiceState);
    }


    public void sendInvoice(Invoice invoice){
        invoiceDao.sendInvoice(invoice);
    }

    public Invoice findInvoiceById(String id){

       return  invoiceDao.findInvoiceById( Long.parseLong(id));

    }

}
