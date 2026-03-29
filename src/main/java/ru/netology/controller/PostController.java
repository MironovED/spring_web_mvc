package ru.netology.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

public interface PostController {
    void all(HttpServletResponse resp) throws IOException;

    void getById(long id, HttpServletResponse resp);

    void save(Reader body, HttpServletResponse response) throws IOException;

    void removeById(long id, HttpServletResponse resp);
}
