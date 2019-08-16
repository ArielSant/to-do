package todolist.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import todolist.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("SELECT item FROM Item item  WHERE item.id=(:id)")
    List<Item> findOneById(@Param("id") Integer id);
}
