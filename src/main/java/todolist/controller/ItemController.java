package todolist.controller;


import org.springframework.web.bind.annotation.*;
import todolist.entity.Item;
import todolist.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public List<Item> getItem(){
        return itemService.getAllItems();
    }

    @RequestMapping("/items/{id}")
    public Item getItem(@PathVariable Integer id) {
        return itemService.getItem(id);
    }

    @PostMapping(value="/items")
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

    @PutMapping(value="/items")
    public void updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
    }

    @DeleteMapping(value="/items/{id}")
    public void deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
    }
}
