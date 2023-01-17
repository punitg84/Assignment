package itemTaxCalculator;

import itemTaxCalculator.models.Item;
import itemTaxCalculator.ItemCollection;
import itemTaxCalculator.Main;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    void compare(List<Item> First, List<Item> Second){
        assertEquals(First.size(),Second.size(),"No of items added are different");
        for(int i=0;i<First.size();i++){
            Item FirstCurr = First.get(i),SecondCurr=Second.get(i);
            assertEquals(FirstCurr.getName(),SecondCurr.getName(),"Name is different");
            assertEquals(FirstCurr.getQuantity(),SecondCurr.getQuantity(),"Quantity is different");
            assertEquals(FirstCurr.getPrice(),SecondCurr.getPrice(),"Price is different");
            assertEquals(FirstCurr.getTaxedCost(),SecondCurr.getTaxedCost(),"Taxed Cost is different");
            assertEquals(FirstCurr.getType(),SecondCurr.getType(),"Type is different");
        }
    }

    void addInput(StringBuilder input,String ...cmds){
        for(int i=0;i< cmds.length-1;i++){
            input.append(cmds[i]+"\n");
        }
        input.append("\n" + cmds[cmds.length-1] + "\n");
    }
    @org.junit.jupiter.api.Test
    void main() {
        StringBuilder input = new StringBuilder();
        addInput(input,"-name item1","-type raw","y");
        addInput(input,"-name item2","-type raw","-quantity 5","y");
        addInput(input,"-name item3","-type raw","-price 100","y");
        addInput(input,"-name item4","-type manufactured","-price 100","y");
        addInput(input,"-name item5","-type imported","-price 10","y");
        addInput(input,"-name item6","-type imported","-price 100","y");
        addInput(input,"-name item7","-type imported","-price 200","y");
        addInput(input,"-name item8","-type imported","-price -200","y");
        addInput(input,"-name item9","-type imported","-quantity -200","y");
        addInput(input,"-name item10","-type imported","-quantity not int value","y");
        addInput(input,"-name item11","-type imported","-price not int value","y");
        addInput(input,"-name item12","-type imported","-type random","n");
        System.setIn(new ByteArrayInputStream((input.toString()).getBytes()));
        Main.main(new String[0]);

        ItemCollection itemCollection = new ItemCollection();
        itemCollection.addItem(new Item("item1","raw",0,0,0));
        itemCollection.addItem(new Item("item2","raw",0,5,0));
        itemCollection.addItem(new Item("item3","raw",100,0,12.5));
        itemCollection.addItem(new Item("item4","manufactured",100,0,14.75));
        itemCollection.addItem(new Item("item5","imported",10,0,6));
        itemCollection.addItem(new Item("item6","imported",100,0,20));
        itemCollection.addItem(new Item("item7","imported",200,0,31));
        itemCollection.addItem(new Item("item8","imported",0,0,0));
        itemCollection.addItem(new Item("item9","imported",0,0,0));
        itemCollection.addItem(new Item("item10","imported",0,0,0));
        itemCollection.addItem(new Item("item11","imported",0,0,0));
        itemCollection.addItem(new Item("item12","imported",0,0,0));

        compare(itemCollection.getItemList(),Main.itemCollection.getItemList());
    }
}