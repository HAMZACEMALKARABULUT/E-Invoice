package com.staj.proje.utils;

import com.staj.proje.entity.Invoice;
import com.staj.proje.entity.InvoiceLine;
import com.staj.proje.entity.Product;
import org.springframework.stereotype.Controller;

@Controller
public class CalculationUtil {

public void calculateLine(int piece, Product product, InvoiceLine invoiceLine){
       invoiceLine.setPiece(piece);
       invoiceLine.setProduct(product);

        invoiceLine.setLineCost(Math.round(piece * product.getUnitPrice()* 100.0) / 100.0);

        invoiceLine.setLineTaxCost(Math.round((invoiceLine.getLineCost()*product.getVatRate() * 100.0 )/100.0) / 100.0); ;
    }

    public void calculateTotalCost(Invoice invoice) {
        double cost = 0.0;
        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()
        ) {
            cost += invoiceLine.getLineCost();
        }
        invoice.setTotalCost(Math.round(cost * 100.0) / 100.0);
    }

    public void calculateTotalTax(Invoice invoice) {
        Double totalTaxCost = 0.0;
        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()
        ) {
            totalTaxCost += invoiceLine.getLineTaxCost();

        }
        invoice.setTotalTax( Math.round(totalTaxCost * 100.0) / 100.0);
    }




    public void setTotalTlCost(double exchangeRate,Invoice invoice) {
        invoice.setTotalTlCost(Math.round(exchangeRate * invoice.getTotalCost() * 100.0) / 100.0 ) ;
    }
}
