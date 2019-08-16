package todolist;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import todolist.entity.*;
import todolist.repository.ItemRepository;
import todolist.service.ItemService;

import java.util.List;

@SpringBootTest
public class ApplicationTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testList() {
        Item item = new Item(1, "item-to-test",
                new Groups(1, "home"),
                new Priority(1, "low"),
                new Status(1, "to-do"));

        when(itemRepository.findById(1)).thenReturn(java.util.Optional.of(item));

        Item itemListed = itemRepository.findById(1).get();

        assertEquals(item,  itemListed);
    }

}
