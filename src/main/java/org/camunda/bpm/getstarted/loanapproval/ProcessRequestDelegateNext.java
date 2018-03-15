package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.loanapproval.utils.ProcessUtil;

import java.util.Map;
import java.util.logging.Logger;

public class ProcessRequestDelegateNext implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

    public static int count = 0;

    public void execute(DelegateExecution execution) throws Exception {
        execution.getVariable("myVarInt");
        execution.getVariable("myVarStr");

        Student student = (Student) execution.getVariable("student");

        Map<String, String> extensionsElements = ProcessUtil.getExtensionsPropertiesElements(execution);

        LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...count: " + count++);
    }
}