package com.xnyc.blog.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author : 郑杜
 * @date : 2020/04/06
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {AllowValuesValidator.class})
public @interface AllowValues {
    String value() default "";

    String message() default "The value is not allowed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
