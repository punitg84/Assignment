package firstassignment;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ItemCollection itemCollection = new ItemCollection();
    static Item item;

    static void addName(String value) {
        if (value.equals("")) {
            System.out.println("Name is not supposed to be empty string");
        } else {
            item.setName(value);
        }
    }

    static void addType(String value) {
        try {
            item.setType(value);
        } catch (Exception e) {
            System.out.println("Enter one of the following type raw,imported or manufactured");
        }
    }

    static void addPrice(String value) {
        try {
            double intValue = Double.parseDouble(value);
            if(intValue<0){
                System.out.println("Enter Positive Value of price only");
            }else{
                item.setPrice(Integer.parseInt(value));
            }
        } catch (Exception e) {
            System.out.println("Enter integral value of price");
        }
    }

    static void addQuantity(String value) {
        try {
            int intValue = Integer.parseInt(value);
            if(intValue<0){
                System.out.println("Enter Positive Value of quantity only");
            }else{
                item.setQuantity(Integer.parseInt(value));
            }
        } catch (Exception e) {
            System.out.println("Enter integral value of quantity");
        }
    }

    static void processNewItem() {
        item = new Item();
        while (true) {
            String line = sc.nextLine();
            if (line.equals("")) {
                if (Objects.nonNull(item.getType())) break;
                System.out.println("Mandatory field type has not been set yet");
                continue;
            }
            String[] lineSplit = line.split(" ", 2);
            if (lineSplit.length != 2) {
                System.out.println("Input does not follow the order -option <value>");
                continue;
            }
            String option = lineSplit[0];
            String value = lineSplit[1];
            if (Objects.isNull(item.getName()) && !option.equals("-name")) {
                System.out.println("Please start by entering the name using the cmd -name <your item name>");
                continue;
            }
            switch (option) {
                case "-name":
                    addName(value);
                    break;
                case "-type":
                    addType(value);
                    break;
                case "-quantity":
                    addQuantity(value);
                    break;
                case "-price":
                    addPrice(value);
                    break;
                default:
                    System.out.println("Use one of the following commands -type, -quantity, -price or press enter to add the item");
                    break;
            }
        }
        if(item.getPrice()!=0) item.setTaxedCost(item.calcTaxedCost());
        itemCollection.addItem(item);
    }

    static boolean addAdditionalItem() {
        System.out.println("Do you wish to enter more items? Press y/n");
        while (true) {
            String option = sc.nextLine();
            if (option.equals("y")) {
                return true;
            } else if (option.equals(("n"))) {
                return false;
            } else {
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