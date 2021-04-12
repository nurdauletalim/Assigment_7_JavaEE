import model.Posts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditPostServlet")
public class EditPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postId = (int) request.getSession().getAttribute("postId");
        String topic= request.getParameter("topic");
        String text = request.getParameter("text");
        Posts post = new Posts();
        HttpSession adminSession = request.getSession(false);

        boolean st = false;
        PrintWriter out = response.getWriter();
        if(!topic.equals("") && !text.equals("") && postId != 0){
            post.setId(postId);
            post.setTopic(topic);
            post.setText(text);
            try {
                st = new DAO().editPost(post);
            } catch (Exception e) {
                adminSession.setAttribute("exception",e);
                e.printStackTrace();
            }
            if(st){
                response.sendRedirect("ListOfPosts.jsp");
            }else{
                response.sendRedirect("ListOfPosts.jsp");
            }
        }else{
            out.println("<script>alert('Try again')</script>");
            response.sendRedirect("PostList.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        Posts post = new Posts();

        if(postId != null && !(postId.equals(""))){
            try {
                post = new DAO().getPostByID(Integer.parseInt(postId));
            } catch (Exception e) {
                request.getSession().setAttribute("exception",e.getMessage());
            }
            request.getSession().setAttribute("post", post);
            request.getSession().setAttribute("postId", post.getId());
            response.sendRedirect("EditPost.jsp");
        }else{
            response.sendRedirect("ListOfPosts.jsp");
        }
    }
}
