package ra;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.List;
import java.util.Scanner;

public interface Ishop {
    void inputData(Scanner scanner, List<Categories>categoriesList, List<Product>productList);
    void displayData();
}
