package taxcalculator.validation;

import static org.junit.jupiter.api.Assertions.*;
import static taxcalculator.validation.ValidateInput.checkEmptyInput;
import static taxcalculator.validation.ValidateInput.checkFirstName;
import static taxcalculator.validation.ValidateInput.checkNumeric;
import static taxcalculator.validation.ValidateInput.checkProperInput;
import static taxcalculator.validation.ValidateInput.extractValidName;
import static taxcalculator.validation.ValidateInput.extractValidPrice;
import static taxcalculator.validation.ValidateInput.extractValidQuantity;
import static taxcalculator.validation.ValidateInput.extractValidType;
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
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckProperInputWithDifferentStrings.json")
  void testCheckProperInputWithDifferentStrings(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    String inputStringSplit[] = inputString.split(" ",2);
    String expectedErrorMessage = json.getString("errMessage");
    try{
      checkProperInput(inputStringSplit);
      assertEquals(expectedErrorMessage,"",testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testCheckFirstNameWithDifferentCommandAndNameTestCases.json")
  void testCheckFirstNameWithDifferentCommandAndName(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputCommand = json.getString("inputCommand");
    String currentName = json.getString("currentName");
    String expectedErrorMessage = json.getString("errMessage");
    try{
      checkFirstName(inputCommand,currentName);
      assertEquals(expectedErrorMessage,"",testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testExtractValidNameWithDifferentStringsTestCases.json")
  void testExtractValidNameWithDifferentStrings(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    String output = json.getString("output");
    String expectedErrorMessage = json.getString("errMessage");
    try{
      String actualName = extractValidName(inputString);
      if(expectedErrorMessage.length()!=0) fail(testcaseName);
      assertEquals(output,actualName,testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testExtractValidTypeWithDifferentStringsTestCases.json")
  void testExtractValidTypeWithDifferentStrings(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    String output = json.getString("output");
    String expectedErrorMessage = json.getString("errMessage");
    try{
      String actualType = extractValidType(inputString).toString();
      if(expectedErrorMessage.length()!=0) fail(testcaseName);
      assertEquals(output,actualType,testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testExtractValidPriceWithDifferentStringsTestCases.json")
  void testExtractValidPriceWithDifferentStrings(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    double output = Double.parseDouble(json.getString("output"));
    String expectedErrorMessage = json.getString("errMessage");
    try{
      double actualPrice = extractValidPrice(inputString);
      if(expectedErrorMessage.length()!=0) fail(testcaseName);
      assertEquals(output,actualPrice,testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/validation/validateinputtest/testExtractValidQuantityWithDifferentStringsTestCases.json")
  void testExtractValidQuantityWithDifferentStrings(JsonObject json) {
    String testcaseName = json.getString("name");
    String inputString = json.getString("inputString");
    int output = Integer.parseInt(json.getString("output"));
    String expectedErrorMessage = json.getString("errMessage");
    try{
      int actualQuantity = extractValidQuantity(inputString);
      if(expectedErrorMessage.length()!=0) fail(testcaseName);
      assertEquals(output,actualQuantity,testcaseName);
    }catch(Exception e){
      String actualErrorMessage = e.getMessage();
      assertEquals(expectedErrorMessage,actualErrorMessage,testcaseName);
    }
  }
}