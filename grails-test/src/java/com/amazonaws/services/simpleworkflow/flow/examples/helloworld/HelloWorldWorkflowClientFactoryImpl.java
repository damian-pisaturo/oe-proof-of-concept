/**
 * This code was generated from {@link com.amazonaws.services.simpleworkflow.flow.examples.helloworld.HelloWorldWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientFactoryBase;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClient;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecution;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

public class HelloWorldWorkflowClientFactoryImpl extends WorkflowClientFactoryBase<HelloWorldWorkflowClient> implements HelloWorldWorkflowClientFactory {
    
    public HelloWorldWorkflowClientFactoryImpl() {
        this(null, null, null);
    }

    public HelloWorldWorkflowClientFactoryImpl(StartWorkflowOptions startWorkflowOptions) {
        this(startWorkflowOptions, null, null);
    }

    public HelloWorldWorkflowClientFactoryImpl(StartWorkflowOptions startWorkflowOptions, DataConverter dataConverter) {
        this(startWorkflowOptions, dataConverter, null);
    }

    public HelloWorldWorkflowClientFactoryImpl(StartWorkflowOptions startWorkflowOptions, DataConverter dataConverter,
            GenericWorkflowClient genericClient) {
        super(startWorkflowOptions, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), genericClient);
    }
    
    @Override
    protected HelloWorldWorkflowClient createClientInstance(WorkflowExecution execution,
            StartWorkflowOptions options, DataConverter dataConverter, GenericWorkflowClient genericClient) {
        WorkflowType workflowType = new WorkflowType();
        workflowType.setName("HelloWorldWorkflow.helloWorld");
        workflowType.setVersion("1.0");
        return new HelloWorldWorkflowClientImpl(execution, workflowType, options, dataConverter, genericClient);
    }
   
}