package com.rest.webservice.restful_web_services.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restful_web_services.dao.PostServiceImplementation;
import com.rest.webservice.restful_web_services.dao.UserServiceImplementation;
import com.rest.webservice.restful_web_services.entity.HelloWorldBean;
import com.rest.webservice.restful_web_services.entity.Post;
import com.rest.webservice.restful_web_services.entity.Users;
import com.rest.webservice.restful_web_services.exceptions.PostNotFoundException;
import com.rest.webservice.restful_web_services.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jpa") // Added this to group all JPA related mappings under /jpa
public class JpaUserController {

    private final UserServiceImplementation userServiceImplementation;
    private PostServiceImplementation postServiceImplementation;
	MessageSource messageSource;
    public JpaUserController(UserServiceImplementation userServiceImplementation,
			PostServiceImplementation postServiceImplementation, MessageSource messageSource) {
		super();
		this.userServiceImplementation = userServiceImplementation;
		this.postServiceImplementation = postServiceImplementation;
		this.messageSource = messageSource;
	}


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello Welcome to rest api";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello_world");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathvariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("hello world, %s", name));
    }

    @GetMapping("/users")
    public List<Users> allUsers() {
        return userServiceImplementation.findAll();
    }
    @GetMapping("/users/{user_id}/posts")
    public List<Post> allPostOfUser(@PathVariable int user_id) {
    	Optional<Users> user = userServiceImplementation.findById(user_id);
    	 if (user.isEmpty()) {
             throw new UserNotFoundException("id:" + user_id);
         }
    	 System.out.println("getting posts"+ user.get().getPosts());
    	 return user.get().getPosts();
    }
    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) throws URISyntaxException {
        Users savedUser = userServiceImplementation.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedUser);
    }
    @PostMapping("/users/{user_id}/posts")
    public ResponseEntity<Post> createPostOfUser(@PathVariable int user_id, @Valid @RequestBody Post post) {
        Optional<Users> user = userServiceImplementation.findById(user_id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + user_id);
        }
        
        post.setUsers(user.get());
        Post savedPost = postServiceImplementation.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedPost);
    
//    	 return user.get().getPosts();
    	 
    }

    @GetMapping("/users/{id}")
    public EntityModel<Users> searchUsersById(@PathVariable int id) {
        Optional<Users> user = userServiceImplementation.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<Users> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(getClass()).allUsers());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping("/users/{id}")
    public Users deleteUser(@PathVariable int id) {
        Optional<Users> user = userServiceImplementation.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        userServiceImplementation.deleteById(id);
        return user.get();
    }
    @DeleteMapping("/users/{user_id}/posts/post_id")
    public Users deleteUsersPost(@PathVariable int user_id,@RequestBody int post_id) {
        Optional<Users> user = userServiceImplementation.findById(user_id);
        Optional<Post> post = postServiceImplementation.findById(post_id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + user_id);
        }
        if (post.isEmpty() || post.get().getUsers().getId() != user_id) {
            throw new PostNotFoundException("Post ID: " + post_id + " for User ID: " + user_id);
        }
        postServiceImplementation.delete(post.get());
        return user.get();
    }

    @GetMapping("/helloInternational")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "default Message", locale);
    }
}
