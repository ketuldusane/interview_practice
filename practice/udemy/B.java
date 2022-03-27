package udemy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {

    public static void generateFiles(String input_file_name) throws Exception {
        // product name : <total orders, qty>
        Map<String, ProductQtyDetails> qtyDetails = new HashMap<>();
        Map<String, Map<String, Integer>> brandDetails = new HashMap<>();

        int n = 0;
        Scanner scanner = new Scanner(new File(""));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (n != 0) {
                String[] data = line.split(",");
                String name = data[2];
                int qty = Integer.parseInt(data[3]);
                String brand = data[4];

                qtyDetails.putIfAbsent(name, new ProductQtyDetails(0, 0));
                ProductQtyDetails p = qtyDetails.get(name);
                p.orders++;
                p.qty += qty;
                qtyDetails.put(name, p);

                Map<String, Integer> brands = brandDetails.getOrDefault(name, new HashMap<>());
                brands.putIfAbsent(brand, 0);
                brands.put(brand, brands.get(brand) + 1);
            }
            n++;
        }
        scanner.close();
    }

    static class ProductQtyDetails {
        int orders;
        int qty;

        ProductQtyDetails(int orders, int qty) {
            this.orders = orders;
            this.qty = qty;
        }
    }
}
