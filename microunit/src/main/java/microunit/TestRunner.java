package microunit;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class TestRunner {
    protected Class<?> testClass;

    public TestRunner(Class<?> testClass) {
        this.testClass = testClass;
    }

    protected List<Method> getAnnotatedMethods(){
        return Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .toList();
    }

    protected abstract void invokeTestMethod(
            Method testMethod,
            Object instance,
            Result result) throws IllegalAccessException;

    public void runTestMethods(){
        try {
            Result result = new Result();
            for(Method method:getAnnotatedMethods()){
                System.out.println(method);
                Object instence = testClass.getConstructor().newInstance();
                invokeTestMethod(method, instence, result);
            }
            System.out.println(result);
        } catch (ReflectiveOperationException | IllegalArgumentException e){
            throw new InvalidTestClassException(e);
        }

    }
}
