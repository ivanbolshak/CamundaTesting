package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.getstarted.loanapproval.utils.ProcessUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ProcessRequestDelegate implements JavaDelegate{

    private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

    public static int count = 0;

    public void execute(DelegateExecution execution) throws Exception {

        execution.setVariable("myVarInt", 111);
        execution.setVariable("myVarStr", "some_string");

        Map<String, String> extensionsElements = ProcessUtil.getExtensionsPropertiesElements(execution);

        Map<String, Student> map = new HashMap<>();

        Student student = new Student("Bob", 21, Arrays.asList("s1", "s2", "s3"));

        execution.setVariable("student", student);

        LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...count: " + count++);

    }

}