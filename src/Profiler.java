import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Profiler {
    public void Profile(Object baseClass, Method testMethod, Object[] parameters, int iterations) throws Exception {
        if (parameters == null) parameters = new Object[]{};
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            testMethod.invoke(baseClass, parameters);
        }
        long stopTime = System.nanoTime();
        long elapsedTime = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
        Console.WriteLine(testMethod.getName()+ ": " + (Long.toString(elapsedTime)));
        Runtime.getRuntime().gc();
    }
}
