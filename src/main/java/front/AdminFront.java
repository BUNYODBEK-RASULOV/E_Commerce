package front;

import models.Product;
import models.Subcategory;
import models.auth.Admin;
import service.ProductService;
import service.SubCategoryService;
import utils.Input;

import java.time.LocalDate;
import java.util.UUID;

public class AdminFront {
       static ProductService productService = new ProductService();
       static SubCategoryService subCategoryService = new SubCategoryService();

       public static void main(Admin admin) {
              int stepCode = 1;

              while(stepCode != 0){
                     stepCode = Input.getNum("|>1.Product\n|>2.SubCategory\n|>3.Order List\n|>0.Back");

                     switch (stepCode){
                            case 1:
                                   withProduct(admin.getId());
                                   break;
                            case 2:
                                   withSubCategory(admin.getId());
                                   break;
                            case 3:
                                   break;
                     }
              }
       }

/////////////////////////////////////////////////////     PRODUCT     //////////////////////////////////////////////////
       public static void withProduct(UUID adminID){
              int stepCode = 1;

              while (stepCode != 0){
                     stepCode = Input.getNum("|>1.Create Product\n|>2.Edit Product\n|>3.Delete Product\n" +
                             "|>4.Announce Discounts\n" + "|>5.Product List\n|>0.Back");
                     switch (stepCode){
                            case 1:
                                   createProduct(adminID);
                                   break;
                            case 2:
                                   editProduct();
                                   break;
                            case 3:
                                   deleteProduct();
                                   break;
                            case 4:
                                   break;
                            case 5:
                                   productList();
                                   break;
                     }
              }
       }

       private static void createProduct(UUID adminID){
              Product product = new Product();

              boolean check;
              int count = 0;
              do {
                     check = false;
                     if (count == 3) {
                            System.out.println("Error !!!");
                            return ;
                     }
                     product.setName(Input.getStr("Enter name: "));
                     check = productService.isProductExist(product);
                     if (check) System.out.println("This name already exist! Try again.");
                     count++;
              }while (check);
              product.setCreatedById(adminID);
              product.setPrice(Input.getDouble("Enter price: "));
              product.setCreateDate(LocalDate.now());
              productService.add(product);
       }



       private  static  void editProduct(){

              productList();

              int choice = Input.getNum("Enter choice: ");
              Product product = productService.getList().get(choice - 1);
              boolean check;
              int count = 0;
              do {
                     if (count == 3) {
                            System.out.println("Error !!!");
                            return ;
                     }
                     product.setName(Input.getStr("Enter name: "));
                     check = productService.isProductExist(product);
                     if (check) System.out.println("This name already exist! Try again.");
              }while (!check);
              product.setPrice(Input.getDouble("Enter price: "));
              product.setUpdateDate(LocalDate.now());
              productService.edit(product.getId(), product);
       }

       private static void deleteProduct(){
              productList();

              int choice = Input.getNum("Enter choice: ");
              Product product = productService.getList().get(choice - 1);
              int ind = 0;
              for (Product product1 : productService.getList()){
                     if (product.getId().equals(product1.getId())){
                           productService.getList().get(ind).setActivity(false);
                           return ;
                     }
                     ind++;
              }
       }

       public static void productList() {
              int ind = 0;
              for (Product product : productService.getList()){
                     System.out.println(++ind + ". " + product.getName());
              }
       }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////  CATEGORY  ////////////////////////////////////////////////////////////////
       public static void withSubCategory(UUID adminID){
              int stepCode = 1;

              while (stepCode != 0){
                     stepCode = Input.getNum("|>1.Create SubCategory\n|>2.Edit SubCategory\n|>3.Delete SubCategory\n" +
                             "|>4.SubCategory List\n|>0.Back");
                     switch (stepCode){
                            case 1:
                                   createSubCategory();
                                   break;
                            case 2:
                                   editSubCategory();
                                   break;
                            case 3:
                                   deleteSubcategory();
                                   break;
                            case 4:
                                   subCategoryList();
                                   break;
                     }
              }
       }


       public static void createSubCategory(){
              Subcategory subcategory = new Subcategory();

              boolean check;
              int count = 0;
              do{
                     if (count == 3){
                            System.out.println("Error !!!");
                            return;
                     }
                     subcategory.setName(Input.getStr("Enter name: "));
                     check = subCategoryService.check(subcategory);
                     if (check) System.out.println("This name already exist! Try again.");
                     count++;

              }while (!check);
              subCategoryService.add(subcategory);
       }

       public static void editSubCategory(){

              subCategoryList();

              int choice = Input.getNum("Enter choice: ");
              Subcategory subcategory = subCategoryService.getList().get(choice);
              boolean check;
              int count = 0;
              do {
                     check = false;
                     if (count == 3){
                            System.out.println("Error !!!");
                            return ;
                     }
                     subcategory.setName(Input.getStr("Enter name: "));
                     check = subCategoryService.check(subcategory);
                     if (check) System.out.println("This name already exist! Try again.");
                     count++;
              }while(check);
              subCategoryService.getList().set(choice - 1, subcategory);

       }

       public static void deleteSubcategory(){
              subCategoryList();
              int choice = Input.getNum("Enter choice: ");
              Subcategory subcategory = subCategoryService.getList().get(choice - 1);
              int ind = 0;
              for (Subcategory subcategory1 : subCategoryService.getList()){
                     if (subcategory.getName().equals(subcategory1.getName())){
                            subcategory1.setActivity(false);
                            subCategoryService.getList().set(ind, subcategory1);
                            return ;
                     }
              }
       }

       public static void subCategoryList(){
              int ind = 0;
              for (Subcategory subcategory : subCategoryService.getList()){
                     System.out.println(++ind + ". " + subcategory.getName());
              }
       }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
