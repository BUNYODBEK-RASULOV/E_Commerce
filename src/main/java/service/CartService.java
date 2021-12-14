package service;

import models.CartProduct;
import repository.CartRepository;

import java.util.List;
import java.util.UUID;

public class CartService implements CartRepository {

       @Override
       public String add(CartProduct cartProduct) {
              return null;
       }

       @Override
       public CartProduct getById(UUID id) {
              return null;
       }

       @Override
       public List<CartProduct> getList() {
              return null;
       }

       @Override
       public boolean edit(UUID id, CartProduct cartProduct) {
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              return false;
       }

       @Override
       public boolean removeByObj(CartProduct cartProduct) {
              return false;
       }
       public List<CartProduct> userCartList(UUID ID) {
              return null;
       }

}
