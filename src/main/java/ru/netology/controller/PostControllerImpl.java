package ru.netology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import java.util.List;

@RestController
@RequestMapping(path = "api/posts")
public class PostControllerImpl implements PostController {
  private final PostService service;

  public PostControllerImpl(PostService service) {
    this.service = service;
  }

  @GetMapping
  public List<Post> all() {
    return service.all();
  }

  @GetMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public Post getById(@PathVariable("id") long id) {
    return service.getById(id);
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public Post save(@RequestBody Post post) {
    return service.save(post);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public void removeById(@PathVariable("id") long id) {
    service.removeById(id);
  }
}
