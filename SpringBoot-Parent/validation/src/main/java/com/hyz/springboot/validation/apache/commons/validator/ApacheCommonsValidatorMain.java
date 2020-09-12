package com.hyz.springboot.validation.apache.commons.validator;

import org.apache.commons.validator.routines.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

/**
 * Apache commons validator
 * 设计模式：单例模式，校验器模式
 *
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/12 - 08:19
 * @since
 */
public class ApacheCommonsValidatorMain {
    public static void main(String[] args) {
//        integerValidator();

//        dateAndTimeValidator();

//        bigDecimalValidator();

        emailValidator();
    }

    private static void emailValidator() {
        EmailValidator emailValidator = EmailValidator.getInstance();
        System.out.printf("验证邮箱是否有效：%s", emailValidator.isValid("hyz992116@gmail.com"));

    }

    private static void bigDecimalValidator() {
        BigDecimalValidator bigDecimalValidator = BigDecimalValidator.getInstance();
        System.out.printf("%s\n", bigDecimalValidator.format(BigDecimal.valueOf(20.2d)));

        System.out.printf("100美元：%s\n", bigDecimalValidator.format(BigDecimal.valueOf(100d), Locale.US));

        System.out.printf("在...之间 %s\n", bigDecimalValidator.isInRange(BigDecimal.valueOf(20.4d), 20.1d, 30.2d));

        System.out.printf("小于等于 %s \n", bigDecimalValidator.maxValue(BigDecimal.valueOf(50.2d), 40.1d));
        System.out.printf("大于等于 %s \n", bigDecimalValidator.minValue(BigDecimal.valueOf(20.1d), 10.3d));

        System.out.printf("validate %s \n", bigDecimalValidator.validate("30.3"));

//        bigDecimalValidator.isValid()
    }

    /**
     * Date 与 Time校验器
     *
     * @see org.apache.commons.validator.routines.DateValidator
     * @see org.apache.commons.validator.routines.CalendarValidator
     * @see org.apache.commons.validator.routines.TimeValidator
     * @see java.text.SimpleDateFormat
     * @see java.text.DateFormat
     * <p>
     * 适用场景：
     * 校验
     * 格式化
     * 时区比较
     */
    private static void dateAndTimeValidator() {
        DateValidator dateValidator = DateValidator.getInstance();
        System.out.printf("校验日期：%s", dateValidator.format(new Date(), Locale.CHINA));

        TimeValidator timeValidator = TimeValidator.getInstance();


        CalendarValidator calendarValidator = CalendarValidator.getInstance();

    }

    private static void integerValidator() {
        IntegerValidator integerValidator = IntegerValidator.getInstance();
        System.out.printf("校验并返回: %s\n", integerValidator.validate("aaa"));  // null
        System.out.printf("校验并返回: %s\n", integerValidator.validate("100"));  // null

        System.out.printf("100 小于等于 200 ？: %s\n", integerValidator.maxValue(100, 200));
        System.out.printf("100 大于等于 150 ？: %s\n", integerValidator.minValue(100, 150));
        System.out.printf("100 在 100 到 200之间吗 ？: %s\n", integerValidator.isInRange(100, 100, 200));

        System.out.printf("使用默认的Local 格式化10000: %s\n", integerValidator.format(10000));
        System.out.printf("使用默认的Locale.ENGLISH 格式化100000: %s\n", integerValidator.format(100000, Locale.ENGLISH));
    }
}
