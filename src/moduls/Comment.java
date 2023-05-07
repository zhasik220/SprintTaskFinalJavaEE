package moduls;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private User user;
    private New oneNew;
    private String commentText;
    private Timestamp post_date;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public New getOneNew() {
        return oneNew;
    }

    public void setOneNew(New oneNew) {
        this.oneNew = oneNew;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Timestamp getPost_date() {
        return post_date;
    }

    public void setPost_date(Timestamp post_date) {
        this.post_date = post_date;
    }
}
