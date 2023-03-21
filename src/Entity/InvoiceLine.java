package entity;

public class InvoiceLine {


    private int piece;

    private double lineCost;
    private double lineTaxCost;
    private Product product;



    public void setLine(int piece, Product product) {



        this.piece = piece;
        this.product = product;
        this.lineCost = Math.round(piece * product.getUnitPrice()* 100.0) / 100.0;

        this.lineTaxCost= Math.round((lineCost*product.getVatRate() * 100.0 )/100.0) / 100.0;
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

    public void setPiece(int piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append(System.lineSeparator()).append(getProduct().getBrand()).append("  ").append(getProduct().getName()).append("    |    ").append(getProduct()
                .getUnitPrice()).append(" x ").append(getPiece()).append(" = ").append(getLineCost()).append("  |  kdv : %").append(getProduct().getVatRate()).append("   ")
                .append(getLineCost()).append("    ").append(getLineTaxCost()).append(System.lineSeparator());
        return  sb.toString();
    }

}
