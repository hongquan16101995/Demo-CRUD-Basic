package controller;

import model.Product;
import model.Product_Cate;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", urlPatterns = "/home")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final ProductServiceImpl productServiceImpl = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "createGet":
                createControl(request, response);
                break;
            case "createPost":
                createProduct(request, response);
                break;
            case "editGet":
                editControl(request, response);
                break;
            case "editPost":
                editProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                display(request, response);
        }
    }

    public void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product_Cate> products = productServiceImpl.getAll();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    //?????c c??? list product v???i doGet
    public void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productServiceImpl.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    //create v???i doGet, ??i???u h?????ng sang create.jsp
    public void createControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.jsp");
    }

    //t???o m???i ?????i t?????ng v???i doPost, th??m v??o list, tr??? list cho view, ??i???u h?????ng sang view.jsp
    public void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        productServiceImpl.addProduct(new Product( name, price));
        String mess = "T???o th??nh c??ng";
        request.setAttribute("mess", mess);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        requestDispatcher.forward(request, response);
    }

    //edit v???i doGet, ??i???u h?????ng sang edit.jsp
    public void editControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServiceImpl.getProduct(id);
        if (product != null) {
            request.setAttribute("product", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    //ch???nh s???a ?????i t?????ng v???i doPost, c???p nh???t trong list, tr??? list cho view, ??i???u h?????ng sang view.jsp
    public void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServiceImpl.getProduct(id);
        if (product != null) {
            product.setName(request.getParameter("name"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            productServiceImpl.editProduct(id, product);
        }
        ArrayList<Product> products = productServiceImpl.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    //x??a ?????i t?????ng v???i doGet, tr??? list cho view, ??i???u h?????ng sang view.jsp
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
        if (product != null) {
            productService.deleteProduct(product);
        }
        ArrayList<Product> products = productService.display();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }
}
