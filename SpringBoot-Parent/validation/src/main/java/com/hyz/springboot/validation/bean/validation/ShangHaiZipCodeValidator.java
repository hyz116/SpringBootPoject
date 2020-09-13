package com.hyz.springboot.validation.bean.validation;

import com.hyz.springboot.validation.bean.validation.constraints.ShangHaiZipCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/13 - 08:58
 * @since
 */
public class ShangHaiZipCodeValidator implements ConstraintValidator<ShangHaiZipCode, String> {
    // 邮政编码
    private String zipCode;

    @Override
    public void initialize(ShangHaiZipCode constraintAnnotation) {
        this.zipCode = constraintAnnotation.zipCode();
    }

    @Override
    public boolean isValid(String zipCode, ConstraintValidatorContext context) {
        // 拿到文案模版
        System.out.println("Uninterpolated default message is " + context.getDefaultConstraintMessageTemplate());

        // 覆盖原先定义的文案模版，使用其他模版
//        context.disableDefaultConstraintViolation();
//        ConstraintValidatorContext.ConstraintViolationBuilder builder = context.buildConstraintViolationWithTemplate("邮政编码必须是6位数字");
//        builder.addConstraintViolation();
        return false;
    }
}
