public class Product {
    private String prodID, prodName;
    private int quantity;
    private double price;
    public Product(String prodID, String prodName, int quantity, double price) {
        setProdID(prodID);
        setProdName(prodName);
        setQuantity(quantity);
        setPrice(price);
    }

    public String getProdID() {
        return prodID;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative");
            this.quantity = 0;
            return;
        } else {
            this.quantity = quantity;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (quantity < 0) {
            System.out.println("Price cannot be negative");
            this.price = 0;
            return;
        } else {
            this.price = price;
        }
    }
    public String toString() {
        return String.format("%s %s %d %.2f", prodID, prodName, quantity, price);
    }
    public boolean equals(Product p) {
        return this.prodID.equals(p.prodID) && this.prodName.equals(p.prodName) && this.quantity == p.quantity && this.price == p.price;
    }
}
