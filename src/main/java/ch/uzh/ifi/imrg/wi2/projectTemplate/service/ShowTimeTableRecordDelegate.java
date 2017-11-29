package ch.uzh.ifi.imrg.wi2.projectTemplate.service;

import ch.uzh.ifi.imrg.wi2.projectTemplate.repository.TimeRecordRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;


@Named("showTimeRecordDelegate")
public class ShowTimeTableRecordDelegate implements JavaDelegate {

    @Autowired
    TimeRecordRepository repo;
    
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String name = (String) execution.getVariable("name");
        Double time = (Double) execution.getVariable("time");
    }
    
}
