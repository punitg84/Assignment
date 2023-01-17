package taxcalculator.models;

import taxcalculator.enums.Type;

public abstract class Item {

  protected String name;
  protected double price;
  protected int quantity;
  protected Type type;
  protected double taxedCost;

  public Item() {
    //Default Constructor
  }

  public Item(String name, Type type, double price, int quantity) {
    this.name = name;
    this.type = type;
    this.price = price;
    this.quantity = quantity;
    if (price != 0) {
      this.taxedCost = calcTaxedCost();
    }
  }

  public static Item createItem(String name, Type type, double price, int quantity) {
    switch (type) {
      case MANUFACTURED:
        return new ManufacturedItem(name, type, price, quantity);
      case IMPORTED:
        return new ImportedItem(name, type, price, quantity);
      case RAW:
        return new RawItem(name, type, price, quantity);
    }
    return null;
  }

  public double getTaxedCost() {
    return taxedCost;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public Type getType() {
    return type;
  }

  public abstract double calcTaxedCost();

  @Override
  public String toString() {
    StringBuilder item = new StringBuilder();
    item.append("Name : " + name + "\n");
    item.append("Quantity : " + quantity + "\n");
    item.append("Type : " + type + "\n");
    item.append("Tax : " + taxedCost + "\n");
    item.append("Final Price including tax : " + (price + taxedCost) + "\n");
    return item.toString();
  }
}