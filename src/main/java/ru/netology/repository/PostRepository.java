package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
    private final ConcurrentHashMap<Long, Post> repo = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Post> all() {
        return new ArrayList<>(repo.values());
    }

    public Optional<Post> getById(long id) {
        return Optional.of(repo.get(id));
    }

    public Post save(Post post) {
        long postId = post.getId();
        if (postId == 0) {
            long newPostId = idCounter.getAndIncrement();
            post.setId(newPostId);
            repo.put(newPostId,post);
        } else {
            repo.put(postId,post);
        }
        return post;
    }

    public void removeById(long id) {
        repo.remove(id);
    }
}