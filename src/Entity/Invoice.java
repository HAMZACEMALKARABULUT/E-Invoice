package entity;

import enums.Colors;
import service.CustomerService;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private long Id;
    private long customerId;
    private List<InvoiceLine> invoiceLines;
    private double totalCost;
    private double totalTax;
    private LocalDate createDate;
    private String createTime;

    private String moneyType;
    private String uuid;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax() {
        Double totalTaxCost = 0.0;

        for (InvoiceLine invoiceLine : invoiceLines
        ) {
            totalTaxCost += invoiceLine.getLineTaxCost();

        }
        this.totalTax = Math.round(totalTaxCost * 100.0) / 100.0;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getId() {
        return Id;
    }

    public List<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost() {
        double cost = 0.0;
        for (InvoiceLine invoiceLine : getInvoiceLines()
        ) {
            cost += invoiceLine.getLineCost();
        }
        this.totalCost = Math.round(cost * 100.0) / 100.0;

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
        Customer customer = CustomerService.findCustomerById(getCustomerId());

        sb.append(System.lineSeparator()).append(Colors.BLUE.getCode()).append("Sayın , ").append(customer.getName()).append(" ").append(customer.getSurname()).

        append("     ").append("Fatura id : ").append(getId()).append(System.lineSeparator()).append(System.lineSeparator()).append("ETTN :").append(getUuid()).append("     ").

                append("Düzenlenme Tarihi : ").append(getCreateDate()).append("     ").append(getCreateTime()).append(Colors.BLUE.getLastCode()).

                append(System.lineSeparator()).append(System.lineSeparator()).append(Colors.YELLOW.getCode()).


                append("Satır No | ").append(" Ürün        |").append(" Adet  |").append(" Birim  Fiyat  |").

                append("Satır tutarı   | ").append("KDV oranı   |").append("  KDV tutarı   |").append(System.lineSeparator())

                .append("--------------------------------------------------------------------------------------------------")

                .append(Colors.YELLOW.getLastCode()). append(Colors.BLACK.getCode()).append(System.lineSeparator());


        for (InvoiceLine invoiceLine : getInvoiceLines()
        ) {
            sb.append("  ").append(line).append("          ").append(invoiceLine.getProduct().getName())
            .append("          ").append(invoiceLine.getPiece()).append("   x     ")
            .append(invoiceLine.getProduct().getUnitPrice()).append("     =      ").append(+invoiceLine.getLineCost())
            .append("        %").append(invoiceLine.getProduct().getVatRate()).append("        ").append(invoiceLine.
           getLineTaxCost()).append(System.lineSeparator()).append("--------------------------------------------------").append(System.lineSeparator());

            line++;
        }


        sb.append(System.lineSeparator()).append(System.lineSeparator()).
                append(Colors.YELLOW.getCode()).append("                                               TOPLAM TUTAR :  ").append(" ").
                append(getTotalCost()).append(getMoneyType()).append("       ").
                append("TOPLAM KDV :    ").append(getTotalTax()).append(getMoneyType()).append(Colors.YELLOW.getLastCode());
        sb.append(Colors.BLACK.getLastCode());


        return sb.toString();
    }
}


