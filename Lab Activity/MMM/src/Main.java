import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ProductCommerce productCommerce = new ProductCommerce();
//        productCommerce.addProduct("1", "Product 1", 100, 10);
//        productCommerce.addProduct("2", "Product 2", 100, 10);
//        productCommerce.addProduct("3", "Product 3", 100, 10);
        productCommerce.addProduct("4", "Product 4", 100, 10);
        productCommerce.addProduct("5", "Product 5", 100, 10);
//
//        for(int i = 0; i < productCommerce.count; i++) {
//            System.out.println(productCommerce.products[i]);
//        }
//        productCommerce.deleteProduct(new Product("3", "Product 3", 100, 10));
//        for(int i = 0; i < productCommerce.count; i++) {
//            System.out.println(productCommerce.products[i]);
//        }
//        System.out.println(productCommerce.search("2"));
//        productCommerce.buyProduct("2", 100);
//        System.out.println(productCommerce.search("2"));

        Product[] products = new Product[5];
        products[0] = new Product("6", "Product 6", 100, 10);
        products[1] = new Product("7", "Product 7", 100, 10);
        products[2] = new Product("8", "Product 8", 100, 10);
        products[3] = new Product("5", "Product 5", 100, 10);
        products[4] = new Product("6", "Product 6", 100, 10);
        productCommerce.bulkOrder(products);
        for(int i = 0; i < productCommerce.count; i++) {
            System.out.println(productCommerce.products[i]);
        }
    }
}