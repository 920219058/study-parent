package com.it.study.mapper;

import com.it.study.demain.Student;
import com.it.study.demain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<User> queryUserList();

    // 配置类属性和数据库表中列的对应关系
    @Select("select * from student")
    @Results(id = "resultMap", value = {
            @Result(id = true,column = "id", property = "userId"),
            @Result(column = "name",property = "userName"),
            @Result(column = "addr", property = "userAddr"),
            @Result(column = "age", property = "userAge"),
            @Result(property = "account",column = "id",
                    many = @Many(select = "com.it.study.mapper.AccountAmpper.finalAccountByUid",fetchType = FetchType.LAZY))
    })  // 一对多的情况下一般采用懒加载方式 FetchType.LAZY
    public List<Student> queryStudent();

    @Insert("insert into student(name,addr,age)value(#{name},#{addr},#{age})")
    public void insertStudent(Student student);

    @Update("update student set name=#{name},age=#{age},addr=#{addr} where id = #{id}")
    public void uodateUser(Student student);

    // @Select("select * from student where name like #{name}")  #{}是预占位符，有防止SQL注入的风险
    @Select("select * from student where name like '${value}'")  // ${} 是字符拼接
    public List<Student> finalStudentByName(String name);

    @Select("select * from student where id = #{id}")
    public Student finalStudentById(Integer id);

    public int finalTotal();
}
