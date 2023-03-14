package entity;

public class InvoiceLine {


    private int piece;

    private double lineCost;
    private Product product;



    public void addLine(int piece, Product product) {
        this.piece = piece;
        this.product = product;
        this.lineCost = piece * product.getUnitPrice();
    }


    public int getPiece() {
        return piece;
    }

    public double getTotalCost() {
        return lineCost;
    }

    public Product getProduct() {
        return product;
    }



    @Override
    public String toString() {
        return
                getProduct().getBrand() + " " + getProduct().getName() + "  |   " + getProduct().getUnitPrice() + " x "
                + this.getPiece() + " = " + this.getTotalCost() + "  |  kdv : %" + getProduct().getVatRate() + "\n";
    }

}
