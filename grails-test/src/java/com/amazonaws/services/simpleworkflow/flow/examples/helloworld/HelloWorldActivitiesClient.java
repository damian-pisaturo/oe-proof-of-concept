/**
 * This code was generated from {@link com.amazonaws.services.simpleworkflow.flow.examples.helloworld.HelloWorldActivities}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.ActivitiesClient;
import com.amazonaws.services.simpleworkflow.flow.ActivitySchedulingOptions;

public interface HelloWorldActivitiesClient extends ActivitiesClient
{
    Promise<Void> printHello(java.lang.String name);
    Promise<Void> printHello(java.lang.String name, Promise<?>... waitFor);
    Promise<Void> printHello(java.lang.String name, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor);
    Promise<Void> printHello(Promise<java.lang.String> name);
    Promise<Void> printHello(Promise<java.lang.String> name, Promise<?>... waitFor);
    Promise<Void> printHello(Promise<java.lang.String> name, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor);
}