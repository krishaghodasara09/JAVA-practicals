package lab14.src;

import lab14.src.service.ItemService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. Show Items");
            System.out.println("3. Save Items");
            System.out.println("4. Load Items");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        service.addItem(sc.nextLine());
                        System.out.println("Item added.");
                        break;
                    case 2:
                        System.out.println(service.getItems());
                        break;
                    case 3:
                        service.save("items.dat");
                        System.out.println("Data saved.");
                        break;
                    case 4:
                        service.load("items.dat");
                        System.out.println("Data loaded.");
                        break;
                    case 5:
                        sc.close();
                        return;
                    default:
                        throw new IllegalArgumentException("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}