package com.example.restfulwebservices.person;

import com.example.restfulwebservices.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Person details")
@Entity
public class Person {

    @Id
    private Long id;

    @Size(min=2)
    private String name;

    @Past
    private Date dateOfBirth;

    @OneToMany(mappedBy = "person",
            fetch = FetchType.LAZY)
    private List<Post> posts;

    public Person() {
    }

    public Person(Long id, @Size(min = 2) String name, @Past Date dateOfBirth, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
