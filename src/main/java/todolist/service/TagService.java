package todolist.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.entity.Item;
import todolist.entity.Tag;
import todolist.exception.ResourceNotFoundException;
import todolist.repository.ItemRepository;
import todolist.repository.TagRepository;

import java.util.List;

@Service
public class TagService {

    private static final Logger logger = Logger.getLogger(TagService.class);

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Tag> getByItemId(Integer id){
        List<Item> item = itemRepository.findOneById(id);
        if(item.size() == 0){
            throw new ResourceNotFoundException();
        }
        return item.stream().findAny().get().getTags();
    }

    public void addTag(Integer id, Tag tag){
        if(itemRepository.existsById(id)){
            throw new ResourceNotFoundException();
        }
        tag.setItem_id(id);
        tagRepository.save(tag);
        logger.info("Tag created, id: " + tag.getId());
    }

    public void updateTag(Tag tag){
        tagRepository.save(tag);
        logger.info("Tag updated, id: " + tag.getId());
    }

    public void deleteTag(Integer id) {
        if(tagRepository.existsById(id)){
            throw new ResourceNotFoundException();
        }
        tagRepository.deleteById(id);
        logger.info("Tag deleted, id: " + id);
    }
}
