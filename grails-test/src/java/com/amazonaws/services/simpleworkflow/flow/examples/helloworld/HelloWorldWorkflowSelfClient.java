/**
 * This code was generated from {@link com.amazonaws.services.simpleworkflow.flow.examples.helloworld.HelloWorldWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowSelfClient;

public interface HelloWorldWorkflowSelfClient extends WorkflowSelfClient
{
    void helloWorld(java.lang.String name);
    void helloWorld(java.lang.String name, Promise<?>... waitFor);
    void helloWorld(java.lang.String name, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
    void helloWorld(Promise<java.lang.String> name);
    void helloWorld(Promise<java.lang.String> name, Promise<?>... waitFor);
    void helloWorld(Promise<java.lang.String> name, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
}