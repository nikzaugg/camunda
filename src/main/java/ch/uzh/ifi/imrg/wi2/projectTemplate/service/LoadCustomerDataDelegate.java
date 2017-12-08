package ch.uzh.ifi.imrg.wi2.projectTemplate.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;


@Named("loadCustomerDataDelegate")
public class LoadCustomerDataDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegate) throws Exception {
        System.out.println("Prozess initialisiert: Kundendaten geladen!");
    }
}