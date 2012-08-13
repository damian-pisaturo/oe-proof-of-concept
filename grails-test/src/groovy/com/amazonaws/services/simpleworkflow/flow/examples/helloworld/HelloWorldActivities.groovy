/*
 * Copyright 2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.simpleworkflow.flow.examples.helloworld;

import com.amazonaws.services.simpleworkflow.flow.annotations.Activities
import com.amazonaws.services.simpleworkflow.flow.annotations.Activity
import com.amazonaws.services.simpleworkflow.flow.annotations.ActivityRegistrationOptions

/**
 * Contract of the hello world activities
 */
@Activities
public interface HelloWorldActivities {

    @Activity(name = "PrintHello", version = "1.0")
    @ActivityRegistrationOptions(defaultTaskScheduleToStartTimeoutSeconds = 30L, defaultTaskStartToCloseTimeoutSeconds = 10L)
    void printHello(String name);
    
}
