package com.hyz.springboot.validation.controller;

import com.hyz.springboot.validation.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * {@link Student} Controller
 *
 * @author <a href="mailto:huangyuze@lvmama.com">hyz</a> <br>
 * @date 2020/9/12 - 16:47
 * @since
 * @see Student
 */
@RestController
@RequestMapping("/stu")
@Slf4j
public class StudentController {

    @PostMapping("/")
    public Student saveStudent(@Valid @RequestBody Student student) {
        log.info("保存学生对象，数据：{}", student.toString());
        return student;
    }
}
