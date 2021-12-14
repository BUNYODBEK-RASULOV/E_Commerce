package front;

import models.Product;
import models.auth.Admin;
import service.ProductService;
import utils.Input;

import java.time.LocalDate;
import java.util.UUID;

public class AdminFront {
       static ProductService productService = new ProductService();
       public static void main(Admin admin) {
              int stepCode = 1;

              while(stepCode != 0){
                     stepCode = Input.getNum("|>1.Product\n|>2.SubCategory\n|>3.Order List\n|>0.Back");

                     switch (stepCode){
                            case 1:
                                   withProduct( admin.getId());
                                   break;
                            case 2:

                                   break;
                     }
              }
       }

       //Product
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
                     }
              }
       }

       private static void createProduct(UUID adminID){
              Product product = new Product();

              boolean check;
              do {
                     product.setName(Input.getStr("Enter name: "));
                     check = productService.isProductExist(product);
              }while (!check);
              product.setCreatedById(adminID);
              product.setPrice(Input.getDouble("Enter price: "));
              product.setDiscount(Input.getDouble("Enter discount percent: "));
              product.setCreateDate(LocalDate.now());
              System.out.println(productService.add(product));
       }

       private  static  void editProduct(){
              int ind = 1;

              for (Product product: productService.getList()) {
                     System.out.println(ind + ". " + product);
                     ind++;
              }

              int choice = Input.getNum("Enter choice: ");
              Product product = productService.getList().get(choice - 1);
              boolean check;
              do {
                     product.setName(Input.getStr("Enter name: "));
                     check = productService.isProductExist(product);
              }while (!check);
              product.setPrice(Input.getDouble("Enter price: "));
              product.setDiscount(Input.getDouble("Enter discount percent: "));
              product.setUpdateDate(LocalDate.now());
              productService.edit(product.getId(), product);

       }

}
