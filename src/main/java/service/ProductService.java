package service;

import models.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductService implements ProductRepository {

       @Override
       public String add(Product product) {
              if(isProductExist(product))
                     return ERROR_PRODUCT_ALREADY_EXIST;
              return SUCCESS;
       }

       @Override
       public Product getById(UUID id) {
              for (Product product:productList) {
                     if(product.getId().equals(id))
                            return product;
              }
              return null;
       }

       @Override
       public List<Product> getList() {
              return productList;
       }

       @Override
       public boolean edit(UUID id, Product product) {
              int ind = 0;
              for(Product product1: productList){
                     if(product1.getId().equals(id)) {
                            product.setId(id);
                            productList.set(ind, product);
                            return true;
                     }
                     ind++;
              }
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              int ind = 0;
              for (Product product:productList) {
                     if(product.getId().equals(id)) {
                            productList.remove(ind);
                            return true;
                     }
                     ind++;
              }
              return false;
       }

       @Override
       public boolean removeByObj(Product product) {
              return productList.remove(product);
       }

       public boolean isProductExist(Product product){
              for (Product product1: productList) {
                     if(product.getName().equals(product1.getName()))
                            return true;
              }
              return false;
       }

       public List<Product> showDiscountList(){
              List<Product> list = new ArrayList<>();
              for (Product product:productList) {
           //          if(product.getDiscountID() > 0) {
                           list.add(product);
                    // }
              }return list;
       }

       public List<Product> showListByName(String name){
              List<Product> list = new ArrayList<>();
              for (Product product:productList) {
                     if(product.getName().startsWith(name)) {
                            list.add(product);
                     }
              }return list;
       }
}
