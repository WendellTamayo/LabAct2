public class ProductCommerce implements IProduct{
    Product[] products;
    int count = 0;
    public ProductCommerce() {
        products = new Product[max];
    }
    @Override
    public boolean addProduct(String id, String name, int quantity, double price) {
        Product p = new Product(id, name, quantity, price);
        Product result = search(id);
        if(count < max && result == null) {
            products[count++] = p;
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product p) {
        for(int i = 0; i < count; i++) {
            if(products[i].equals(p)) {
                for(int j = i; j < count - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int buyProduct(String Id, int quantity) {
        for(Product prod : products) {
            if (prod.getProdID().equals(Id)) {
                if(prod.getQuantity() >= quantity) {
                    prod.setQuantity(prod.getQuantity() - quantity);
                    System.out.println("Transaction successful\n");
                    return 1;
                } else {
                    System.out.println("Transaction failed");
                    System.out.println("Not enough quantity\n");
                    return 0;
                }
            }
        }
        return -1;
    }


    @Override
    public Product search(String Id) {
        for(Product prod : products) {
            if(prod != null && prod.getProdID().equals(Id)) {
                return prod;
            }
        }
        return null;
    }

    @Override
    public void bulkOrder(Product[] p) {
        for(Product prod : p) {
            int result = buyProduct(prod.getProdID(), prod.getQuantity());
            if (result == -1) {
                System.out.println("Product not found\n");
            }
        }
    }

}
