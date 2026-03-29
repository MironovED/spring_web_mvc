package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Репозиторий проекта
 */
@Repository
public class PostRepositoryImpl implements PostRepository {
    private final ExecutorService threadPool = Executors.newFixedThreadPool(64);
    private ConcurrentHashMap<Integer, Post> repository = new ConcurrentHashMap<>();
    private int count = 1;

    /**
     * Получить все записи из репозитория
     *
     * @return коллекцию объектов Post
     */
    public List<Post> all() {
        return Collections.emptyList();
    }

    /**
     * Получить запись конкретного объекта Post
     *
     * @param id идентификатор записи в репозитории
     * @return Optional<Post>
     */
    public Optional<Post> getById(long id) {
        return Optional.empty();
    }

    /**
     * Сохранить полученный объект в репозиторий
     *
     * @param post объект Post
     * @return сохраненный объект
     */
    public Post save(Post post) {
        int id = (int) post.getId();
        while (!Thread.currentThread().isInterrupted()) {
            try {
                threadPool.execute(() -> {
                            if (id == 0) {
                                repository.put(count, post);
                                count++;
                            } else if (repository.get(id) != null) {
                                repository.replace(id, post);
                            } else {
                                post.setId(id);
                                post.setContent("Не существует Post запроса с данным идентификатором");
                            }
                        }
                );
            } finally {
                threadPool.shutdownNow();
            }
        }
        return post;
    }

    /**
     * Удалить запись из репозитория по идентификатору
     *
     * @param id идентификатор записи
     */
    public void removeById(long id) {
    }
}
