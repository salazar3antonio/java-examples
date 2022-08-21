package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)  // Applies to class, interface, or enum
public @interface CustomAnnotation {
    Class<?> targetClass();
    String setterPrefix() default "set";
}
