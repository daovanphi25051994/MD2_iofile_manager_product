package controller;

import product.ManagementProduct;
import product.Product;

import java.util.Scanner;

public class Controller {
    public void showMenu() {
        System.out.println("----------------------------MENU--------------------------");
        System.out.println("1. Add a product");
        System.out.println("2. Save");
        System.out.println("3. Show list products");
        System.out.println("4. Search products by id");
        System.out.println("5. Sort list products");
        System.out.println("Choose : ");
    }

    public void controller() {
        ManagementProduct managementProduct = new ManagementProduct();
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1:
                Product product = new Product();
                managementProduct.inputData(product);
                managementProduct.add(product);
                break;
            case 2:
                managementProduct.writeFile();
                break;
            case 3:
                managementProduct.showProducts();
                break;
            case 4:
                System.out.println("Enter id : ");
                String id = scanner.nextLine();
                managementProduct.searchProductById(id);
                break;
            case 5:
                managementProduct.sortByPrice();
                break;
        }
    }
}
