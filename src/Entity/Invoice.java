package entity;

import java.util.Date;
import java.util.List;

public class Invoice {
    private int Id;

    private List<InvoiceLine> invoiceLines;
    private long totalPrice;
    private Date createTime;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<InvoiceLine> getInvoiceLines() {
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
}
