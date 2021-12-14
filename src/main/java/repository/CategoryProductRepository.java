package repository;

import models.CategoryProduct;

import java.util.ArrayList;
import java.util.List;

public interface CategoryProductRepository extends BaseRepository<CategoryProduct, String, List<CategoryProduct>> {
       List<CategoryProduct> categoryProductList = new ArrayList<>();
}
