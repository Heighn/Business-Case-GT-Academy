package nl.getthere.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hein.dehaan on 18-10-2016.
 */
@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {
    public Theme findByDescription(String description);
}
