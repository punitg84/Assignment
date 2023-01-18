package taxcalculator;

import static taxcalculator.constants.Commands.NAME_CMD;
import static taxcalculator.constants.Commands.NO;
import static taxcalculator.constants.Commands.PRICE_CMD;
import static taxcalculator.constants.Commands.QUANTITY_CMD;
import static taxcalculator.constants.Commands.TYPE_CMD;
import static taxcalculator.constants.Commands.YES;
import static taxcalculator.validation.ValidateInput.checkEmptyInput;
import static taxcalculator.validation.ValidateInput.checkFirstName;
import static taxcalculator.validation.ValidateInput.checkProperInput;
import static taxcalculator.validation.ValidateInput.extractValidName;
import static taxcalculator.validation.ValidateInput.extractValidPrice;
import static taxcalculator.validation.ValidateInput.extractValidQuantity;
import static taxcalculator.validation.ValidateInput.extractValidType;
import static taxcalculator.validation.ValidateInput.isEndInput;

import java.util.List;
import java.util.Scanner;
import taxcalculator.collection.ItemCollection;
import taxcalculator.enums.Type;
import taxcalculator.models.Item;

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
            throw new Exception("Use the following commands -type, -quantity, -price");
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

  static void displayItems() {
    List<Item> itemList = itemCollection.getItems();
    System.out.println("In total no of items added were : " + itemList.size());
    System.out.println("There Item Info is as follows");
    System.out.println(itemList);
  }

  public static void main(String[] args) {
    do {
      processNewItem();
    } while (addAdditionalItem());
    displayItems();
  }
}