package taxcalculator.models;

import static taxcalculator.constants.Tax.IMPORTED_ITEM_FIRST_LIMIT;
import static taxcalculator.constants.Tax.IMPORTED_ITEM_FIXED_SURCHARGE_ABOVE_FIRST_LIMIT_BELOW_SECOND_LIMIT;
import static taxcalculator.constants.Tax.IMPORTED_ITEM_FIXED_SURCHARGE_BELOW_FIRST_LIMIT;
import static taxcalculator.constants.Tax.IMPORTED_ITEM_SECOND_LIMIT;
import static taxcalculator.constants.Tax.IMPORTED_ITEM_SURCHARGE_RATE_ABOVE_SECOND_LIMIT;
import static taxcalculator.constants.Tax.IMPORTED_ITEM_TAX_RATE;

import taxcalculator.enums.Type;

public class ImportedItem extends Item {

  public ImportedItem(String name, Type type, double price, int quantity) {
    super(name, type, price, quantity);
  }

  public double calcTaxedCost() {
    double taxedCost = (price * IMPORTED_ITEM_TAX_RATE) / 100.0;
    if (price + taxedCost <= IMPORTED_ITEM_FIRST_LIMIT) {
      taxedCost += IMPORTED_ITEM_FIXED_SURCHARGE_BELOW_FIRST_LIMIT;
    } else if (price + taxedCost <= IMPORTED_ITEM_SECOND_LIMIT) {
      taxedCost += IMPORTED_ITEM_FIXED_SURCHARGE_ABOVE_FIRST_LIMIT_BELOW_SECOND_LIMIT;
    } else {
      taxedCost += ((taxedCost + price) * IMPORTED_ITEM_SURCHARGE_RATE_ABOVE_SECOND_LIMIT) / 100.0;
    }
    return taxedCost;
  }
}
