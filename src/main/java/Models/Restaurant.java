package Models;

import java.util.Map;
import java.util.Queue;

public class Restaurant {

    String name;
    Map<String, Integer> menu;
    double rating;
    int maxOrders;

    Order ongoingOrder;

    Map<Integer, Order> orderMappings;

    Queue<Order> currentOrders;

    public Restaurant(String name, Map<String, Integer> menu, double rating, int maxOrders, Order ongoingOrder, Map<Integer, Order> orderMappings, Queue<Order> currentOrders) {
        this.name = name;
        this.menu = menu;
        this.rating = rating;
        this.maxOrders = maxOrders;
        this.ongoingOrder = ongoingOrder;
        this.orderMappings = orderMappings;
        this.currentOrders = currentOrders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Integer> menu) {
        this.menu = menu;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(int maxOrders) {
        this.maxOrders = maxOrders;
    }

    public Order getOngoingOrder() {
        return ongoingOrder;
    }

    public void setOngoingOrder(Order ongoingOrder) {
        this.ongoingOrder = ongoingOrder;
    }

    public Map<Integer, Order> getOrderMappings() {
        return orderMappings;
    }

    public void setOrderMappings(Map<Integer, Order> orderMappings) {
        this.orderMappings = orderMappings;
    }

    public Queue<Order> getCurrentOrders() {
        return currentOrders;
    }

    public void setCurrentOrders(Queue<Order> currentOrders) {
        this.currentOrders = currentOrders;
    }

    public void placeOrder(Order order) {
        System.out.println(order.getOrderName()+" assigned to "+this.getName());
        currentOrders.add(order);
    }

    public void updateMenu(Map<String, Integer> newMenu){
        this.setMenu(newMenu);
    }

    public void completeOrder(String orderName){
        if(!currentOrders.isEmpty() && currentOrders.peek().getOrderName().equalsIgnoreCase(orderName)){

            Order order = currentOrders.poll();
            order.setStatus("COMPLETED");

            System.out.println(orderName+" is completed by "+this.getName());
        }
    }

    public void update(String name, int price){

        menu.put(name,price);
    }

    public void add(String name, int price){
        menu.put(name, price);
    }
}
