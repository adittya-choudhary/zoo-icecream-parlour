import com.zoo.vo.Menu;
import com.zoo.calculator.Order;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainParlour {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {

//        String promo = "Buy 6 Get 3 halves Price";
//        //translate "half" to it's number equivalent, empty all the alphabets
//        promo = promo.replaceAll("(?i)half|halves", "0.5").replaceAll("[a-zA-Z]", "").trim();
//
//        // Replace all the consecutive white spaces with a single space
//        promo = promo.replaceAll(" +", " ");
//
//        String[] numArr = promo.split(" ");
//
//        System.out.println("Total Order: " + promo);

        // Initializing the menu as given in the spec
        List<Menu> spec = new ArrayList<>();
        spec.add(new Menu("Rocky Road", 8, "Buy 2 Get 1 Free"));
        spec.add(new Menu("Cookies & Cream", 10, "Buy 2 Get 1 Half Price"));
        spec.add(new Menu("Netflix & Chill", 12, null));

        // placing the order as given in the requirement
        Order finalOrder = new Order();
        finalOrder.addToOrderList(spec.get(0), 1);
        finalOrder.addToOrderList(spec.get(1), 3);
        finalOrder.addToOrderList(spec.get(2), 2);

        //calculate the totals for the above order placed
        finalOrder.calculateTotalOrder();
        System.out.println("Total Order: " + df.format(finalOrder.getTotalOrder()));
        System.out.println("Total Promos: " + df.format(finalOrder.getTotalPromo()) );
        System.out.println("Total To Pay: " + df.format(finalOrder.getTotalBill()) );

        // placing the order as given in the requirement
        Order secondOrder = new Order();
        secondOrder.addToOrderList(spec.get(0), 4);
        secondOrder.addToOrderList(spec.get(1), 6);
        secondOrder.addToOrderList(spec.get(2), 1);

        //calculate the totals for the above order placed
        secondOrder.calculateTotalOrder();
        System.out.println(" ** Second Order Totals **");
        System.out.println("Total Order: " + df.format(secondOrder.getTotalOrder()));
        System.out.println("Total Promos: " + df.format(secondOrder.getTotalPromo()) );
        System.out.println("Total To Pay: " + df.format(secondOrder.getTotalBill()) );
    }
}
