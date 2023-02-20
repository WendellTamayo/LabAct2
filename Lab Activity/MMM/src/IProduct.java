public interface IProduct {
    public final int max = 100;
    boolean addProduct(Product p);
    boolean deleteProduct(Product p);
    int buyProduct(String Id, int quantity);
    Product search(String Id, int quantity);
    void bulkOrder(Product[] p);
}
