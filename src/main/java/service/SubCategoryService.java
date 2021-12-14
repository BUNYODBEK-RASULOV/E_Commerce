package service;

import models.Category;
import models.Subcategory;
import repository.SubCategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class SubCategoryService implements SubCategoryRepository {

       @Override
       public String add(Subcategory subcategory) {
              return null;
       }

       @Override
       public Subcategory getById(UUID id) {
              return null;
       }

       @Override
       public List<Subcategory> getList() {
              return null;
       }

       @Override
       public boolean edit(UUID id, Subcategory subcategory) {
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              return false;
       }

       @Override
       public boolean removeByObj(Subcategory subcategory) {
              return false;
       }

       public List<Subcategory> listSubcategory(Category category){
              List<Subcategory> list = new ArrayList<>();
              for (Subcategory subcategory:subcategoryList ) {
                     if(subcategory.getCatId().equals(category.getId())){
                            list.add(subcategory);
                     }
              }
              return list;
       }
}
