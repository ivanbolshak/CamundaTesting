package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;

public class DelegatedVarMapping implements DelegateVariableMapping {

    @Override
    public void mapInputVariables(DelegateExecution execution, VariableMap variables) {
        variables.putValue("inputVar", "inValue");
    }

    @Override
    public void mapOutputVariables(DelegateExecution execution, VariableScope subInstance) {
        execution.setVariable("outputVar", "outValue");
    }
}
