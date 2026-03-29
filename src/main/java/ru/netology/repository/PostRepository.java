package ru.netology.repository;

import ru.netology.model.Post;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс репозитория
 */
public interface PostRepository {
    /** Получить все объекты Post */
    List<Post> all();
    /** Получить объект по идентификатору */
    Optional<Post> getById(long id);
    /** Сохранить объект в репозитории */
    Post save(Post post);
    /** Удалить объект из репозитория по идентификатору */
    void removeById(long id);
}
