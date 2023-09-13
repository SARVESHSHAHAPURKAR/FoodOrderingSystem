package Main;

import Models.Order;
import Models.Restaurant;
import Service.OrderService;
import Service.RestaurantService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Restaurant> restaurantList = new ArrayList<>();
        Map<String, Order> restaurantOrderMappings = new HashMap<>();

        RestaurantService restaurantService = new RestaurantService(restaurantList);
        OrderService orderService = new OrderService(restaurantOrderMappings,restaurantService);

        Order ongoingOrder = null;
        Map<Integer, Order> orderMappings = null;

        Queue<Order> currentOrdersR1 = new ArrayDeque<>();
        Map<String, Integer> menu1 = new HashMap<>();
        menu1.put("Veg Biryani" ,100);
        menu1.put("Paneer Butter Masala",150);

        Restaurant R1= new Restaurant("R1",menu1,4,5,ongoingOrder,orderMappings,currentOrdersR1);
        restaurantService.onboardRestaurant(R1);

        Queue<Order> currentOrdersR2 = new ArrayDeque<>();
        Map<String, Integer> menu2 = new HashMap<>();

        menu2.put("Paneer Butter Masala",175);
        menu2.put("Idli",10 );
        menu2.put("Dosa",50) ;
        menu2.put("Veg Biryani",80);

        Restaurant R2=  new Restaurant("R2",menu2,4,5,ongoingOrder,orderMappings,currentOrdersR2);
        restaurantService.onboardRestaurant(R2);

        Queue<Order> currentOrdersR3 = new ArrayDeque<>();
        Map<String, Integer> menu3 = new HashMap<>();

        menu3.put("Gobi Manchurian",150);
        menu3.put("Idli",15);
        menu3.put("Paneer Butter Masala",175);
        menu3.put("Dosa",30);

        Restaurant R3 = new Restaurant("R3",menu3,5,1,ongoingOrder,orderMappings,currentOrdersR3);
        restaurantService.onboardRestaurant(R3);

        R1.add("Chicken65",250);
        R2.update("Paneer Butter Masala",150);

        Map<String, Integer> o1 = new HashMap<>();
        o1.put("Idli",3);
        o1.put("Dosa",1);

        Order order1 = new Order("Order1",null,o1);

        orderService.assignOrder("Ashwin",order1,"Lowest cost");

        Map<String, Integer> o2 = new HashMap<>();
        o2.put("Idli",3);
        o2.put("Dosa",1);

        Order order2 = new Order("Order2",null,o2);
        orderService.assignOrder("Harish",order2,"COst");

        Map<String, Integer> o3 = new HashMap<>();
        o3.put("Veg Biryani",3);

        Order order3 = new Order("Order3", null, o3);
        orderService.assignOrder("Shruthi", order3,"Highest rating");

        R3.completeOrder("Order1");

        Map<String, Integer> o4 = new HashMap<>();
        o4.put("Idli",3);
        o4.put("Dosa",1);

        Order order4 = new Order("Order4",null,o4);
        orderService.assignOrder("Harish",order4,"cost");

        Map<String, Integer> o5 = new HashMap<>();
        o5.put("Idli",1);
        o5.put("Paneer Tikka",1);

        Order order5 = new Order("Order5", null, o5);
        orderService.assignOrder("xyz",order5,"cost");





    }
}