package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todolist.entity.Tag;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
