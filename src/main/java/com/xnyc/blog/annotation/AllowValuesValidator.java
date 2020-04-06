package com.xnyc.blog.annotation;

import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : 郑杜
 * @date : 2020/04/06
 */
@Slf4j
public class AllowValuesValidator implements ConstraintValidator<AllowValues, String> {

    private AllowValues allowValues;

    @Override
    public void initialize(AllowValues constraintAnnotation) {
        this.allowValues = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (allowValues == null) {
            log.error("AllowValuesValidator: this.allowValues is null.");
            return true;
        }

        if (StringUtils.isEmpty(value)) {
            return false;
        }

        List<String> allowValues = new ArrayList<>();
        String[] split = this.allowValues.value().split(",");
        for (String s : split) {
            String[] str = s.split(":");
            allowValues.add(str[0]);
        }

        return allowValues.contains(value);
    }
}
