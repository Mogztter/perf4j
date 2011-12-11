package org.perf4j.aop;

import javax.interceptor.Interceptors;

/** @author bloemgracht */
public class EjbCallObject implements EjbCallObjectInterface {

    @Interceptors(EjbInMemoryTimingAspect.class)
    @Profiled(tag = "{$contextData.get(\"callDepth\")}")
    public long secondCall(long sleepTime) throws Exception {
        Thread.sleep(sleepTime);
        return sleepTime;
    }
}
