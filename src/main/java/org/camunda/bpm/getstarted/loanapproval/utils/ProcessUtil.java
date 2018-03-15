package org.camunda.bpm.getstarted.loanapproval.utils;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.model.bpmn.instance.ServiceTask;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperties;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaProperty;

import java.util.HashMap;
import java.util.Map;


public class ProcessUtil {

    private static final String NAME_SEPARATOR = ".";

    public static String getProcessKey(DelegateExecution execution){
        return ((ExecutionEntity) execution).getProcessDefinition().getKey();
    }

    public static String getTaskId(DelegateExecution execution){
        return ((ExecutionEntity) execution).getActivityId();
    }

    public static String createFullValueName(DelegateExecution execution, String shortName){
        return getProcessKey(execution) + NAME_SEPARATOR + getTaskId(execution) + NAME_SEPARATOR + shortName;
    }

    public static Map<String, String> getExtensionsPropertiesElements(DelegateExecution execution){

        Map<String, String> resultMap = new HashMap<>();
        ServiceTask serviceTask = (ServiceTask) execution.getBpmnModelElementInstance();
        CamundaProperties camProperties = serviceTask.getExtensionElements().getElementsQuery().filterByType(CamundaProperties.class).singleResult();
        for (CamundaProperty camProperty : camProperties.getCamundaProperties())
        {
            String name = camProperty.getCamundaName();
            String value = camProperty.getCamundaValue();
            resultMap.put(name, value);
        }
        return resultMap;
    }

}
