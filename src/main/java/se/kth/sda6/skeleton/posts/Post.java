package se.kth.sda6.skeleton.posts;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.dao.DataAccessException;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;

// @TODO add Hibernate annotations to define which table and columns should be used to save the Post Object.
@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Please provide a message to post")
    @Column(name = "body")
    @Length(min = 1, max=250, message = "Post message length must be between 10-250 characters")
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Date modifyDate;


   // @OneToMany(mappedBy = "post",
    // cascade = CascadeType.ALL)
   // private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public Post(String body) { this.body = body; }

    public Long getId() {
        return id;
    }

    //public void setId(Long id) { this.id = id; }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreateDate() {return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    //    public void addComment(Comment comment) {
//        comments.add( comment );
//        comment.setPost( this );
//    }
//
//    public void removeComment(Comment comment) {
//        comments.remove( comment );
//        comment.setPost( null );
//    }
}
