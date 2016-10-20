package nl.getthere.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hein.dehaan on 13-10-2016.
 */
@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
    public Event findByName(String name);
}
