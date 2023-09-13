package Service;

import Models.Order;
import Models.Restaurant;

import java.util.Map;

public class OrderService {

    Map<String, Order> restaurantOrderMappings;

    RestaurantService restService;

    public OrderService(Map<String, Order> restaurantOrderMappings, RestaurantService restService) {
        this.restaurantOrderMappings = restaurantOrderMappings;
        this.restService = restService;
    }

    public Map<String, Order> getRestaurantOrderMappings() {
        return restaurantOrderMappings;
    }

    public void setRestaurantOrderMappings(Map<String, Order> restaurantOrderMappings) {
        this.restaurantOrderMappings = restaurantOrderMappings;
    }

    public RestaurantService getRestService() {
        return restService;
    }

    public void setRestService(RestaurantService restService) {
        this.restService = restService;
    }

    public void  assignOrder(String customerName, Order order, String strategy){

        // USING BEST RATING STRATEGY
        if(strategy.equalsIgnoreCase("Highest rating")) {
            double maxRating = -1;
            String restaurantName = "";

            for (Restaurant restaurant : restService.getRestaurants()) {
                Map<String, Integer> menu = restaurant.getMenu();

                boolean isValid = checkValidity(menu, order.getItemAndQuantiy());

                if (isValid && restaurant.getCurrentOrders().size() < restaurant.getMaxOrders()) {

                    if (restaurant.getRating() > maxRating) {

                        maxRating = restaurant.getRating();
                        restaurantName = restaurant.getName();
                    }
                }

            }

            if (!restaurantName.equalsIgnoreCase("")) {
                restaurantOrderMappings.put(restaurantName, order);

                Restaurant restaurant = findRestaurant(restaurantName);
                restaurant.placeOrder(order);
                return;
            }

            System.out.println(order.getOrderName() + " could not be palced");
        }
        else{

            int minCost = Integer.MAX_VALUE;
            String restaurantName = "";

            for (Restaurant restaurant : restService.getRestaurants()) {
                Map<String, Integer> menu = restaurant.getMenu();

                boolean isValid = checkValidity(menu, order.getItemAndQuantiy());

                if (isValid && restaurant.getCurrentOrders().size() < restaurant.getMaxOrders()) {

                    if (getCost(menu,order.getItemAndQuantiy()) <minCost) {

                        minCost = getCost(menu, order.getItemAndQuantiy());
                        restaurantName = restaurant.getName();
                    }
                }

            }

            if (!restaurantName.equalsIgnoreCase("")) {
                restaurantOrderMappings.put(restaurantName, order);

                Restaurant restaurant = findRestaurant(restaurantName);
                restaurant.placeOrder(order);
                return;
            }

            System.out.println(order.getOrderName() + " could not be palced");

        }
    }

    private int getCost(Map<String, Integer> menu, Map<String, Integer> itemAndQuantiy) {

        int cost=0;

        for(String item : itemAndQuantiy.keySet()){

            cost+= (menu.get(item)* itemAndQuantiy.get(item));
        }

        return cost;
    }

    private boolean checkValidity(Map<String, Integer> menu, Map<String, Integer> itemAndQuantiy) {

        for(String item : itemAndQuantiy.keySet()){
            if(!menu.containsKey(item)){
                return false;
            }
        }

        return true;
    }

    private Restaurant findRestaurant(String restaurantName) {

        for(Restaurant restaurant: restService.getRestaurants()){
            if(restaurant.getName().equalsIgnoreCase(restaurantName)){
                return restaurant;
            }
        }

        return null;
    }
}
