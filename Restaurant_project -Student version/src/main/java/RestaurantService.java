import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {

        for (Restaurant res : restaurants){
            if(res.getName().equals(restaurantName)) return res;
        }
        throw new restaurantNotFoundException("Mentioned Restaurant Not Found!!!");
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public int getOrderValue(String name,List<String> itemList) throws restaurantNotFoundException {
        int sum = 0;
        for (String i : itemList) {
            sum = sum + findRestaurantByName(name).findItemByName(i).getPrice();
        }
        return sum;
    }

}
