package routine.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import routine.demo.model.Tag;

@Repository
public interface TagRepository  extends CrudRepository<Tag, Integer> {
}
