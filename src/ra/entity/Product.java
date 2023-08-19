package ra.entity;

import ra.Ishop;

import java.util.List;
import java.util.Scanner;

public class Product implements Ishop {
    private String productId;
    private String productName;
    private float price;
    private String title;
    private int catalogId;
    private boolean statusProduct;

    public Product() {
    }

    public Product(String productId, String productName, float price, String title, int catalogId, boolean statusProduct) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.title = title;
        this.catalogId = catalogId;
        this.statusProduct = statusProduct;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(boolean statusProduct) {
        this.statusProduct = statusProduct;
    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList,List<Product>productList) {
        System.out.println("Nhập mã sản phẩm :");
        boolean checkProductId=true;
        do {
           try {
               this.productId= scanner.nextLine();
               boolean isExit=false;
               for (Product product:productList) {
                   if(product.productId.equals(this.productId)){
                      isExit=true;
                      break;
                   }
               }
               if(isExit){
                   System.err.println("Mã sản phẩm đã tồn tại, vui lòng nhập lại.");
               }else{
                   if(this.productId.length()==5){
                       System.err.println("Mã sản phẩm gồm 5 ký tự,vui lòng nhập lại.");
                   }else{
                       if(this.productId.charAt(0)=='P'){
                           break;
                       }else{
                           System.err.println("Mã sản phẩm bắt là ký tự P, vui lòng nhập lại.");
                       }
                   }
               }
           }catch (Exception ex){
               System.err.println("Mã sản phẩm là chuỗi ký tự, vui lòng nhập lại.");
           }
        }while (checkProductId);
        System.out.println("Nhập tên sản phẩm :");
        boolean checkProductName=true;
        do {
            try {
                this.productName=scanner.nextLine();
                boolean isExit=false;
                for (Product product:productList) {
                    if(product.productName.equals(this.productName)){
                        isExit=true;
                        break;
                    }
                }
                if(isExit){
                    System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại.");
                }else{
                    break;
                }
            }catch (Exception ex){
                System.err.println("Tên sản phẩm là một chuỗi ký tự, vui lòng nhập lại.");
            }
        }while (checkProductName);
        System.out.println("Nhập vào giá sản phẩm :");
        boolean checkPrice=true;
        do {
            try {
                this.price=Float.parseFloat(scanner.nextLine());
                if(this.price>0){
                    checkPrice=false;
                }else{
                    System.err.println("Giá sản phẩm có giá trị lớn 0, vui lòng nhập lại.");
                }
            }catch (Exception ex){
                System.err.println("Giá sản phẩm là kiểu số thực và lớn hơn 0, vui lòng nhập lại.");
            }
        }while (checkPrice);
        System.out.println("Nhập tiêu đề sản phẩm :");
        this.title= scanner.nextLine();
        System.out.println("Trạng thái của sản phẩm :");
        this.statusProduct=Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm:%s - Tên sản phẩm:%s - Giá sản phẩm:%f\n ",this.productId,this.productName,this.price);
        System.out.printf("Tiêu đề sản phẩm:%s - Mã danh mục mà sản phẩm thuộc về:%d - Trạng thái sản phẩm:%b\n",this.title,this.catalogId,this.statusProduct);
    }
}
