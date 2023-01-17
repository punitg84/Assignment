package itemTaxCalculator.models;

import static itemTaxCalculator.Constants.MANUFACTURED_ITEM_ADDITIONAL_TAX_RATE;
import static itemTaxCalculator.Constants.MANUFACTURED_ITEM_TAX_RATE;

import itemTaxCalculator.Constants;

public class ManufacturedItem extends Item {
  public ManufacturedItem(String name, Constants.Type type, double price, int quantity) {
    super(name, type, price, quantity);
  }

  public double calcTaxedCost() {
    double taxedCost = (price * MANUFACTURED_ITEM_TAX_RATE) / 100.0;
    taxedCost += ((price + taxedCost) * MANUFACTURED_ITEM_ADDITIONAL_TAX_RATE) / 100.0;
    return taxedCost;
  }
}
