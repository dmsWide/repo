package org.dmswide;

import org.dmswide.dao.StudentDao;
import org.dmswide.domain.Student;
import org.dmswide.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        String[] names = ac.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name + ":"+ac.getBean(name).getClass().getName());
        }
    }
    //创建并访问dao对象
    @Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentDao dao = (StudentDao)ac.getBean("studentDao");
        Student student = new Student();
        student.setId(10);
        student.setName("小小怪");
        student.setEmail("xiaoxiaoguai@163.com");
        student.setAge(20);
        dao.insertStudent(student);
    }
    //通过service调用dao
    @Test
    public void test03(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService service = (StudentService) ac.getBean("studentService");
        Student student = new Student();
        student.setId(11);
        student.setName("大大怪");
        student.setEmail("dadaguai@163.com");
        student.setAge(21);
        //spring整合mybatis的时候事务是自动提交的，无需执行sqlSession.commit()来提交事务
        //执行sql语句会自动提交
        service.addStudnet(student);
    }
    @Test
    public void test04(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        StudentService service = (StudentService) ac.getBean("studentService");
        //spring整合mybatis的时候事务是自动提交的，无需执行sqlSession.commit()来提交事务
        //执行sql语句会自动提交
        List<Student> students = service.queryStudent();
        for(Student s : students){
            System.out.println("成员信息 : " + s);
        }
    }
}
