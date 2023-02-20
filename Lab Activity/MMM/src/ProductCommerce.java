public class ProductCommerce implements IProduct{
    Product[] products;
    int count = 0;
    public ProductCommerce() {
        products = new Product[max];
    }
    @Override
    public boolean addProduct(Product p) {
        if(count < max && search(p.getProdID(), p.getQuantity()) == null) {
            products[count++] = p;
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product p) {
        for(int i = 0; i < count; i++) {
            if(products[i].equals(p)) {
                for(int j = i; i < count - 1; j++) {
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
            if(prod.getProdID().equals(Id)) {
                if(prod.getQuantity() >= quantity) {
                    prod.setQuantity(prod.getQuantity() - quantity);
                    System.out.println("Transaction successful");
                    return 1;
                } else {
                    System.out.println("Transaction failed");
                    return 0;
                }
            }
        }
        System.out.println("Product not found");
        return -1;
    }

    @Override
    public Product search(String Id, int quantity) {
        for(Product prod : products) {
            if(prod.getProdID().equals(Id) && prod.getQuantity() >= quantity) {
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
                System.out.println("Product not found");
            } else if (result == 0) {
                System.out.println("Transaction failed");
            } else {
                System.out.println("Transaction successful");
            }
        }
    }
}
