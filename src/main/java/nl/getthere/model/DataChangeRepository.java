package nl.getthere.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hein.dehaan on 19-10-2016.
 */
@Repository
public interface DataChangeRepository extends CrudRepository<DataChange, Long>{
}