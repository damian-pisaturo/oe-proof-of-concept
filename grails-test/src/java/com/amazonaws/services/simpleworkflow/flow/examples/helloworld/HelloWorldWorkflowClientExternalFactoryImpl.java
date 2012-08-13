/**
 * This code was generated from {@link com.amazonaws.services.simpleworkflow.flow.examples.helloworld.HelloWorldWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClientFactoryExternalBase;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClientExternal;
import com.amazonaws.services.simpleworkflow.model.WorkflowExecution;
import com.amazonaws.services.simpleworkflow.model.WorkflowType;

public class HelloWorldWorkflowClientExternalFactoryImpl extends WorkflowClientFactoryExternalBase<HelloWorldWorkflowClientExternal>  implements HelloWorldWorkflowClientExternalFactory {

    public HelloWorldWorkflowClientExternalFactoryImpl(AmazonSimpleWorkflow service, String domain) {
		super(service, domain);
		setDataConverter(new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter());
	}
	
	public HelloWorldWorkflowClientExternalFactoryImpl() {
        super(null);
		setDataConverter(new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter());
    }
    
    public HelloWorldWorkflowClientExternalFactoryImpl(GenericWorkflowClientExternal genericClient) {
        super(genericClient);
		setDataConverter(new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter());
    }
	
    @Override
    protected HelloWorldWorkflowClientExternal createClientInstance(WorkflowExecution workflowExecution,
            StartWorkflowOptions options, DataConverter dataConverter, GenericWorkflowClientExternal genericClient) {
        WorkflowType workflowType = new WorkflowType();
        workflowType = new WorkflowType();
        workflowType.setName("HelloWorldWorkflow.helloWorld");
        workflowType.setVersion("1.0");
        return new HelloWorldWorkflowClientExternalImpl(workflowExecution, workflowType, options, dataConverter, genericClient);
    }
    
}