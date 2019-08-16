package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todolist.entity.Tag;
import todolist.service.TagService;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/items/{id}/tags")
    public List<Tag> getByItemId(@PathVariable Integer id) {
        return tagService.getByItemId(id);
    }

    @PostMapping(value="/items/{id}/tags")
    public void addItem(@RequestBody Tag tag, @PathVariable Integer id) {
        tagService.addTag(id, tag);
    }

    @PutMapping(value="/tags")
    public void updateItem(@RequestBody Tag tag) {
        tagService.updateTag(tag);
    }

    @DeleteMapping(value="/tags/{id}")
    public void deleteItem(@PathVariable Integer id) {
        tagService.deleteTag(id);
    }
}
