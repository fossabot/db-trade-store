package com.db.trade.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.db.trade.validator.VersionOutDatedValidator;

@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = VersionOutDatedValidator.class)
public @interface VersionOutDatedValidation {
	//error message
    public String message() default "Version outdated cannot updated trade data";
    String tradeId();
    String version();
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}
