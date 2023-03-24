package dao;

import entity.Invoice;
import enums.InvoiceState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceDao {
    static List<Invoice> invoicelist = new ArrayList<>();
    static long id = 1;

    public void saveInvoice(Invoice invoice) {
        invoice.setId(id);
        invoicelist.add(invoice);
        id++;


    }

    public void setInvoiceState(Invoice invoice, InvoiceState state) {
        invoice.setStatus(state.toString());

    }


    public List<Invoice> getInvoiceListByState() {
        return invoicelist;

    }

    public  List<Invoice> getInvoiceListByState(InvoiceState state) {
        return invoicelist.stream().filter(c->c.getStatus().equals(state.toString())).collect(Collectors.toList());

    }

    public Optional<Invoice> findInvoiceById(Long id) {

        return invoicelist.stream().filter(c->c.getId()==id).findFirst();


    }

    public Invoice updateDraftInvoice(Invoice invoice) {

        return invoice;
    }
}
