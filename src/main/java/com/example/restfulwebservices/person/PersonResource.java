package com.example.restfulwebservices.person;

import com.example.restfulwebservices.person.exceptions.PersonNotFoundException;
import com.example.restfulwebservices.post.Post;
import com.example.restfulwebservices.post.PostService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController()
@RequestMapping("persons")
public class PersonResource {

    private PersonService personService;
    private PostService postService;
    private MessageSource messageSource;

    public PersonResource(PersonService personService, PostService postService, MessageSource messageSource) {
        this.personService = personService;
        this.postService = postService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.findALl();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        Person person = personService.findOne(id);
        if(person==null)
            throw new PersonNotFoundException(
                    messageSource.getMessage("person.notfound.error.message",null,
                            LocaleContextHolder.getLocale())
            );
        return person;
    }

    @PostMapping
    public ResponseEntity createPerson(@Valid @RequestBody Person person){
        Person savedPerson = personService.createPerson(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPerson.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getPostsPersonById(@PathVariable Long userId){
        Person person = personService.findOne(userId);
        if(person==null)
            throw new PersonNotFoundException(
                    messageSource.getMessage("person.notfound.error.message",null,
                            LocaleContextHolder.getLocale())
            );
        return person.getPosts();
    }

    @PostMapping("/{userId}/post")
    public ResponseEntity getPostsPersonById(@PathVariable Long userId, @RequestBody Post post){
        Person person = personService.findOne(userId);
        if(person==null)
            throw new PersonNotFoundException(
                    messageSource.getMessage("person.notfound.error.message",null,
                            LocaleContextHolder.getLocale())
            );
        post.setPerson(person);
        Post savedPost = postService.createPost(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
