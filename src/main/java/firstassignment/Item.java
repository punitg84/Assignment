package firstassignment;

public class Item {
    private static final double PERCENTAGE_TAX_ON_RAW_ITEM_ON_COST = 12.5;
    private static final double PERCENTAGE_TAX_ON_MANUFACTURED_ITEM_ON_COST = 12.5;
    private static final double PERCENTAGE_TAX_ON_MANUFACTURED_ITEM_ON_TAXED_COST = 2;
    private static final int PERCENTAGE_TAX_ON_IMPORTED_ITEM_ON_COST = 10;
    private static final int SURCHARGE_TAX_AMOUNT_ON_TAXED_COST_BELOW_100 = 5;
    private static final int SURCHARGE_TAX_AMOUNT_ON_TAXED_COST_BELOW_200_AND_ABOVE_100 = 10;
    private static final int SURCHARGE_TAX_PERCENTAGE_ON_TAXED_COST_ABOVE_200 = 5;

    private enum Type {
        RAW,
        MANUFACTURED,
        IMPORTED
    }

    private String name;
    private int price;
    private int quantity;
    private Type type;
    private double taxedCost;
    Item(){
        //Default Constructor
    }

    Item(String name,String type,int price,int quantity,double taxedCost){
        this.name=name;
        this.type=Type.valueOf(type.toUpperCase());
        this.price=price;
        this.quantity=quantity;
        this.taxedCost = taxedCost;
    }

    public double getTaxedCost() {
        return taxedCost;
    }
    public double calcTaxedCost(){
        double taxedCost = 0;
        switch (type) {
            case RAW:
                taxedCost = (price * PERCENTAGE_TAX_ON_RAW_ITEM_ON_COST) / 100.0;
                break;
            case IMPORTED:
                taxedCost = (price * PERCENTAGE_TAX_ON_IMPORTED_ITEM_ON_COST) / 100.0;
                if (price+taxedCost <= 100) taxedCost += SURCHARGE_TAX_AMOUNT_ON_TAXED_COST_BELOW_100;
                else if (price+taxedCost <= 200) taxedCost += SURCHARGE_TAX_AMOUNT_ON_TAXED_COST_BELOW_200_AND_ABOVE_100;
                else taxedCost += ((taxedCost + price) * SURCHARGE_TAX_PERCENTAGE_ON_TAXED_COST_ABOVE_200) / 100.0;
                break;
            case MANUFACTURED:
                taxedCost = (price * PERCENTAGE_TAX_ON_MANUFACTURED_ITEM_ON_COST) / 100.0;
                taxedCost += ((price + taxedCost) * PERCENTAGE_TAX_ON_MANUFACTURED_ITEM_ON_TAXED_COST) / 100.0;
                break;
        }
        return taxedCost;
    }
    public void setTaxedCost(double taxedCost) {
        this.taxedCost = taxedCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        type=type.toUpperCase();
        this.type = Type.valueOf(type);
    }

}