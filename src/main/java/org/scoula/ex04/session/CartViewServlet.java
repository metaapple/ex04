package org.scoula.ex04.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cart_view")
public class CartViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>장바구니 목록</h1>");
        out.println("<hr>");
        HttpSession session = req.getSession(false);
        if (session != null) {
            ArrayList<String> list = ( ArrayList<String>) session.getAttribute("product");
            out.println("<h1>" + list + "</h1>");
        }else{
            out.println("세션이 없음.");
        }
        out.println("<a href='session_product.jsp'>장바구니 추가 화면으로 이동</a><br>");
        out.println("<a href='cart_delete'>장바구니 삭제 화면으로 이동</a>");
        out.println("</body></html>");
    }
}
