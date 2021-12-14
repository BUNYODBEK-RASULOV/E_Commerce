package front;


import models.Cart;
import models.CartProduct;
import models.Product;
import models.auth.User;
import service.CartProductService;
import service.CartService;
import service.ProductService;
import utils.Input;
import utils.Print;
import java.time.LocalDate;
import java.util.List;


public class UserFront {

    static ProductService productService = new ProductService();
    static CartService cartService = new CartService();
    static CartProductService cartProductService = new CartProductService();
    public static void main(User user) {
        Print.print("WELCOME" + user.getName());

        int stepCode = 1;

        while (stepCode != 0) {
            stepCode = Input.getNum("|>1.`Discounts`  |>2.Categories  |>3.Search  |>4.My Cart  |>5.Call Back");

            switch (stepCode) {
                case 1:
                    showDiscounts();

                    buyProduct(productService.showDiscountList(), cartService.getById(user.getId()));
                    break;
                case 2:
                    //show categories
                    break;
                case 3:
                    // search
                    break;
                case 4:

                    break;
            }
        }
    }

    public static List<Product> showDiscounts(){
        int ind = 1;
        List<Product> list = productService.showDiscountList();
        for (Product product: list) {
            if(product.getDiscount() > 0)
                System.out.println(ind + ". " + product);
        }
        return list;
    }

    public static void buyProduct(List<Product> list, Cart cart){
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
                    CartProduct cartProduct = new CartProduct(cart.getId(), list.get(index).getId(),0, LocalDate.now());
                    cartProduct.setCartID(cart.getUserID());
                    cartProductService.add(cartProduct);
                    break;
            }
        }while (choice != 0);
    }
}
