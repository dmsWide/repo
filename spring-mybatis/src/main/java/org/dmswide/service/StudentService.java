package org.dmswide.service;

import org.dmswide.domain.Student;

import java.util.List;

public interface StudentService {
    //定义对数据的操作方法
    int addStudnet(Student student);
    List<Student> queryStudent();
}
