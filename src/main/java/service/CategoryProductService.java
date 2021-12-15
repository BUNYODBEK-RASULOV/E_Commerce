package service;

import models.CartProduct;
import models.CategoryProduct;
import models.Subcategory;
import repository.CartProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryProductService implements CartProductRepository {

       @Override
       public String add(CategoryProduct categoryProduct) {
              return null;
       }

       @Override
       public String add(CartProduct cartProduct) {
              return null;
       }

       @Override
       public CategoryProduct getById(UUID id) {
              return null;
       }

       @Override
       public List<CategoryProduct> getList() {
              return null;
       }

       @Override
       public boolean edit(UUID id, CartProduct cartProduct) {
              return false;
       }

       @Override
       public boolean edit(UUID id, CategoryProduct categoryProduct) {
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

       @Override
       public boolean removeByObj(CategoryProduct categoryProduct) {
              return false;
       }

       public List<CategoryProduct> listSubCategory(Subcategory subcategory){
              List<CategoryProduct> list = new ArrayList<>();
              for (CategoryProduct categoryProduct: categoryProductList) {
                     if(categoryProduct.getSubCategoryId().equals(categoryProduct.getSubCategoryId()))
                            list.add(categoryProduct);
              }
              return list;
       }
}
