package ru.netology.service;

import ru.netology.model.Post;

import java.util.List;

public interface PostService {
    List<Post> all();
    Post getById(long id);
    Post save(Post post);
    void removeById(long id);
}
