package com.izibiz.service.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@ToString(includeFieldNames = true)
public @Data class Invoice implements Serializable {
    private long id;

    private long customerId;

    private double totalCost;

    private double totalTlCost;
    private double totalTax;
    private LocalDate createDate;
    private String createTime;
    private String moneyType;
    private String uuid;
    private String status;
    private Long userId;
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


