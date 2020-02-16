package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String cName;
    String addr;
    List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public void getCustomerInfo(StringBuilder output) {
        output.append(getCustomerName());
        output.append(getCustomerAddress());
    }

    void getLineItemsInfo(StringBuilder output) {
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : getLineItems()) {
            lineItem.printLineItemInfo(output);
            totSalesTx += lineItem.calcSalesTax();
            tot += lineItem.calcTotalAmount();
        }
        output.append("Sales Tax").append('\t').append(totSalesTx);
        output.append("Total Amount").append('\t').append(tot);
    }
}
