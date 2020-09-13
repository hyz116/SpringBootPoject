package com.hyz.springboot.validation.domain;

import com.hyz.springboot.validation.bean.validation.constraints.ShangHaiZipCode;
import com.hyz.springboot.validation.bean.validation.constraints.StudentNamePrefix;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 学生 领域对象
 *
 * 自定义 校验器 请参考 springframework-base 工程 中的 validator 模块 CustomValidatorDemo 类
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/12 - 16:44
 * @since
 */

public class Student {
    @NotNull
    @StudentNamePrefix
    private String name;

    @Min(value = 0)
    @Max(value = 200)
    private Integer age;

    /**
     * 生日
     * 格式必须符合"yyyy-MM-dd"格式
     */
    @NotNull(message = "生日日期必填")
    @Pattern(message = "生日的日期格式必须符合\"yyyy-MM-dd\"", regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String birthday;

    @ShangHaiZipCode
    private String zipCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
