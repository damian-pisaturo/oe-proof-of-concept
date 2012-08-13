/**
 * This code was generated from {@link com.amazonaws.services.simpleworkflow.flow.examples.helloworld.HelloWorldActivities}.
 *
 * Any changes made directly to this file will be lost when 
 * the code is regenerated.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.flow.ActivitiesClientBase;
import com.amazonaws.services.simpleworkflow.flow.ActivitySchedulingOptions;
import com.amazonaws.services.simpleworkflow.flow.DataConverter;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.generic.GenericActivityClient;
import com.amazonaws.services.simpleworkflow.model.ActivityType;

public class HelloWorldActivitiesClientImpl extends ActivitiesClientBase implements HelloWorldActivitiesClient {

	public HelloWorldActivitiesClientImpl() {
        this(null, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }

    public HelloWorldActivitiesClientImpl(GenericActivityClient genericClient) {
        this(genericClient, new com.amazonaws.services.simpleworkflow.flow.JsonDataConverter(), null);
    }
    
    public HelloWorldActivitiesClientImpl(GenericActivityClient genericClient, 
            DataConverter dataConverter, ActivitySchedulingOptions schedulingOptions) {
            
        super(genericClient, dataConverter, schedulingOptions);
    }
    
    @Override
    public final Promise<Void> printHello(java.lang.String name) {
        return printHelloImpl(Promise.asPromise(name), (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> printHello(java.lang.String name, Promise<?>... waitFor) {
        return printHelloImpl(Promise.asPromise(name), (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> printHello(java.lang.String name, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return printHelloImpl(Promise.asPromise(name), optionsOverride, waitFor);
    }

    @Override
    public final Promise<Void> printHello(Promise<java.lang.String> name) {
        return printHelloImpl(name, (ActivitySchedulingOptions)null);
    }

    @Override
    public final Promise<Void> printHello(Promise<java.lang.String> name, Promise<?>... waitFor) {
        return printHelloImpl(name, (ActivitySchedulingOptions)null, waitFor);
    }

    @Override
    public final Promise<Void> printHello(Promise<java.lang.String> name, ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {
        return printHelloImpl(name, optionsOverride, waitFor);
    }
    
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected Promise<Void> printHelloImpl(final Promise<java.lang.String> name, final ActivitySchedulingOptions optionsOverride, Promise<?>... waitFor) {

        ActivityType activityType = new ActivityType();
		activityType.setName("PrintHello");
		activityType.setVersion("1.0");

        Promise[] _input_ = new Promise[1];
        _input_[0] = name;

        return (Promise)scheduleActivity(activityType, _input_, optionsOverride, Void.class, waitFor);
    }

}