package itemTaxCalculator;

import java.util.Objects;
import java.util.stream.Stream;

import static itemTaxCalculator.Constants.*;

public class ValidateInput {
    public static void checkNumeric(String str) throws Exception {
        if(!str.matches(IS_NUMERIC_REGEX))
            throw new Exception("Enter integral value only");
    }

    static boolean isEndInput(String line, Constants.Type type) {
        return line.equals("") && Objects.nonNull(type);
    }

    static void checkEmptyInput(String line) throws Exception {
        if (line.equals(""))
            throw new Exception("Mandatory field type has not been set yet");
    }

    static void checkProperInput(String[] lineSplit) throws Exception {
        if (lineSplit.length != 2)
            throw new Exception("Input does not follow the order -option <value>");
    }

    static void checkFirstName(String option, String name) throws Exception {
        if (name.equals("") && !option.equals(NAME))
            throw new Exception("Please start by entering the name using the cmd -name <your item name>");
    }

    static String extractValidName(String value) throws Exception {
        if (value.equals(""))
            throw new Exception("Name is not supposed to be empty string");
        return value;
    }

    static Constants.Type extractValidType(String value) throws Exception {
        if (!Stream.of(Constants.Type.values()).anyMatch(v -> v.name().equals(value)))
            throw new Exception("Enter one of the following type raw,imported or manufactured");
        return Constants.Type.valueOf(value);
    }

    static double extractValidPrice(String value) throws Exception {
        checkNumeric(value);
        double price = Double.parseDouble(value);
        if (price <= 0)
            throw new Exception("Enter Positive Value of price only");
        return price;
    }

    static int extractValidQuantity(String value) throws Exception {
        checkNumeric(value);
        int quantity = Integer.parseInt(value);
        if (quantity <= 0)
            throw new Exception("Enter Positive Value of quantity only");
        return quantity;
    }
}
