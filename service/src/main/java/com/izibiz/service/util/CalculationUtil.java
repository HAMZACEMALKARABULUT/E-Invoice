package com.izibiz.service.util;


import com.izibiz.service.domain.Invoice;
import com.izibiz.service.domain.InvoiceLine;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CalculationUtil {

    public void calculateLine(List<InvoiceLine> invoiceLineList) {
        for (InvoiceLine invoiceLine: invoiceLineList
             ) {
            invoiceLine.setLineCost(Math.round(invoiceLine.getPiece() *
                    invoiceLine.getProduct().getUnitPrice() * 100.0) / 100.0);

            invoiceLine.setLineTaxCost(Math.round((invoiceLine.getLineCost() *
                    invoiceLine.getProduct().getVatRate() * 100.0) / 100.0) / 100.0);
        }
    }

    public void calculateTotalCost(Invoice invoice) {
        double cost = 0.0;
        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()
        ) {
            cost += invoiceLine.getLineCost();
        }
        invoice.setTotalCost(Math.round(cost * 100.0) / 100.0);
        calculateTotalTax(invoice);
    }

    public void calculateTotalTax(Invoice invoice) {
        Double totalTaxCost = 0.0;
        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()
        ) {
            totalTaxCost += invoiceLine.getLineTaxCost();
        }
        invoice.setTotalTax(Math.round(totalTaxCost * 100.0) / 100.0);
    }


    public void setTotalTlCost(double exchangeRate, Invoice invoice) {
        invoice.setTotalTlCost(Math.round(exchangeRate * invoice.getTotalCost() * 100.0) / 100.0);
    }
}
