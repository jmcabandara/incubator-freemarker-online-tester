/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.freemarker.onlinetester.platform;

import com.google.common.io.Resources;
import org.apache.freemarker.onlinetester.dropwizard.ApplicationStartup;
import com.yammer.dropwizard.testing.junit.DropwizardServiceRule;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TestRule;

public class DropWizardServiceTest {
    @ClassRule
    public static TestRule testRule = new DropwizardServiceRule<>(ApplicationStartup.class,
            Resources.getResource("freemarker-online.yml").getPath());


    @Test
    public void testServerIsUp() throws Exception {
        ((DropwizardServiceRule) testRule).getService();
    }
}