package model;

public class Product_Cate {
    private String product_name;
    private String cate_name;

    public Product_Cate(String product_name, String cate_name) {
        this.product_name = product_name;
        this.cate_name = cate_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }
}
