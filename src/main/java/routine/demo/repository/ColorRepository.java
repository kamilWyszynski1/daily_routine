package routine.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import routine.demo.model.Color;

@Repository
public interface ColorRepository extends CrudRepository<Color, Integer> {
}
