package taxcalculator.validation;

import static org.junit.jupiter.api.Assertions.*;
import static taxcalculator.validation.ValidateInput.checkEmptyInput;
import static taxcalculator.validation.ValidateInput.checkNumeric;
import static taxcalculator.validation.ValidateInput.isEndInput;

import javax.json.JsonObject;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.params.ParameterizedTest;
import taxcalculator.enums.Type;

class ValidateInputTest {


  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckNumericWithDifferentStringsTestCases.json")
  void testCheckNumericWithDifferentString(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    String expectedErrorMessage = json.getString("errMessage");
    try{
      checkNumeric(inputString);
      assertEquals(expectedErrorMessage,"",testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testIsEndPutWithDifferentStringAndNullorNotNullTypeTestCases.json")
  void testIsEndPutWithDifferentStringAndNullorNotNullType(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    String inputType = json.getString("inputType");
    boolean expectedOutput = Boolean.parseBoolean(json.getString("output"));
    Type type=null;
    if(!inputType.equals("")) type=Type.valueOf(inputType.toUpperCase());
    boolean actualOuput = isEndInput(inputString,type);
    assertEquals(expectedOutput,actualOuput,testcaseName);
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckEmptyInputOnEmptyAndNonEmptyStringsTestCases.json")
  void testCheckEmptyInputOnEmptyAndNonEmptyStrings(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    String expectedErrorMessage = json.getString("errMessage");
    try{
      checkEmptyInput(inputString);
      assertEquals(expectedErrorMessage,"",testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckNumericWithDifferentStringsTestCases.json")
  void checkProperInput() {
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckNumericWithDifferentStringsTestCases.json")
  void checkFirstName() {
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckNumericWithDifferentStringsTestCases.json")
  void extractValidName() {
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckNumericWithDifferentStringsTestCases.json")
  void extractValidType() {
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckNumericWithDifferentStringsTestCases.json")
  void extractValidPrice() {
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckNumericWithDifferentStringsTestCases.json")
  void extractValidQuantity() {
  }
}