/**
 * This code was generated from {@link com.amazonaws.services.simpleworkflow.flow.examples.helloworld.HelloWorldWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.flow.core.AndPromise;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.core.Task;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowSelfClientBase;
import com.amazonaws.services.simpleworkflow.flow.generic.ContinueAsNewWorkflowExecutionParameters;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericWorkflowClient;

public class HelloWorldWorkflowSelfClientImpl extends WorkflowSelfClientBase implements HelloWorldWorkflowSelfClient {

    public HelloWorldWorkflowSelfClientImpl() {
        this(null, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public HelloWorldWorkflowSelfClientImpl(GenericWorkflowClient genericClient) {
        this(genericClient, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public HelloWorldWorkflowSelfClientImpl(GenericWorkflowClient genericClient, 
            DataConverter dataConverter, StartWorkflowOptions schedulingOptions) {
            
        super(genericClient, dataConverter, schedulingOptions);
    }

    @Override
    public final void helloWorld(java.lang.String name) { 
        helloWorldImpl(Promise.asPromise(name), (StartWorkflowOptions)null);
    }

    @Override
    public final void helloWorld(java.lang.String name, Promise<?>... waitFor) { 
        helloWorldImpl(Promise.asPromise(name), (StartWorkflowOptions)null, waitFor);
    }
    
    @Override
    public final void helloWorld(java.lang.String name, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        helloWorldImpl(Promise.asPromise(name), optionsOverride, waitFor);
    }
    
    @Override
    public final void helloWorld(Promise<java.lang.String> name) {
        helloWorldImpl(name, (StartWorkflowOptions)null);
    }

    @Override
    public final void helloWorld(Promise<java.lang.String> name, Promise<?>... waitFor) {
        helloWorldImpl(name, (StartWorkflowOptions)null, waitFor);
    }

    @Override
    public final void helloWorld(Promise<java.lang.String> name, StartWorkflowOptions optionsOverride, Promise<?>... waitFor) {
        helloWorldImpl(name, optionsOverride, waitFor);
    }
    
    protected void helloWorldImpl(final Promise<java.lang.String> name, final StartWorkflowOptions schedulingOptionsOverride, Promise<?>... waitFor) {
        new Task(new Promise[] { name, new AndPromise(waitFor) }) {
    		@Override
			protected void doExecute() throws Throwable {
                ContinueAsNewWorkflowExecutionParameters _parameters_ = new ContinueAsNewWorkflowExecutionParameters();
                Object[] _input_ = new Object[1];
                _input_[0] = name.get();
                String _stringInput_ = dataConverter.toData(_input_);
				_parameters_.setInput(_stringInput_);
				_parameters_ = _parameters_.createContinueAsNewParametersFromOptions(schedulingOptions, schedulingOptionsOverride);
                
                if (genericClient == null) {
                    genericClient = decisionContextProvider.getDecisionContext().getWorkflowClient();
                }
                genericClient.continueAsNewOnCompletion(_parameters_);
			}
		};
    }
}