package itemTaxCalculator;

import itemTaxCalculator.models.Item;
import java.util.Scanner;
import static itemTaxCalculator.Constants.*;
import static itemTaxCalculator.ValidateInput.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    static ItemCollection itemCollection = new ItemCollection();

    static void processNewItem() {
        String name="";
        Type type = null;
        int quantity=0;
        double price=0;
        while (true) {
            String line = sc.nextLine().trim();
            if (isEndInput(line, type)) break;

            try {
                checkEmptyInput(line);

                String[] lineSplit = line.split(" ", 2);
                checkProperInput(lineSplit);

                String option = lineSplit[0];
                String value = lineSplit[1];

                checkFirstName(option, name);

                switch (option) {
                    case NAME:
                        name=extractValidName(value);
                        break;
                    case TYPE:
                        type = extractValidType(value.toUpperCase());
                        break;
                    case QUANTITY:
                        quantity = extractValidQuantity(value);
                        break;
                    case PRICE:
                        price = extractValidPrice(value);
                        break;
                    default:
                        System.out.println("Use one of the following commands -type, -quantity, -price or press enter to add the item");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        Item item = new Item(name,type,price,quantity,0);
        itemCollection.addItem(item);
    }

    static boolean addAdditionalItem() {
        System.out.println("Do you wish to enter more items? Press y/n");
        while (true) {
            String option = sc.nextLine().trim();
            switch (option) {
                case Constants.YES:
                    return true;
                case Constants.NO:
                    return false;
                default:
                    System.out.println("Please press y/n inorder to proceed");
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            processNewItem();
            if (!addAdditionalItem()) break;
        }
        itemCollection.printItems();
    }
}