package itemTaxCalculator;

import static itemTaxCalculator.Constants.*;
import static itemTaxCalculator.ValidateInput.*;

import itemTaxCalculator.models.Item;
import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);
  static ItemCollection itemCollection = new ItemCollection();

  static void processNewItem() {
    String name = "";
    Type type = null;
    int quantity = 0;
    double price = 0;
    while (true) {
      String line = sc.nextLine().trim();
      if (isEndInput(line, type)) {
        break;
      }
      try {
        checkEmptyInput(line);

        String[] lineSplit = line.split(" ", 2);
        checkProperInput(lineSplit);

        String option = lineSplit[0];
        String value = lineSplit[1];

        checkFirstName(option, name);

        switch (option) {
          case NAME_CMD:
            name = extractValidName(value);
            break;
          case TYPE_CMD:
            type = extractValidType(value.toUpperCase());
            break;
          case QUANTITY_CMD:
            quantity = extractValidQuantity(value);
            break;
          case PRICE_CMD:
            price = extractValidPrice(value);
            break;
          default:
            System.out.println("Use the following commands -type, -quantity, -price");
            break;
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    Item item = Item.createItem(name, type, price, quantity);
    itemCollection.addItem(item);
  }

  static boolean addAdditionalItem() {
    System.out.println("Do you wish to enter more items? Press y/n");
    while (true) {
      String option = sc.nextLine().trim();
      switch (option) {
        case YES:
          return true;
        case NO:
          return false;
        default:
          System.out.println("Please press y/n inorder to proceed");
      }
    }
  }

  public static void main(String[] args) {
    while (true) {
      processNewItem();
      if (!addAdditionalItem()) {
        break;
      }
    }
    itemCollection.printItems();
  }
}