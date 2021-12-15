package front;

import enums.auth.Role;
import models.Category;
import models.CategoryProduct;
import models.auth.Admin;
import models.auth.AutUser;
import service.AuthUserService;
import service.CategoryService;
import utils.Input;

import java.util.ArrayList;
import java.util.List;

public class SuperAdminFront {
       static CategoryService categoryService = new CategoryService();
       static AuthUserService authUserService = new AuthUserService();
       public static void main() {
              int stepCode = 1;

              while (stepCode != 0){
                     stepCode = Input.getNum("|>1.Category\n|>2.Admin\n|>3.History\n");

                     switch (stepCode) {
                            case 1 -> withCategory();
                            case 2 -> withAdmin();
                     }
              }
       }
       // Category
       public static void withCategory(){
              int stepCode = 1;

              while (stepCode != 0 ){
                     stepCode = Input.getNum("""
                             |>1.Create Category
                             |>2.Update Category
                             |>3.Delete Category
                             |>4.Category List""");
                     switch (stepCode) {
                            case 1 -> createCategory();
                            case 2 -> updateCategory();
                            case 3 -> deleteCategory();
                            case 4 -> showList();
                     }
              }
       }

       private static void createCategory(){
              Category category = new Category();
              category.setName(Input.getStr("Enter name: "));
              category.setInfo(Input.getStr("Enter extra info: "));
              System.out.println(categoryService.add(category));
       }

       private static void updateCategory(){

              showList();
              int choice = Input.getNum("Enter choice: ");
              List<Category> list = categoryService.getList();
              if(list == null || list.size() == 0) System.out.println("Category is empty!");
              else if(choice < 0 || choice > list.size())
                     System.out.println("Enter correct value!");
              else {
                     Category category = list.get(choice - 1);
                     category.setName(Input.getStr("Enter name: "));
                     category.setInfo("Enter extra info: ");
                     System.out.println(categoryService.edit(category.getId(), category));
              }
       }

       private static void showList(){
              int ind = 1;
              for (Category category:categoryService.getList()) {
                     System.out.println(ind + ". " + category);
                     ind++;
              }
       }

       private static void deleteCategory(){
              showList();
              int choice = Input.getNum("Enter choice: ");
              System.out.println(categoryService.blockCategory(choice - 1));
       }

       // Admin
       public static void withAdmin(){
              int stepCode = 1;
              while (stepCode != 0){
                     stepCode = Input.getNum("|>1.Add Admin\n|>2.Edit Admin\n|>3.Admin List\n");
                     switch (stepCode) {
                            case 1 -> createAdmin();
                            case 2 -> editAdmin();
                            case 3 -> showAdminList();
                     }
              }
       }

       private static void createAdmin(){
              Admin admin = new Admin();
              boolean check;
              String number;
              do{
                     number = Input.getStr("Enter phone number: ");
                     check = authUserService.checkPhoneNumber(number);
              }while (check);
              admin.setPhoneNumber(number);
              admin.setName(Input.getStr("Enter name: "));
              admin.setCreateCategoryIsActivity(Input.getNum("Can Admin create category?(0 or 1") == 1);
              admin.setDeleteProductIsActivity(Input.getNum("Can Admin delete product?(0 or 1") == 1);
              admin.setCreateProductIsActivity(Input.getNum("Can Admin create product?(0 or 1") == 1);
              System.out.println(authUserService.add(admin));
       }

       private static void editAdmin(){

              showAdminList();
              int choice = Input.getNum("Enter choice: ");
              Admin admin = showAdminList().get(choice - 1);
              boolean check;
              String number;
              do{
                     number = Input.getStr("Enter phone number: ");
                     check = authUserService.checkPhoneNumber(number);
              }while (check);
              admin.setPhoneNumber(number);
              admin.setName(Input.getStr("Enter name: "));
              admin.setCreateCategoryIsActivity(Input.getNum("Can Admin create category?(0 or 1)") == 1);
              admin.setDeleteProductIsActivity(Input.getNum("Can Admin delete product?(0 or 1)") == 1);
              admin.setCreateProductIsActivity(Input.getNum("Can Admin create product?(0 or 1)") == 1);
              System.out.println(authUserService.edit(admin.getId(), admin));
       }private static List<Admin> showAdminList(){
              int ind = 1;
              List<Admin> admins = new ArrayList<>();
              for (AutUser autUser:authUserService.getList()) {
                     if(autUser.getRole() == Role.ADMIN){
                            System.out.println(ind + ". " + autUser);
                            admins.add((Admin) autUser);
                            ind++;
                     }
              }return admins;
       }



}
