package ru.netology.repository;

import ru.netology.model.Post;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

// Stub
public class PostRepository {
    private final List<Post> repo = new CopyOnWriteArrayList<>();

    public List<Post> all() {
        return repo;
    }

    public Optional<Post> getById(long id) {
        return Optional.of(repo.get((int)id));
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            repo.add(post);
            post.setId(repo.lastIndexOf(post));
        } else {
            repo.remove((int) post.getId());
            repo.add((int) post.getId(), post);
        }
        return post;
    }

    public void removeById(long id) {
        repo.remove((int)id);
    }
}