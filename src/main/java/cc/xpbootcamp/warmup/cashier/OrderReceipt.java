package cc.xpbootcamp.warmup.cashier;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printHeaders(output);
        printCustomerInfo(output);
        printsLineItems(output);
        return output.toString();
    }

    private void printsLineItems(StringBuilder output) {
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            lineItem.printLineItemInfo(output);
            totSalesTx += lineItem.calcSalesTax();
            tot += lineItem.calcTotalAmount();
        }
        printsTheStateTax(output, totSalesTx);
        printTotalAmount(output, tot);
    }


    private void printTotalAmount(StringBuilder output, double tot) {
        output.append("Total Amount").append('\t').append(tot);
    }

    private void printsTheStateTax(StringBuilder output, double totSalesTx) {
        printsTheStateTax(output, totSalesTx, "Sales Tax");
    }

    private void printsTheStateTax(StringBuilder output, double totSalesTx, String s) {
        output.append(s).append('\t').append(totSalesTx);
    }

    private void printCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }


    private void printHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }
}
