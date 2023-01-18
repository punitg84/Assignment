package taxcalculator.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.json.JsonObject;
import net.joshka.junit.json.params.JsonFileSource;
import org.junit.jupiter.params.ParameterizedTest;
import taxcalculator.enums.Type;

class ImportedItemTest {

  @ParameterizedTest
  @JsonFileSource(resources = "/taxcalculator/models/importeditemtest/testCalcTaxedCostWithDifferentPriceGroupsTestCases.json")
  void testCalcTaxedCostWithDifferentPriceGroups(JsonObject json) {
    String testcaseName = json.getString("name");
    double inputPrice = Double.parseDouble(json.get("inputPrice").toString());
    double expectedOutputPrice = Double.parseDouble(json.get("outputPrice").toString());

    ImportedItem item = new ImportedItem("Test", Type.IMPORTED,inputPrice,0);
    double actualOutputPrice = item.calcTaxedCost() + inputPrice;

    assertEquals(expectedOutputPrice,actualOutputPrice,testcaseName);
  }
}