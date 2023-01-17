package taxcalculator.models;

import static taxcalculator.constants.Tax.RAW_ITEM_TAX_RATE;

import taxcalculator.enums.Type;

public class RawItem extends Item {
  public RawItem(String name, Type type, double price, int quantity) {
    super(name, type, price, quantity);
  }

  public double calcTaxedCost() {
    return (price * RAW_ITEM_TAX_RATE) / 100.0;
  }
}
