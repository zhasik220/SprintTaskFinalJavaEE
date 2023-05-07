package db;

import moduls.Comment;
import moduls.New;
import moduls.NewCategory;
import moduls.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/portal_news_db",
                            "zhasik",
                            "bitlab123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole_id(resultSet.getInt("role_id"));
                users.add(user);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static User getUser(String email) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM users WHERE email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public static void addUser(User user){
        try{
            PreparedStatement statement= connection.prepareStatement
                    ("INSERT INTO users (email,password,fuLL_name,role_id) " +
                            "VALUES (?,?,?,?)");
            statement.setString(1,user.getEmail());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getFullName());
            statement.setInt(4,user.getRole_id());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<New> getNewsList(){
        ArrayList<New> news=new ArrayList<>();
        try {
            PreparedStatement statement= connection.prepareStatement
                    ("SELECT * FROM news n " +
                            "INNER JOIN news_categories nc ON n.category_id=nc.id ");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                New oneNew=new New();
                oneNew.setId(resultSet.getLong("id"));
                oneNew.setTitle(resultSet.getString("title"));
                oneNew.setPost_date(resultSet.getTimestamp("post_date"));
                oneNew.setCategory_id(resultSet.getInt("category_id"));
                oneNew.setContent(resultSet.getString("content"));
                news.add(oneNew);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }

    public static void addNew(New oneNew){
        try {
            PreparedStatement statement= connection.prepareStatement
                    ("INSERT INTO news (post_date,category_id,title,content) " +
                            "VALUES (NOW(),?,?,?)");
            statement.setInt(1,oneNew.getCategory_id());
            statement.setString(2,oneNew.getTitle());
            statement.setString(3,oneNew.getContent());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<NewCategory> GetCategories(){
        ArrayList<NewCategory> categories=new ArrayList<>();
        try {
            PreparedStatement statement= connection.prepareStatement
                    ("SELECT * FROM news_categories");
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                NewCategory category=new NewCategory();
                category.setId(resultSet.getLong("id"));
                category.setName(resultSet.getString("name"));
                categories.add(category);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }


    public static void deleteUser(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE users SET full_name =?, password=? WHERE id =?");
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getPassword());
            statement.setLong(3, user.getId());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static New getNew(int id) {
        New oneNew = null;
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT * FROM news WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                oneNew = new New();
                oneNew.setId(resultSet.getLong("id"));
                oneNew.setTitle(resultSet.getString("title"));
                oneNew.setPost_date(resultSet.getTimestamp("post_date"));
                oneNew.setCategory_id(resultSet.getInt("category_id"));
                oneNew.setContent(resultSet.getString("content"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oneNew;
    }

    public static void addComment(Comment comment){
        try {
            PreparedStatement statement= connection.prepareStatement
                    ("INSERT INTO comments (comment, user_id, news_id, post_date) " +
                            "VALUES (?,?,?,NOW())");
            statement.setString(1,comment.getCommentText());
            statement.setLong(2,comment.getUser().getId());
            statement.setLong(3,comment.getOneNew().getId());
            statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> getCommentList(Long news_id){
        ArrayList<Comment> comments=new ArrayList<>();
        try {
            PreparedStatement statement= connection.prepareStatement
                    ("SELECT c.id,c.comment,c.post_date,c.user_id,u.full_name, u.role_id " +
                            "FROM comments c " +
                            "INNER JOIN users u ON u.id=c.user_id " +
                            "WHERE c.news_id=? ORDER BY c.post_date DESC");
            statement.setLong(1,news_id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                Comment comment=new Comment();
                User user=new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
                New oneNew=new New();
                oneNew.setId((long) news_id);
                comment.setId(resultSet.getLong("id"));
                comment.setUser(user);
                comment.setOneNew(oneNew);
                comment.setPost_date(resultSet.getTimestamp("post_date"));
                comment.setCommentText(resultSet.getString("comment"));
                comments.add(comment);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

    public static void deleteNew(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM comments WHERE news_id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();

            statement = connection.prepareStatement(
                    "DELETE FROM news WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void updateNew(New oneNew) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE n, c FROM news n " +
                    "INNER JOIN comments c ON n.id = c.news_id WHERE n.id = ?\n");
            statement.setString(1, oneNew.getTitle());
            statement.setString(2, oneNew.getContent());
            statement.setInt(3,oneNew.getCategory_id());
            statement.setLong(4, oneNew.getId());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteComment(int id){
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("DELETE FROM comments WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateComment(Comment comment){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE comments SET  comment=? WHERE id =?");
            statement.setString(1, comment.getCommentText());
            statement.setLong(2, comment.getId());
            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}