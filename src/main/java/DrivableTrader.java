/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

public class DrivableTrader<T> extends Trader<T> {

    public DrivableTrader(List<T> inventory, List<T> wishlist, int money) {
        super(inventory, wishlist, money);
    }

    public DrivableTrader(int money){
        super(money);
    }

    @Override
    public void addToWishlist(T item){
        if (item instanceof Drivable){
            super.addToWishlist(item);
        }
    }

    @Override
    public int getSellingPrice(T item){
        if ((item instanceof Tradable) && (item instanceof Drivable)){
            return ((Tradable) item).getPrice() + ((Drivable)item).getMaxSpeed();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }

}
