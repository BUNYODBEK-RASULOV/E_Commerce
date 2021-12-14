package service;

import models.Cart;
import repository.CartRepository;

import java.util.List;
import java.util.UUID;

public class CartService implements CartRepository {

       @Override
       public String add(Cart cart) {
              return null;
       }

       @Override
       public Cart getById(UUID id) {
              return null;
       }

       @Override
       public List<Cart> getList() {
              return null;
       }

       @Override
       public boolean edit(UUID id, Cart cart) {
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              return false;
       }

       @Override
       public boolean removeByObj(Cart cart) {
              return false;
       }
}
