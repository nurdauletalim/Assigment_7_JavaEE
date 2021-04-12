import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetAllPostServlet")
public class GetAllPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    DAO dao = new DAO();
        List<?> posts = null;
        try {
            posts = dao.getAllPost();
        }catch (Exception e) {
            request.getSession().setAttribute("exception",e.getMessage());
        }
        request.getSession().setAttribute("posts",posts);
        response.sendRedirect("Main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
