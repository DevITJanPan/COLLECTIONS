package ra.entity;

import ra.Ishop;

import java.util.List;
import java.util.Scanner;

public class Categories implements Ishop {
    private int catalogId;
    private String catalogName;
    private boolean status;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, boolean status) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.status = status;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList,List<Product>productList) {
        System.out.println("Nhập vào mã danh mục :");
        boolean checkCatalogId = true;
        do {
            try {
                this.catalogId = Integer.parseInt(scanner.nextLine());
                boolean isExit = false;
                for (Categories categories : categoriesList) {
                    if (categories.catalogId == this.catalogId) {
                        isExit = true;
                        break;
                    }
                }
                if (isExit) {
                    System.err.println("Mã danh mục sản phẩm đã tồn tại, vui lòng nhập lại.");
                } else {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Mã danh mục phải là số nguyên,vui lòng nhập lại.");
            }
        } while (checkCatalogId);
        System.out.println("Nhập tên danh mục sản phẩm :");
        boolean checkCatalogName = true;
        do {
            try {
                this.catalogName = scanner.nextLine();
                boolean isExit = false;
                for (Categories categories : categoriesList) {
                    if (categories.catalogName.equals(this.catalogName)) {
                        isExit = true;
                        break;
                    }
                }
                if (isExit) {
                    System.err.println("Tên danh mục sản phẩm đã tồn tại, vui lòng nhập lại.");
                } else {
                    break;
                }

            } catch (Exception ex) {
                System.err.println("Tên danh mục phải là một chuỗi các ký tự, vui lòng nhập lại.");
            }
        } while (checkCatalogName);
        System.out.println("Nhập vào trạng thái danh mục :");
        try {
            this.status = Boolean.parseBoolean(scanner.nextLine());
        } catch (Exception ex) {
            System.err.println("Trạng thái danh mục sản phẩm là kiểu số thực, vui lòng nhập lại.");
        }
    }

    @Override
    public void displayData() {
        System.out.printf("Mã danh mục:%d - Tên danh mục:%s - Trạng thái danh mục:%b\n", this.catalogId, this.catalogName, this.status);
    }
}
