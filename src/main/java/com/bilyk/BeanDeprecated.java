package com.bilyk;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface BeanDeprecated {
    public Class newClass() default  Class.class;
}
