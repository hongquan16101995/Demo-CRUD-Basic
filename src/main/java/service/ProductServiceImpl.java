package service;

import connection.MyConnection;
import model.Product;
import model.Product_Cate;

import java.sql.*;
import java.util.ArrayList;

//class service triển khai interface service kết nối database
public class ProductServiceImpl implements IProductService{
    //các câu lênh truy vấn viết dưới dạng truy vấn động, các tham số
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO product (name, price) VALUES (?, ?);";
    private static final String SELECT_PRODUCTS_BY_ID = "select * from product where id = ?";
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String DELETE_PRODUCTS_SQL = "delete from product where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update product set name = ?,price= ? where id = ?;";
    private static final String NAME_PRODUCT_NAME_CATEGORY = "select name_cate, name from product join category on product.cate_id = category.id;";

    //khởi tạo drive để lấy connection
    private final MyConnection myConnection = new MyConnection();

    public ArrayList<Product_Cate> getAll() {
        ArrayList<Product_Cate> product_cate = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            //dùng connection truy vấn đến database bằng câu lệnh truy vấn
            PreparedStatement preparedStatement = connection.prepareStatement(NAME_PRODUCT_NAME_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product_cate.add(new Product_Cate( resultSet.getString("name"), resultSet.getString("name_cate")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product_cate;
    }
    
    @Override
    public Product getProduct(int id) {
        Product product = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_ID);
            //thêm tham số cho câu lệnh truy vấn
            preparedStatement.setInt(1, id);
            //tập hợp các kết quả trả về từ câu truy vấn dưới dạng 1 tập hợp
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product = new Product( resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getDouble("price"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                products.add(new Product(id, name, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

//    @Override
//    public ArrayList<Product> getAllProducts() {
//        ArrayList<Product> products = new ArrayList<>();
//        try {
//            Connection connection = myConnection.getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PRODUCTS);
//            while (resultSet.next()){
//                products.add(new Product(resultSet.getInt("id"), resultSet.getString("name"),
//                        resultSet.getDouble("price")));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return products;
//    }

    @Override
    public void addProduct(Product product) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteProduct(Product product) {

    }

    @Override
    public void editProduct(int id, Product product) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
