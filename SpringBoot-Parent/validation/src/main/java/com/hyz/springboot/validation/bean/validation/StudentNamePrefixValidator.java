package com.hyz.springboot.validation.bean.validation;

import com.hyz.springboot.validation.bean.validation.constraints.StudentNamePrefix;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * {@link StudentNamePrefix} {@link javax.validation.Validator}
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/12 - 17:13
 * @since
 */
public class StudentNamePrefixValidator implements ConstraintValidator<StudentNamePrefix, String> {

    /**
     * 前缀
     */
    private String prefix;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (!name.startsWith(prefix)) {
            return false;
        }
        
        return true;
    }

    @Override
    public void initialize(StudentNamePrefix studentNamePrefix) {
        this.prefix = studentNamePrefix.prefix();
    }
}
