package entity;

public class Product {

    private long id;
    private String name;
    private String barcode;
    private double unitPrice;//birim fiyat
    private double quantity;//miktar
     private int vatRate;//(varsayılan kdv oranı)

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }





    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }





    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public String getBarcode() {
        return barcode;
    }





    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }





    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitPrice() {
        return unitPrice;
    }





    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public int getVatRate() {
        return vatRate;
    }
}
