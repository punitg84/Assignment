package itemTaxCalculator;

public class Constants {

  /* Tax for Different Items */
  public static final double RAW_ITEM_TAX_RATE = 12.5;
  public static final double MANUFACTURED_ITEM_TAX_RATE = 12.5;
  public static final double MANUFACTURED_ITEM_ADDITIONAL_TAX_RATE = 2;
  public static final int IMPORTED_ITEM_TAX_RATE = 10;
  public static final int IMPORTED_ITEM_FIXED_SURCHARGE_BELOW_FIRST_LIMIT = 5;
  public static final int IMPORTED_ITEM_FIXED_SURCHARGE_ABOVE_FIRST_LIMIT_BELOW_SECOND_LIMIT = 10;
  public static final int IMPORTED_ITEM_SURCHARGE_RATE_ABOVE_SECOND_LIMIT = 5;
  public static final int IMPORTED_ITEM_FIRST_LIMIT = 100;
  public static final int IMPORTED_ITEM_SECOND_LIMIT = 200;

  /* Types of commands available for item */
  public static final String NAME_CMD = "-name";
  public static final String TYPE_CMD = "-type";
  public static final String QUANTITY_CMD = "-quantity";
  public static final String PRICE_CMD = "-price";


  /* Types of commands available to proceed */
  public static final String YES = "y";
  public static final String NO = "n";

  /* REGEX for checking if a string is numeric */
  public static final String IS_NUMERIC_REGEX = "^(?:(?:\\-{1})?\\d+(?:\\.{1}\\d+)?)$";

  /* Enum for types of item */
  public enum Type {
    RAW,
    MANUFACTURED,
    IMPORTED
  }

  private Constants() {
    //Class is non instantiable
  }
}
