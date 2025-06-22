import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    // Linear Search
    public static Product linearSearch(Product[] products, String productName) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(productName)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (Array must be sorted by productName)
    public static Product binarySearch(Product[] products, String productName) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comp = products[mid].productName.compareToIgnoreCase(productName);
            if (comp == 0) return products[mid];
            else if (comp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shampoo", "Beauty"),
            new Product(103, "T-Shirt", "Fashion"),
            new Product(104, "Mouse", "Electronics"),
            new Product(105, "Chair", "Furniture")
        };

        // Sort products for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        // Search examples
        String searchTerm = "Mouse";
        Product resultLinear = linearSearch(products, searchTerm);
        Product resultBinary = binarySearch(products, searchTerm);

        System.out.println("Linear Search Result: " + resultLinear);
        System.out.println("Binary Search Result: " + resultBinary);
    }
}
