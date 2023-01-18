package taxcalculator.models;

import static taxcalculator.constants.Tax.MANUFACTURED_ITEM_ADDITIONAL_TAX_RATE;
import static taxcalculator.constants.Tax.MANUFACTURED_ITEM_TAX_RATE;

import taxcalculator.enums.Type;

public class ManufacturedItem extends Item {
  public ManufacturedItem(String name, Type type, double price, int quantity) {
    super(name, type, price, quantity);
  }

  public double calcTaxedCost() {
    double taxedCost = (price * MANUFACTURED_ITEM_TAX_RATE) / 100.0;
    taxedCost += ((price + taxedCost) * MANUFACTURED_ITEM_ADDITIONAL_TAX_RATE) / 100.0;
    return taxedCost;
  }
}
