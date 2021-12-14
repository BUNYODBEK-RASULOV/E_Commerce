package front;


import enums.auth.Role;
import enums.internationalization.Language;
import models.*;
import models.auth.User;
import repository.SubCategoryRepository;
import service.*;
import utils.Input;
import utils.Print;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserFront {


    public static void main(String[] args) {
        main(new User("bek","1111","1111", Role.User, Language.UZ));
    }
    static ProductService productService = new ProductService();
    static CartService cartService = new CartService();
    static CategoryService categoryService = new CategoryService();
    static SubCategoryService subCategoryService = new SubCategoryService();
    static CategoryProductService categoryProductService = new CategoryProductService();

    public static void main(User user) {
        Print.print("WELCOME " + user.getName() + "\n");

        int stepCode = 1;

        while (stepCode != 0) {
            stepCode = Input.getNum("|>1.Discounts\n|>2.Categories\n|>3.Search\n|>4.My Cart\n5.Order History\n");

            switch (stepCode) {
                case 1:
                    withDiscounts();
                    break;
                case 2:
                    withCategories();
                    break;
                case 3:
                    withSearch();
                    break;
                case 4:

                    break;
            }
        }
    }

    // Discounts
    public static void withDiscounts(){
        int ind = 1;
        List<Product> list = productService.showDiscountList();
        if(list.size() == 0) System.out.println("List is empty!");
        for (Product product: list) {
                System.out.println(ind + ". " + product);
        }
    }

    public static void buyProduct(List<Product> list, CartProduct cart){
       int index = Input.getNum("Enter index");
        int choice;
        do {
            Print.print("|>1.Buy  |>2.Detailed Info |>3.Add Cart |> 0.Exit");
            choice = Input.getNum("choice");
            switch (choice){
                case 1:

                    break;
                case 2:
                    System.out.println(list.get(index));
                    break;
                case 3:
                    CartProduct cartProduct = new CartProduct(cart.getUserID(), list.get(index).getId(),0, LocalDate.now());

                    break;
            }
        }while (choice != 0);
    }

    // Categories
    public static void withCategories(){
        int ind = 1;
        List<Category> list = categoryService.getList();
        for (Category category: list) {
            System.out.println(ind + ". " + category);
        }
        int stepCode = 1;
        while (stepCode != 0){
            stepCode = Input.getNum("|>Select: ");
            if(list.size() == 0) {
                System.out.println("Category is empty!");
                break;
            }
            else if(stepCode < 0 || list.size() < stepCode) System.out.println("Enter correct value!");
            else showSubCategories(list.get(stepCode - 1));
        }
    }

    private static void showSubCategories(Category category){
        int ind = 1;
        List<Subcategory> list = subCategoryService.listSubcategory(category);
        for (Subcategory subcategory : list) {
            System.out.println(ind + ". " + subcategory);
            ind++;
        }

        int stepCode = 1;
        while (stepCode != 0){
            stepCode = Input.getNum("|>Select: ");

            if(stepCode < 0 || list.size() < stepCode) System.out.println("Enter correct value!");
            else if(stepCode == 0){
                System.out.println("SubCategory is empty!");
            break;}
            else showProducts(list.get(stepCode - 1));
        }
    }
    private static void showProducts(Subcategory subcategory){
        int ind = 1;
        List<CategoryProduct> list = categoryProductService.getList();
        for (CategoryProduct categoryProduct: list) {
            System.out.println(ind++ + ". " + categoryProductService.getById(categoryProduct.getProductId()));
        }
        int stepCode = 1;
        while (stepCode != 0){
            stepCode = Input.getNum("|>Select: ");

            if(stepCode < 0 || list.size() < stepCode) System.out.println("Enter correct value!");
            else if(stepCode == 0){
                System.out.println("Product List is empty!");
                break;}
            else System.out.println("Buy product");;
        }
    }

    // Search
    public static void withSearch(){
        String stepCode = "";
        while (!stepCode.equals("0")){
                stepCode = Input.getStr("|>Enter product name\n|>0.Back\n");
                if(stepCode.equals("0"))break;
                else{
                    List<Product> list = new ArrayList<>();
                    productService.showListByName(stepCode);
                    if(list.size() == 0 ) System.out.println("List is empty!");
                    else {
                        int ind = 0;
                        for (Product product : list) {
                            System.out.println(ind++ + ". " + product);
                        }

                        int choice = Input.getNum("|>Select(0.Back):");
                        if (choice > 0 && choice <= list.size()) {
                            //buy
                        }
                    }
                }
            }
        }

    //My Cart
    public static void withMyCart(){
        int ind = 0;
        if(cartService.getList().size() == 0) System.out.println("Your Cart is empty");
        for (CartProduct cardProduct: cartService.getList()) {
            System.out.println(ind++ + ". " + cardProduct);
        }
    }
}

