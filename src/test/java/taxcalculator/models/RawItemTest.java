package taxcalculator.models;

import static org.junit.jupiter.api.Assertions.*;

import javax.json.JsonObject;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import taxcalculator.enums.Type;

class RawItemTest {

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/models/rawitemtest/testCalcTaxedCostWithDifferentPriceTestCases.json")
  void testCalcTaxedCostWithDifferentPriceGroups(JsonObject json) {
    String testcaseName = json.getString("name");
    double inputPrice = Double.parseDouble(json.get("inputPrice").toString());
    double expectedOutputPrice = Double.parseDouble(json.get("outputPrice").toString());

    RawItem item = new RawItem("Test", Type.RAW,inputPrice,0);
    double actualOutputPrice = item.calcTaxedCost() + inputPrice;

    assertEquals(expectedOutputPrice,actualOutputPrice,testcaseName);
  }
}