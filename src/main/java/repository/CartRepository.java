package repository;

import models.CartProduct;

import java.util.ArrayList;
import java.util.List;

public interface CartRepository extends BaseRepository<CartProduct, String, List<CartProduct>> {
       List<CartProduct> cartProductList = new ArrayList<>();
}
