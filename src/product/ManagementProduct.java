package product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagementProduct extends Product {
    ArrayList<Product> arrayList = new ArrayList<>();
    public static final String SOURCE_FILE = "data_products.txt";
    public static final String VIEW_FILE = "view.txt";

    public ManagementProduct() {
    }

    public boolean add(Product product) {
       arrayList.add(product);
        return true;
    }

    public void writeFile() {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(SOURCE_FILE, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Product product : arrayList) {
                objectOutputStream.writeObject(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
                fileOutputStream.close();
                arrayList.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showProducts() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileInputStream = new FileInputStream(SOURCE_FILE);
            objectInputStream = new ObjectInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(VIEW_FILE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Product product = null;
            while ((product = (Product) objectInputStream.readObject()) != null) {
                objectOutputStream.writeObject(product);
                System.out.println(product.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void searchProductById(String id) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileInputStream = new FileInputStream(SOURCE_FILE);
            objectInputStream = new ObjectInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(VIEW_FILE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Product product = null;
            while ((product = (Product) objectInputStream.readObject()) != null) {
                if (product.getId().equals(id)) {
                    objectOutputStream.writeObject(product);
                    System.out.println(product.toString());
                    return;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sortByPrice() {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(SOURCE_FILE);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Product product;
            arrayList.clear();
            while ((product = (Product) objectInputStream.readObject()) != null) {
                arrayList.add(product);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                Collections.sort(arrayList, (product1, t1) -> (int) (product1.getPrice() - t1.getPrice()));
                writeFile();
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void inputData(Product product){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name : ");
        product.setName(scanner.nextLine());
        System.out.println("Enter id : ");
        product.setId(scanner.nextLine());
        System.out.println("Enter brand : ");
        product.setBrand(scanner.nextLine());
        System.out.println("Enter price : ");
        product.setPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Enter describable : ");
        product.setDescribable(scanner.nextLine());
    }
}
