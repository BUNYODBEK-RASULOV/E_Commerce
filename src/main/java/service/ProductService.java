package service;

import models.Product;
import repository.ProductRepository;

import java.util.List;
import java.util.UUID;

public class ProductService implements ProductRepository {

       @Override
       public String add(Product product) {
              return null;
       }

       @Override
       public Product getById(UUID id) {
              return null;
       }

       @Override
       public List<Product> getList() {
              return null;
       }

       @Override
       public boolean edit(UUID id, Product product) {
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              return false;
       }

       @Override
       public boolean removeByObj(Product product) {
              return false;
       }
}
