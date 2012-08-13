/**
 * This code was generated from {@link com.amazonaws.services.simpleworkflow.flow.examples.helloworld.HelloWorldWorkflow}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.StartWorkflowOptions;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClient;

public interface HelloWorldWorkflowClient extends WorkflowClient
{
    Promise<Void> helloWorld(java.lang.String name);
    Promise<Void> helloWorld(java.lang.String name, Promise<?>... waitFor);
    Promise<Void> helloWorld(java.lang.String name, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
    Promise<Void> helloWorld(Promise<java.lang.String> name);
    Promise<Void> helloWorld(Promise<java.lang.String> name, Promise<?>... waitFor);
    Promise<Void> helloWorld(Promise<java.lang.String> name, StartWorkflowOptions optionsOverride, Promise<?>... waitFor);
}