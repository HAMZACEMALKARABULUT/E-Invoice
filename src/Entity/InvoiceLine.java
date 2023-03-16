package entity;

public class InvoiceLine {


    private int piece;

    private double lineCost;
    private double lineTaxCost;
    private Product product;



    public void addLine(int piece, Product product) {



        this.piece = piece;
        this.product = product;
        this.lineCost = Math.round(piece * product.getUnitPrice()* 100.0) / 100.0;

        this.lineTaxCost= Math.round((lineCost*product.getVatRate() * 100.0 )/100.0) / 100.0;  ;
    }
    public int getPiece() {
        return piece;
    }

    public double getLineCost() {
        return lineCost;
    }

    public Product getProduct() {
        return product;
    }
    public double getLineTaxCost(){return lineTaxCost;}



    @Override
    public String toString() {
        return
                getProduct().getBrand() + " " + getProduct().getName() + "  |   " + getProduct().getUnitPrice() + " x "
                + this.getPiece() + " = " + this.getLineCost() + "  |  kdv : %" + getProduct().getVatRate() + "\n";
    }

}
