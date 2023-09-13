package Service;

import Models.Restaurant;

import java.util.List;

public class RestaurantService {

    List<Restaurant> restaurants;

    public RestaurantService(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void onboardRestaurant(Restaurant restaurant){
        restaurants.add(restaurant);
    }
}
