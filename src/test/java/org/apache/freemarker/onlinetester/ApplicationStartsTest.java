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

package org.apache.freemarker.onlinetester;

import static org.junit.Assert.assertEquals;

import org.apache.freemarker.onlinetester.dropwizard.FreeMarkerOnlineTester;
import org.apache.freemarker.onlinetester.dropwizard.FreeMarkerOnlineTesterConfiguration;
import org.junit.ClassRule;
import org.junit.Test;

import com.google.common.io.Resources;

import io.dropwizard.testing.junit.DropwizardAppRule;

public class ApplicationStartsTest {

    @ClassRule
    public final static DropwizardAppRule RULE = new DropwizardAppRule<FreeMarkerOnlineTesterConfiguration>
            (FreeMarkerOnlineTester.class,
            Resources.getResource("freemarker-online.yml").getPath());


    @Test
    public void test() throws Exception {
        assertEquals(
                200,
                RULE.client().target("http://localhost:" + RULE.getLocalPort() + "/").request().get().getStatus());
    }

}
