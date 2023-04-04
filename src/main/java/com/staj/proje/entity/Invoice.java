package com.staj.proje.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Table(name="invoice")
@Entity(name="Invoice")
@ToString(includeFieldNames = true)
public @Data class Invoice implements Serializable {
     @Id
     @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    @Column(name="customer_id")
    private long customerId;

    @Column(name="total_cost")
    private double totalCost;

    @Column(name="total_tl_cost")
    private double totalTlCost;
    @Column(name="total_tax")
    private double totalTax;
    @Column(name="create_date")
    private LocalDate createDate;
    @Column(name="create_time")
    private String createTime;
    @Column(name="money_type")
    private String moneyType;
    @Column(name="uuid")
    private String uuid;
    @Column(name="status")
    private String status;



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceLine> invoiceLines;



   /* @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        int line = 1;

        Customer customer = null;//customerService.findCustomerById(getCustomerId()).get();

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
                append(getTotalCost()).append("  ").append(getMoneyType()).append("       ").
                append("TOPLAM KDV :    ").append(getTotalTax()).append(" ").append(getMoneyType()).append("     TL Tutarı :       ").append(getTotalTlCost()).append("  TL").append(Colors.YELLOW.getLastCode());
        sb.append(Colors.BLACK.getLastCode());


        return sb.toString();
    }*/
}


