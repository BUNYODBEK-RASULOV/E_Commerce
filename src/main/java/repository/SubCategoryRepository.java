package repository;

import models.Subcategory;

import java.util.ArrayList;
import java.util.List;

public interface SubCategoryRepository extends BaseRepository<Subcategory, String, List<Subcategory>> {
       List<Subcategory> subcategoryList = new ArrayList<>();
}
