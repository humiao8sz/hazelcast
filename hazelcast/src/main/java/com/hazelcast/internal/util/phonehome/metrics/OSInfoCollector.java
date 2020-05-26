/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hazelcast.internal.util.phonehome.metrics;

import com.hazelcast.instance.impl.Node;
import com.hazelcast.internal.util.phonehome.MetricsCollector;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.HashMap;
import java.util.Map;

public class OSInfoCollector implements MetricsCollector {

    @Override
    public Map<String, String> computeMetrics(Node hazelcastNode) {

        Map<String, String> osinfo = new HashMap<>();
        OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
        try {
            osinfo.put("osn", osMxBean.getName());
            osinfo.put("osa", osMxBean.getArch());
            osinfo.put("osv", osMxBean.getVersion());
        } catch (SecurityException e) {
            osinfo.put("osn", "N/A");
            osinfo.put("osa", "N/A");
            osinfo.put("osv", "N/A");
        }

        return osinfo;
    }
}
