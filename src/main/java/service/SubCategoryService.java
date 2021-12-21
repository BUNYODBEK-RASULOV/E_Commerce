package service;

import models.Category;
import models.Subcategory;
import repository.SubCategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class SubCategoryService implements SubCategoryRepository {

       private UUID otherSubID;
       {
              Subcategory otherSub=new Subcategory(null,"Other");
              add(otherSub);
              otherSub.getId();
       }
       @Override
       public String add(Subcategory subcategory) {
              if (check(subcategory)) return ERROR_CATEGORY_ALREADY_EXIST;
              subcategoryList.add(subcategory);
              return SUCCESS;
       }

       @Override
       public Subcategory getById(UUID id) {
              return null;
       }

       @Override
       public List<Subcategory> getList() {
              return subcategoryList;
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
                     if(subcategory.getCatId().equals(category.getId()) ||
                            subcategory.getId().equals(otherSubID)){
                            list.add(subcategory);
                     }
              }
              return list;
       }

       public boolean check(Subcategory subcategory){
              for (Subcategory subcategory1 : subcategoryList){
                     if (subcategory.getName().equals(subcategory1.getName())) return true;
              }
              return false;
       }

}
