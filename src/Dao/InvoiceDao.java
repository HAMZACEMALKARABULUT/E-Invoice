package dao;

import entity.Invoice;
import enums.InvoiceState;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDao {
   static  List<Invoice> invoicelist = new ArrayList<>();
    static long id = 1;
    public void  saveInvoice(Invoice invoice) {

        invoice.setId(id);
        invoicelist.add(invoice);
        id++;



    }
    public void sendInvoice(Invoice invoice){
        invoice.setStatus(InvoiceState.SENT.toString());

    }


    public  boolean listInvoicesByState(InvoiceState invoiceState) {
        boolean isThere=false;

        for (Invoice invoice:invoicelist
             ) {
            if(invoice.getStatus().equals(invoiceState.toString())){
                System.out.println(invoice);
               isThere=true;}

        }
        return isThere;
    }

    public Invoice findInvoiceById(Long id){

        for (Invoice invoice :invoicelist
        ) { if(invoice.getId()==id){
                return invoice;
            }
        }
        return null;

    }
}
