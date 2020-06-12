package dao;

import domain.SCT_Choice;
import domain.SCT_Course;
import domain.SCT_Student;
import domain.SCT_Teacher;

import java.util.List;

public interface SCT_Dao {

    //***注册***
    //学生注册
    public void stu_register(SCT_Student sct_student);
    //教师注册
    public void tea_register(SCT_Teacher sct_teacher);

    //***登录***
    //学生登录
    public boolean stu_login(String stel , String spassword);
    //教师登录
    public boolean tea_login(String ttel , String tpassword);

    //***判断***
    //判断是否有这个电话号的学生
    public boolean stu_check(String stel);
    //判断是否有这个电话号的教师
    public boolean tea_check(String ttel);
    //判断该学生是否加入该课程
    public boolean stuInClass(int sid , int cid);

    //***更新***
    //更新学生信息
    public void updateStuInfo(SCT_Student sct_student , int sid);
    //更新教师信息
    public void updateTeaInfo(SCT_Teacher sct_teacher , int tid);
    //更新课程信息
    public void updateCourseInfo(SCT_Course course , int cid);

    //***查询***
    //查询全部的课程
    public List<SCT_Course> getAllCourse(int startCount);
    //查询全部课程的数量
    public int getAllCount();
    //查询对应条件的课程(年级,是否满员)
    public List<SCT_Course> getCourseByLimit(int grade , int startCount);
    //查询对应条件的课程(年级,是否满员)
    public int getCourseCountByLimit(int grade);
    //查询学生所选的课程
    public List<SCT_Course> getCourseIdByStu(int sid , int startCount);
    //查询学生所选的课程
    public int getCourseCountByStu(int sid);
    //查询老师所教的课程
    public List<SCT_Course> getCourseByTea(int tid , int startCount);
    //查询老师所教的课程
    public int getCourseCountByTea(int tid);
    //通过电话号获取该学生信息
    public SCT_Student getStudentByTel(String stel);
    //通过电话号获取该教师信息
    public SCT_Teacher getTaecherByTel(String ttel);
    //通过sid获取该学生信息
    public SCT_Student getStudentBySid(int sid);
    //通过tid获取该教师信息
    public SCT_Teacher getTeacherByTid(int tid);
    //通过cid获取课程信息
    public SCT_Course getCourseByCid(int cid);
    //查询课程是否满员
    public boolean getFullByCid(int cid);

    //***添加***
    //学生进行选课操作
    public void joinClass(int sid , int cid);
    //教师进行添加课程操作
    public void createClass(SCT_Course sct_course);

    //***删除***
    //学生退出课程
    public void exitClass(int sid , int cid);
    //教师删除课程
    public void deleteClass(int cid);
    public void deleteCourse(int cid);

    //***学生对应课程表变动***
    //nowCount+1
    public void nowCountUp(int cid);
    //nowCount-1
    public void nowCountDown(int cid);

}
