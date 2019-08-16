package todolist.service;

import org.apache.log4j.Logger;
import todolist.entity.Item;
import todolist.exception.ResourceNotFoundException;
import todolist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private static final Logger logger = Logger.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item getItem(Integer id){
        List<Item> item = itemRepository.findOneById(id);
        if(item.size() == 0){
            throw new ResourceNotFoundException();
        }
        return item.stream().findAny().get();
    }

    public void addItem(Item item){
        itemRepository.save(item);
        logger.info("Item created, id: " + item.getId());
    }

    public void updateItem(Item item){
        itemRepository.save(item);
        logger.info("Item updated, id: " + item.getId());
    }

    public void deleteItem(Integer id){
        if(!itemRepository.existsById(id)){
            throw new ResourceNotFoundException();
        }
        itemRepository.deleteById(id);
        logger.info("Item deleted, id: " + id);
    }


}
