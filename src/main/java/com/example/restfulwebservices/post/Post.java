package com.example.restfulwebservices.post;

import com.example.restfulwebservices.person.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Post details")
@Entity
@JsonIgnoreProperties({ "person"})
public class Post {

    @Id
    private Long id;

    @Size(min=2)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    public Post() {
    }

    public Post(Long id, @Size(min = 2) String description, Person person) {
        this.id = id;
        this.description = description;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
