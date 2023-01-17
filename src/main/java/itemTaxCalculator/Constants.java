package itemTaxCalculator;

public class Constants {

    /* Types of commands available for item */
    public static final String NAME = "-name";
    public static final String TYPE = "-type";
    public static final String QUANTITY = "-quantity";
    public static final String PRICE = "-price";


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
