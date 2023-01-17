package itemTaxCalculator.models;

import static itemTaxCalculator.Constants.RAW_ITEM_TAX_RATE;

import itemTaxCalculator.Constants;

public class RawItem extends Item {
  public RawItem(String name, Constants.Type type, double price, int quantity) {
    super(name, type, price, quantity);
  }

  public double calcTaxedCost() {
    return (price * RAW_ITEM_TAX_RATE) / 100.0;
  }
}
