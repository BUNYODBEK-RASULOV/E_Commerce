package service;

import models.Category;
import repository.CategoryRepository;

import java.util.List;
import java.util.UUID;

public class CategoryService implements CategoryRepository {

       @Override
       public String add(Category category) {
              if(isCategoryExist(category))
                     return ERROR_CATEGORY_ALREADY_EXIST;
              categoryList.add(category);
              return SUCCESS;
       }

       @Override
       public Category getById(UUID id) {
              for (Category category: categoryList) {
                     if(category.getId().equals(id))
                            return category;
              }
              return null;
       }

       @Override
       public List<Category> getList() {
              return categoryList;
       }

       @Override
       public boolean edit(UUID id, Category category) {
              for (int i = 0; i < categoryList.size(); i++) {
                     if (categoryList.get(i).getId().equals(id)){
                            category.setId(id);
                            categoryList.set(i, category);
                            return true;
                     }
              }
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              for (int i = 0; i < categoryList.size(); i++) {
                     if (categoryList.get(i).getId().equals(id)){
                            categoryList.remove(i);
                            return true;
                     }
              }return false;
       }

       @Override
       public boolean removeByObj(Category category) {
              return categoryList.remove(category);
       }

       public String blockCategory(int i){
             if(i > 0 && i < categoryList.size())return SUCCESS;
             return ERROR_CATEGORY_IS_NOT_FOUND;
       }

       private boolean isCategoryExist(Category category1){
              for (Category category: categoryList) {
                     if(category.getName().equals(category1.getName()))
                            return  true;
              }return false;
       }
}