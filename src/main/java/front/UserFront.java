package front;

import enums.auth.Role;
import enums.internationalization.Language;
import models.*;
import models.auth.User;
import service.*;
import utils.Input;
import utils.Print;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public class UserFront {

    static User user;

    public static void main(String[] args) {
        main(new User("bek","1111","1111", Role.User, Language.UZ));
    }
    static ProductService productService = new ProductService();
    static CartService cartService = new CartService();
    static DiscountService discountService = new DiscountService();
    static CategoryService categoryService = new CategoryService();
    static SubCategoryService subCategoryService = new SubCategoryService();
    static CategoryProductService categoryProductService = new CategoryProductService();
    static OrderService orderService = new OrderService();

    public static void main(User user1) {
        user = user1;
        Print.print("WELCOME " + user1.getName() + "\n");

        int stepCode = 1;

        while (stepCode != 0) {
            stepCode = Input.getNum("|>1.Discounts\n|>2.Categories\n|>3.Search\n|>4.My Cart\n|>5.Order History\n");

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
                    withMyCart();
                    break;
                case 5:
                    withOrderHistory();
                    break;
            }
        }
    }

    // Discounts
    public static void withDiscounts(){
        int ind = 1;
        List<Discount> list = discountService.getList();
        if(list.size() == 0) System.out.println("List is empty!");
        else {
            int cnt = 1;
            for (Discount discount:list) {
                System.out.println(cnt++ + ". " + discount);
            }
            int index = Input.getNum("Enter index");
            while (true){
                 if(index == 0)break;
                else if(index < 1 || index > list.size()){
                    System.out.println("Enter correct value: ");
                }else{
                    showDiscountProducts(list.get((index - 1)));
                    break;
                 }


            }
        }
    }
    private static void showDiscountProducts(Discount discount){
        List<Product> list = productService.showDiscountList(discount.getId());
        if(list.size() == 0) System.out.println("List is empty!");
        else {
            int cnt = 1;
            for (Product product:list) {
                System.out.println(cnt++ + ". " + product);
            }
            int choice = Input.getNum("Enter index");
            while (true){
                if(choice == 0)break;
                else if(choice < 1 || choice > list.size()){
                    System.out.println("Enter correct value: ");
                }else{
                    buyProduct(list.get(choice - 1));
                    break;
                }


            }
        }
    }

    public static void buyProduct( Product product){

        int choice;
        do {
            Print.print("|>1.Buy  |>2.Detailed Info |>3.Add Cart |> 0.Exit");
            choice = Input.getNum("choice");
            switch (choice){
                case 1:
                    buy(product);
                    break;
                case 2:
                    System.out.println(product);
                    break;
                case 3:
                   cartAddProduct(product);

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
        while (stepCode != 0) {
            if (list.size() == 0) {
                System.out.println("Category is empty!");
                break;
            } else {
                stepCode = Input.getNum("|>Select: ");

                if (stepCode < 0 || list.size() < stepCode) System.out.println("Enter correct value!");
                else showSubCategories(list.get(stepCode - 1));
            }
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
            else list.get(stepCode);
        }
    }

    // Search
    public static void withSearch(){
        int stepCode  = 1;
        while (stepCode != 0){
                String productName = Input.getStr("Enter product name: ");

                    List<Product> list = productService.showListByName(productName);
                    if(list.size() == 0 || list == null) {
                        System.out.println("List is empty!");
                        break;
                    }

                    else {
                        int ind = 0;
                        for (Product product : list) {
                            System.out.println(ind++ + ". " + product);
                        }

                        int choice = Input.getNum("|>Select(0.Back):");
                        if (choice > 0 && choice <= list.size()) {
                            buyProduct(list.get(choice));
                        }
                    }

            }
        }

    //My Cart
    public static void withMyCart(){
        int ind = 0;
        double sum = 0;
        if(cartService.userCartList(user.getId()) == null || cartService.userCartList(user.getId()).size() == 0) System.out.println("Your Cart is empty");
        else {
            for (CartProduct cardProduct : cartService.userCartList(user.getId())) {
                System.out.println(ind++ + ". " + cardProduct);
                sum += cardProduct.getAmount();
            }
            System.out.println("Total Summa " +  sum);
        }
    }
    private static void MyOrder(UUID userID, List<CartProduct> list){
        int stepCode = 1;

        while (stepCode != 0){
            stepCode = Input.getNum("|>1.Buy Products\n|>2.Remove Products\n|>0.Back\n");
            switch (stepCode){
                case 1:
                    for (CartProduct cartProduct:list) {
                        giveOrder(userID, cartProduct);
                    }
                    break;
                case 2:
                    for (CartProduct cartProduct:list) {
                        cartService.removeByObj( cartProduct);
                    }
                    break;
            }
        }
    }

    private static void giveOrder(UUID userID, CartProduct product){
        Order order = new Order();
        order.setUserID(userID);
        order.setAmount(product.getAmount());
        order.setProductID(product.getProductID());
        order.setLocation(Input.getStr("Enter your location :"));
        order.setComment(Input.getStr("Comment: "));
        orderService.add(order);
        cartService.removeByObj(product);

    }

    public static void buy( Product product){
        Order order = new Order();
        order.setUserID(user.getId());
        order.setAmount(product.getPrice());
        order.setProductID(product.getId());
        order.setLocation(Input.getStr("Enter your location :"));
        order.setComment(Input.getStr("Comment: "));
        System.out.println(orderService.add(order));
    }

    public static  void  cartAddProduct(Product product){
        CartProduct cartProduct =  new CartProduct();
        cartProduct.setUserID(user.getId());
        cartProduct.setProductID(product.getId());
        cartProduct.setAmount(Input.getDouble("Enter amount: "));
        cartProduct.setLocalDate(LocalDate.now());
        System.out.println(cartService.add(cartProduct));
    }

    public static void withOrderHistory(){
        List<Order> list = orderService.userOrders(user.getId());
        int ind = 1;
        if(list.size() == 0) System.out.println("Order List is empty!");
        else {
            for (Order order : list) {
                System.out.println(ind++ + ". " + order);
            }
        }
    }
}

