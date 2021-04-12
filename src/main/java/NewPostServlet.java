import model.Posts;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NewPostServlet")
public class NewPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Posts post = new Posts();
        boolean st = false;
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String topic = request.getParameter("topic");
        String text = request.getParameter("text");
        HttpSession adminSession = request.getSession(false);
        Users user = (Users) request.getSession().getAttribute("loggedUser");

        if(!topic.equals("") && !text.equals("")){
            post.setTopic(topic);
            post.setText(text);
            post.setLike(0);
            post.setDislike(0);
            post.setUserId(user.getId());
            st = new DAO().newPost(post);
            if(st){
                out.println("<script>alert('Post successfully added!')</script>");
                adminSession.setAttribute("message","Post successfully added!" );
                response.sendRedirect("ListOfPosts.jsp");
            }else{
                out.println("<script>alert('Error ! This kind of post already exists in the base')</script>");
                adminSession.setAttribute("message","Error ! Try again!" );
                response.sendRedirect("ListOfPosts.jsp");
            }
        }else{
            out.println("<script>alert('Try again !')</script>");
            response.sendRedirect("ListOfPosts.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
