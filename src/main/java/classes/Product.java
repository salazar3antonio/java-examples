package classes;

public class Product {

    private int price;
    private String productId;
    private String brandName;
    private boolean isOnSale;


    public Product(int price, String productId, String brandName, boolean isOnSale) {
        this.price = price;
        this.productId = productId;
        this.brandName = brandName;
        this.isOnSale = isOnSale;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        System.out.println("Print this out");
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isOnSale() {
        return isOnSale;
    }

    public void setOnSale(boolean onSale) {
        isOnSale = onSale;
    }
}
