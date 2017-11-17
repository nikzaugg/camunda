package ch.uzh.ifi.imrg.wi2.projectTemplate.repository;
import ch.uzh.ifi.imrg.wi2.projectTemplate.persistence.TimeRecord;
import org.springframework.data.repository.CrudRepository;

public interface TimeRecordRepository extends CrudRepository<TimeRecord,Long>{
    
}
