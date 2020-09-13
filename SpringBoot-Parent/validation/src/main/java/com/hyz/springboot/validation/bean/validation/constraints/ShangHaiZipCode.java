package com.hyz.springboot.validation.bean.validation.constraints;

import com.hyz.springboot.validation.bean.validation.ShangHaiZipCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

/**
 * 上海市邮政编码约束
 * 组合式约束
 *
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/13 - 08:51
 * @since
 */

@NotNull(message = "邮政编码不能为空")
@Pattern(regexp = "^\\d{6}$")  // 6位数字
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = {ShangHaiZipCodeValidator.class})
@ReportAsSingleViolation  // 组合式约束，当有错误时，单独报告一个错误
public @interface ShangHaiZipCode {
    String message() default "{com.hyz.springboot.validation.bean.validation.constraints.ShangHaiZipCode.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String zipCode() default "200000";
}
