import com.it.study.MySpringBootApplication;
import com.it.study.demain.Student;
import com.it.study.demain.User;
import com.it.study.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class MyBatisTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.queryUserList();
        System.out.println(users);
    }

    @Test
    public void studentTest(){
        Student student = new Student();
        /*student.setId(3);
        student.setName("lisi");
        student.setAge(22);
        student.setAddr("guangdong shenzhen");*/
        userMapper.uodateUser(student);

        List<Student> users = userMapper.finalStudentByName("%myBatis%");
        List<Student> userList = userMapper.queryStudent();
        System.out.println(userList);
    }

    @Test
    public void test1(){
        List<Student> students = userMapper.queryStudent();
        for(Student student : students){
            System.out.println("学生：" + student);
            System.out.println("账户：" + student.getAccount());
        }
    }
}
