public interface IProduct {
    public final int max = 100;
    boolean addProduct(String id, String name, int quantity, double price);
    boolean deleteProduct(Product p);
    int buyProduct(String Id, int quantity);
    Product search(String Id);
    void bulkOrder(Product[] p);
}
