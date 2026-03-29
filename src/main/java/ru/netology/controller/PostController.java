package ru.netology.controller;

import ru.netology.model.Post;

import java.util.List;

public interface PostController {
    List<Post> all();

    Post getById(long id);

    Post save(Post post);

    void removeById(long id);
}
