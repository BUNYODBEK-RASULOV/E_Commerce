package repository;

import models.Discount;

import java.util.ArrayList;
import java.util.List;

public interface DiscountRepository extends BaseRepository<Discount, String, List<Discount>>{
    List<Discount> discountList = new ArrayList<>();
}
