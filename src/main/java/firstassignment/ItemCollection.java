package firstassignment;

import java.util.ArrayList;
import java.util.List;

public class ItemCollection {
    private final List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void printItems() {
        System.out.println("In total no of items added were : " + itemList.size());
        System.out.println("There Item Info is as follows");
        for (Item item : itemList) {
            System.out.println("Name : " + item.getName());
            System.out.println("Quantity : " + item.getQuantity());
            System.out.println("Type : " + item.getType());
            System.out.println("Tax : " + item.getTaxedCost());
            System.out.println("Final Price including tax : " + (item.getPrice() + item.getTaxedCost()));
            System.out.println();
        }
    }
}