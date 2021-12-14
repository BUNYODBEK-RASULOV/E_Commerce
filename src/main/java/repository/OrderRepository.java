package repository;

import models.Order;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository extends BaseRepository<Order, String, List<Order>> {
       List<Order> orderList = new ArrayList<>();
}
