package se.kth.sda6.skeleton.posts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
    @TODO AutoWire PostService and create the methods needed to implement the API.
    Don't forget to add necessary annotations.
 */

@RestController
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> get()
    {
        List<Post> posts = postService.getAll();
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);

     }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> get(@PathVariable("id") Long id)
    {
        Post post = postService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find post with id " + id.toString()));
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> post(@RequestBody Post post)
    {
        Post savedPost = postService.save(post);
        return new ResponseEntity<Post>(savedPost, HttpStatus.CREATED);
    }

    @PutMapping ("/posts")
    public ResponseEntity<Post> put(@RequestBody Post post)
    {
        Post savedPost = postService.update(post)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Could not find post with id " + post.getId().toString()));
        return new ResponseEntity<Post>(savedPost, HttpStatus.ACCEPTED);
    }

    @DeleteMapping ("/posts")
    public ResponseEntity delete(@RequestBody Post post)
    {
        postService.deleteById(post.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping ("/posts/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id)
    {
        postService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
