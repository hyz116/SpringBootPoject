package com.hyz.springboot.validation.bean.validation.constraints;

import com.hyz.springboot.validation.bean.validation.StudentNamePrefixValidator;
import com.hyz.springboot.validation.domain.Student;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * {@link Student} name 前缀校验注解
 *
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/12 - 17:05
 * @since
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {StudentNamePrefixValidator.class})
public @interface StudentNamePrefix {
    String message() default "{student.name.prefix.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String prefix() default "hyz-";
}
