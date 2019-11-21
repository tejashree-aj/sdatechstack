package se.kth.sda6.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    @TODO Autowire the PostRepository and use it to implement all the service methods.
 */

@Service()
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll() {
        // @TODO get all posts and return them as List<Post>
        return postRepository.findAll().stream().sorted(Comparator.comparing(Post::getCreateDate)
                .reversed()).collect(Collectors.toList());
    }

    public Optional<Post> getByID(Long id) {
        // @TODO get a post by ID if it exists
        return  postRepository.findById(id);
    }


    public Post save(Post post) {
        // @TODO save the post to DB and return the saved post
        return postRepository.save(post);
    }

    public Optional<Post> update(Post post) {
        // @TODO update the post if it exists in DB and return the updated post.
        Optional<Post> existingPost = postRepository.findById(post.getId());
        if(existingPost.isPresent())
        {
            existingPost.get().setBody(post.getBody());
            postRepository.save(existingPost.get());
        }
        return existingPost;
    }

    public void deleteById(Long id) {
        // @TODO delete the post by id
        postRepository.deleteById(id);
    }
}
