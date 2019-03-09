package routine.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import routine.demo.model.Day;

@Repository
public interface DayRepository extends CrudRepository<Day, Integer> {
}
