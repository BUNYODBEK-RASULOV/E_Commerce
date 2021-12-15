package service;

import models.Order;
import repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService implements OrderRepository {

       @Override
       public String add(Order order) {
              return null;
       }

       @Override
       public Order getById(UUID id) {
              return null;
       }

       @Override
       public List<Order> getList() {
              return null;
       }

       @Override
       public boolean edit(UUID id, Order order) {
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              return false;
       }

       @Override
       public boolean removeByObj(Order order) {
              return false;
       }

       public List<Order> userOrders(UUID userID){
              List<Order> list = new ArrayList<>();
              for (Order order:orderList) {
                     if(order.getUserID().equals(userID))
                            list.add(order);

              }
              return list;
       }
}
