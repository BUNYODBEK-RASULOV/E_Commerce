package service;

import models.Discount;
import repository.DiscountRepository;

import java.util.List;
import java.util.UUID;

public class DiscountService implements DiscountRepository {
       @Override
       public String add(Discount discount) {
              if (check(discount)) return "Unsuccessful!";
              discountList.add(discount);
              return SUCCESS;
       }

       @Override
       public Discount getById(UUID id) {
              for (Discount discount : discountList)
                     if (discount.getId() == id) return discount;
              return null;
       }

       @Override
       public List<Discount> getList() {
              return discountList;
       }

       @Override
       public boolean edit(UUID id, Discount discount) {
              return false;
       }

       @Override
       public boolean removeById(UUID id) {
              return false;
       }

       @Override
       public boolean removeByObj(Discount discount) {
              return false;
       }

       public boolean check(Discount discount){
              for (Discount discount1 : discountList){
                     if (discount.getName().equals(discount1.getName())) return true;
              }
              return false;
       }


}