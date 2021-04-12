import model.Posts;
import model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaEE", "postgres", "123");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static boolean validate(String email, String pass) {
        boolean status = false;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/PhoneStore", "postgres", "123");
            // getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from users where email=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public boolean newPost(Posts posts) {
        try {
            Connection con = DAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into posts(topic,text,likePost,dislike,userID) values (?,?,?,?,?)");
            ps.setString(1, posts.getTopic());
            ps.setString(2, posts.getText());
            ps.setInt(3, posts.getLike());
            ps.setInt(4, posts.getDislike());
            ps.setInt(5, posts.getUserId());
            con.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public Posts getPostByID(int id){
        Posts post = null;
        try {
            Connection con = DAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM posts WHERE id=?");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int postId = rs.getInt(1);
                String topic = rs.getString(2);
                String text = rs.getString(3);
                int like = rs.getInt(4);
                int dislike = rs.getInt(5);
                int userId = rs.getInt(6);
                post = new Posts();
                post.setId(postId);
                post.setUserId(userId);
                post.setTopic(topic);
                post.setText(text);
                post.setLike(like);
                post.setDislike(dislike);

            }

        }catch (Exception ex) {
            ex.printStackTrace();}
        return post;
    }

    public ArrayList<Posts> getAllPost(){
        ArrayList<Posts> posts = new ArrayList<>();
        try {
            Connection con = DAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM posts");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int postId = rs.getInt(1);
                String topic = rs.getString(2);
                String text = rs.getString(3);
                int like = rs.getInt(4);
                int dislike = rs.getInt(5);
                int userId = rs.getInt(6);
                Posts post = new Posts();
                post.setId(postId);
                post.setUserId(userId);
                post.setTopic(topic);
                post.setText(text);
                post.setLike(like);
                post.setDislike(dislike);
                posts.add(post);
            }

        }catch (Exception ex) {
            ex.printStackTrace();}
        return posts;
    }


    public void updateLikes(Posts post) {
        try {
            Connection con = DAO.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update posts set likePost=?,dislike=? where id=?");
            ps.setInt(1, post.getLike());
            ps.setInt(2, post.getDislike());
            ps.setInt(3, post.getId());
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean delete(int id) {

        try {
            Connection con = DAO.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from posts where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean editPost(Posts p){

        try{
            Connection con= DAO.getConnection();
            PreparedStatement ps=con.prepareStatement("UPDATE posts SET topic = ?, text = ? WHERE id = ?");
            ps.setString(1,p.getTopic());
            ps.setString(2,p.getText());
            ps.setInt(3,p.getId());
            ps.executeUpdate();
            con.close();
            return true;
        }catch(Exception e){e.printStackTrace();}

        return false;
    }
}