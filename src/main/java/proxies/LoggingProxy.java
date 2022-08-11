package proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

public final class LoggingProxy {
    public static void main(String[] args) {

        Set<String> targetSet = new HashSet<>();

        Object proxy = Proxy.newProxyInstance(
                LoggingProxy.class.getClassLoader(),
                new Class[]{Set.class},
                new LoggingInvocationHandler(targetSet));

        Set<String> loggedSet = (Set<String>) proxy;
        loggedSet.add("item");

        System.out.println(targetSet.contains("item"));
    }

    static class LoggingInvocationHandler implements InvocationHandler {

        private final Object targetObject;

        public LoggingInvocationHandler(Object targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(targetObject.getClass() + "." + method.getName() + "()");
            return method.invoke(targetObject, args);
        }
    }
}
