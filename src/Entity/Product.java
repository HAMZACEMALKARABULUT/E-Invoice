package entity;

public class Product {

    private long id;
    private String name;
    private String barcode;
    private double unitPrice;//birim fiyat
    private double quantity;//miktar
    private String unit;
    private short vatRate;//(varsayılan kdv oranı)

    private String brand;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
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


    public void setVatRate(short vatRate) {
        this.vatRate = vatRate;
    }

    public int getVatRate() {
        return vatRate;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }


    @Override
    public String toString() {


        return "Ürün Bilgileri: " + "\nId: " + this.getId() + "\nAdı: " + this.getName() + "\nMarkası: " + this.getBrand() + "\nBarkodu: " + this.getBarcode() +
                "\nMiktarı: " + this.getQuantity() + "\nBirim Fiyatı: " + this.getUnitPrice() + "\nBirim :" + this.getUnit() +"\nKdv Oranı: %" + this.getVatRate() + "\n\n";

    }
}
