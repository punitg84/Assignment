package taxcalculator.models;

import static org.junit.jupiter.api.Assertions.*;

import javax.json.JsonObject;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import taxcalculator.enums.Type;

class ManufacturedItemTest {

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/models/manufactureditemtest/testCalcTaxedCostWithDifferentPriceTestCases.json")
  void testCalcTaxedCostWithDifferentPriceGroups(JsonObject json) {
    String testcaseName = json.get("name").toString();
    double inputPrice = Double.parseDouble(json.get("inputPrice").toString());
    double expectedOutputPrice = Double.parseDouble(json.get("outputPrice").toString());

    ManufacturedItem item = new ManufacturedItem("Test", Type.MANUFACTURED,inputPrice,0);
    double actualOutputPrice = item.calcTaxedCost() + inputPrice;

    assertEquals(expectedOutputPrice,actualOutputPrice,testcaseName);
  }
}