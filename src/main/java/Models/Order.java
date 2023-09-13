package Models;

import java.util.Map;

public class Order {

    String orderName;

    String status;

    Map<String, Integer> itemAndQuantiy;

    public Order(String name,String status, Map<String, Integer> itemAndQuantiy) {
        this.orderName = name;
        this.status = status;
        this.itemAndQuantiy = itemAndQuantiy;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Integer> getItemAndQuantiy() {
        return itemAndQuantiy;
    }

    public void setItemAndQuantiy(Map<String, Integer> itemAndQuantiy) {
        this.itemAndQuantiy = itemAndQuantiy;
    }
}
