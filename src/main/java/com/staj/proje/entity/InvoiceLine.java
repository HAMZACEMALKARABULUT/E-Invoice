package com.staj.proje.entity;


        import lombok.Data;
        import lombok.ToString;

        import javax.persistence.*;
        import java.io.Serializable;

@Table(name = "invoice_line")
@Entity(name = "InvoiceLine")
@ToString(includeFieldNames = true)
public @Data class InvoiceLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "piece")
    private int piece;
    @Column(name = "invoice_id")
    private Long invoiceId;
    @Column(name = "line_cost")
    private double lineCost;
    @Column(name = "line_tax_cost")
    private double lineTaxCost;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;



}
