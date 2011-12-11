package org.perf4j.aop;

import org.apache.log4j.Level;
import org.perf4j.LoggingStopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used by the EjbAopTest to check when the aspect was called
 */
public class EjbInMemoryTimingAspect extends AbstractEjbTimingAspect {
    public static List<String> logStrings = Collections.synchronizedList(new ArrayList<String>());

    protected LoggingStopWatch newStopWatch(final String loggerName, final String levelName) {
        return new LoggingStopWatch() {
            private static final long serialVersionUID = -8258832873829050541L;

            public boolean isLogging() {
                return Level.toLevel(levelName).toInt() >= Level.INFO_INT;
            }

            protected void log(String stopWatchAsString, Throwable exception) {
                EjbInMemoryTimingAspect.logStrings.add(stopWatchAsString);
            }
        };
    }

    /**
     * Returns the last but... one, two, three... logged string.
     * @param lastBut the last but... one, two, three...
     *
     * @return the last but... one, two, three... logged string
     */
    public static String getLastLoggedString(int lastBut) {
        if (logStrings.size() > lastBut) {
            return logStrings.get((logStrings.size() - 1) - lastBut);
        } else {
            return null;
        }
    }

    /**
     * Returns the last logged string.
     *
     * @return the last logged string
     */
    public static String getLastLoggedString() {
        return getLastLoggedString(0);
    }
}
