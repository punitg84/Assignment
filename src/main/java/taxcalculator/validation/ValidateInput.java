package taxcalculator.validation;

import static taxcalculator.constants.Commands.NAME_CMD;
import static taxcalculator.constants.Regex.IS_NUMERIC_REGEX;

import java.util.Objects;
import java.util.stream.Stream;
import taxcalculator.enums.Type;

public class ValidateInput {
  public static void checkNumeric(String str) throws Exception {
    if (!str.matches(IS_NUMERIC_REGEX)) {
      throw new Exception("Enter integral value only");
    }
  }

  public static boolean isEndInput(String line, Type type) {
    return line.equals("") && Objects.nonNull(type);
  }

  public static void checkEmptyInput(String line) throws Exception {
    if (line.equals("")) {
      throw new Exception("Mandatory field type has not been set yet");
    }
  }

  public static void checkProperInput(String[] lineSplit) throws Exception {
    if (lineSplit.length != 2) {
      throw new Exception("Input does not follow the order -option <value>");
    }
  }

  public static void checkFirstName(String option, String name) throws Exception {
    if (name.equals("") && !option.equals(NAME_CMD)) {
      throw new Exception("Please start by entering the name using the cmd -name <your item name>");
    }
  }

  public static String extractValidName(String value) throws Exception {
    if (value.equals("")) {
      throw new Exception("Name is not supposed to be empty string");
    }
    return value;
  }

  public static Type extractValidType(String value) throws Exception {
    if (!Stream.of(Type.values()).anyMatch(v -> v.name().equals(value))) {
      throw new Exception("Enter one of the following type raw,imported or manufactured");
    }
    return Type.valueOf(value);
  }

  public static double extractValidPrice(String value) throws Exception {
    checkNumeric(value);
    double price = Double.parseDouble(value);
    if (price <= 0) {
      throw new Exception("Enter Positive Value of price only");
    }
    return price;
  }

  public static int extractValidQuantity(String value) throws Exception {
    checkNumeric(value);
    int quantity = Integer.parseInt(value);
    if (quantity <= 0) {
      throw new Exception("Enter Positive Value of quantity only");
    }
    return quantity;
  }
}
