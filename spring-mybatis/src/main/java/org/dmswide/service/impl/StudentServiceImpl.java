package org.dmswide.service.impl;

import org.dmswide.dao.StudentDao;
import org.dmswide.domain.Student;
import org.dmswide.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;
    //set注入赋值
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudnet(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudent() {
        List<Student> students = studentDao.selectStudent();
        return students;
    }
}
