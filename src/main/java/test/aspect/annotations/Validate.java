package test.aspect.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
public @interface Validate {

}
