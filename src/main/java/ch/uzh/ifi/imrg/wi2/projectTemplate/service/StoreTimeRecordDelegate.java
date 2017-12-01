package ch.uzh.ifi.imrg.wi2.projectTemplate.service;

import ch.uzh.ifi.imrg.wi2.projectTemplate.persistence.TimeRecord;
import ch.uzh.ifi.imrg.wi2.projectTemplate.repository.TimeRecordRepository;
import javax.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;


@Named("storeTimeRecordDelegate")
public class StoreTimeRecordDelegate implements JavaDelegate {

    @Autowired
    TimeRecordRepository repo;
    
    @Override
    public void execute(DelegateExecution de) throws Exception {
        TimeRecord tr = new TimeRecord();
        tr.setName((String)de.getVariable("name"));
        tr.setTime((Double)de.getVariable("time"));
        repo.save(tr);
        System.out.println("Stored!");
    }
    
}
