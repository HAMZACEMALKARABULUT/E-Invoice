package entity;

import service.CustomerService;

import java.util.Date;
import java.util.List;

public class Invoice {
    private long Id;
    private long customerId;
    private static List<InvoiceLine> invoiceLines;
    private long totalPrice;
    private Date createTime;

    public long getId() {
        return Id;
    }

    public static List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int line = 1;
        Customer customer=CustomerService.findCustomerById(getCustomerId());

        sb.append("Müşteri  :").append(customer.getName()).append(" ").append(customer.getSurname()).append("            ").
                append("Düzenlenme Tarihi : ").append(getCreateTime()).append(System.lineSeparator());

        for (InvoiceLine invoiceLine : getInvoiceLines()
        ) {

                    sb.append(System.lineSeparator())
                    .append("Satır :").append(line).append("      ").append(invoiceLine.getProduct().getName())
                    .append("   ").append(invoiceLine.getProduct().getUnitPrice()).append( " x ")
                    .append(invoiceLine.getPiece()).append(  " = " ).append(+ invoiceLine.getTotalCost())
                    .append(" | kdv: %").append(invoiceLine.getProduct().getVatRate() ).append( System.lineSeparator())


                    .append("--------------------------------------------------");


            line++;
        }


        return sb.toString();
    }
}


