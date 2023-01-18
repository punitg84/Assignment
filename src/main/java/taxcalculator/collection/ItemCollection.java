package taxcalculator.collection;

import java.util.ArrayList;
import java.util.List;
import taxcalculator.models.Item;

public class ItemCollection {
  private final List<Item> itemList = new ArrayList<>();

  public List<Item> getItems() {
    return itemList;
  }

  public void addItem(Item item) {
    itemList.add(item);
  }

}