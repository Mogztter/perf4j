package org.perf4j.aop;

/**
 * This is the "session bean interface" used for the EJB interceptors test.
 */
public interface EjbCallObjectInterface {

    long secondCall(long sleepTime) throws Exception;
}
