package repository;

import models.Cart;

import java.util.ArrayList;
import java.util.List;

public interface CartRepository extends BaseRepository<Cart, String, List<Cart>> {
       List<Cart> cartList = new ArrayList<>();
}
