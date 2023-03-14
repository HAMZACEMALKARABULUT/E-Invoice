package dao;

import entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDao {
    List<Invoice> invoicelist=new ArrayList<>();

    public Invoice saveInvoice(Invoice invoice){
        invoicelist.add(invoice);

        return  invoice;
    }


}
