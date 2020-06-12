package dao.SCT_Dao_Impl;

import dao.SCT_Dao;
import domain.SCT_Choice;
import domain.SCT_Course;
import domain.SCT_Student;
import domain.SCT_Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

public class SCT_Dao_Impl implements SCT_Dao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void stu_register(SCT_Student sct_student) {
        String sql = "insert into sct_student values(null , ? , ? , ? , ?);";
        template.update(sql , sct_student.getSname() , sct_student.getSpassword() , sct_student.getSgrade() , sct_student.getStel());
    }

    @Override
    public void tea_register(SCT_Teacher sct_teacher) {
        String sql = "insert into sct_teacher values(null , ? , ? , ?);";
        template.update(sql , sct_teacher.getTname() , sct_teacher.getTpassword() , sct_teacher.getTtel());
    }

    @Override
    public boolean stu_login(String stel, String spassword) {
        String sql = "select * from sct_student where stel = ? and spassword = ?";
        SCT_Student sct_student = null;
        try{
            sct_student = template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Student.class) , stel , spassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sct_student != null;
    }

    @Override
    public boolean tea_login(String ttel, String tpassword) {
        String sql = "select * from sct_teacher where ttel = ? and tpassword = ?";
        SCT_Teacher sct_teacher = null;
        try{
            sct_teacher = template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Teacher.class) , ttel , tpassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sct_teacher != null;
    }

    @Override
    public boolean stu_check(String stel) {
        String sql = "select * from sct_student where stel = ?";
        SCT_Student sct_student = null;
        try{
            sct_student = template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Student.class) , stel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sct_student != null;
    }

    @Override
    public boolean tea_check(String ttel) {
        String sql = "select * from sct_teacher where ttel = ?";
        SCT_Teacher sct_teacher = null;
        try{
            sct_teacher = template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Teacher.class) , ttel);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sct_teacher != null;
    }

    @Override
    public boolean stuInClass(int sid , int cid) {
        String sql = "select * from sct_choice where sid = ? and cid = ?";
        SCT_Choice choice = null;
        try{
            choice = template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Choice.class) , sid , cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return choice != null;
    }

    @Override
    public void updateStuInfo(SCT_Student sct_student, int sid) {
        String sql = "update sct_student set sname = ? , spassword = ? , sgrade = ? , stel = ? where sid = ?";
        template.update(sql , sct_student.getSname() , sct_student.getSpassword() , sct_student.getSgrade() , sct_student.getStel() , sid);
    }

    @Override
    public void updateTeaInfo(SCT_Teacher sct_teacher, int tid) {
        String sql = "update sct_teacher set tname = ? , tpassword = ? , ttel = ? where tid = ?";
        template.update(sql , sct_teacher.getTname() , sct_teacher.getTpassword() , sct_teacher.getTtel() , tid);
    }

    @Override
    public void updateCourseInfo(SCT_Course course, int cid) {
        String sql = "update sct_course set cname = ? , countLimit = ? , gradeLimit = ? where cid = ?";
        template.update(sql , course.getCname() , course.getCountLimit() , course.getGradeLimit() , cid);
    }

    @Override
    public List<SCT_Course> getAllCourse(int startCount) {
        String sql = "select * from sct_course limit ? , 5";
        List<SCT_Course> courses = null;
        try{
            courses = template.query(sql , new BeanPropertyRowMapper<>(SCT_Course.class) , startCount);
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public int getAllCount() {
        String sql = "select count(*) from sct_course where countLimit <> nowCount";
        int count = 0;
        try{
            count = template.queryForObject(sql , Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<SCT_Course> getCourseByLimit(int grade , int startCount) {
        String sql = "select * from sct_course where gradeLimit = ? and countLimit <> nowCount limit ? , 5";
        List<SCT_Course> courses = null;
        try{
            courses = template.query(sql , new BeanPropertyRowMapper<>(SCT_Course.class) , grade , startCount);
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public int getCourseCountByLimit(int grade) {
        String sql = "select count(*) from sct_course where gradeLimit = ? and countLimit <> nowCount";
        int count = 0;
        try{
            count = template.queryForObject(sql , Integer.class , grade);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
}

    @Override
    public int getCourseCountByStu(int sid) {
        String sql = "select count(*) from sct_choice where sid = ?";
        int count = 0;
        try{
            count = template.queryForObject(sql , Integer.class , sid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<SCT_Course> getCourseIdByStu(int sid , int startCount) {
        String sql = "select sct_course.cid,cname,tid,countLimit,gradeLimit,nowCount from sct_course , sct_choice where sct_course.cid = sct_choice.cid and sid = ? limit ? , 5";
        List<SCT_Course> list = null;
        try{
            list = template.query(sql , new BeanPropertyRowMapper<>(SCT_Course.class) , sid , startCount);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SCT_Course> getCourseByTea(int tid, int startCount) {
        String sql = "select * from sct_course where tid = ? limit ? , 5";
        List<SCT_Course> courses = null;
        try{
            courses = template.query(sql , new BeanPropertyRowMapper<>(SCT_Course.class) , tid , startCount);
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public int getCourseCountByTea(int tid) {
        String sql = "select count(*) from sct_course where tid = ?";
        int count = 0;
        try{
            count = template.queryForObject(sql , Integer.class , tid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public SCT_Student getStudentByTel(String stel) {
        String sql = "select * from sct_student where stel = ?";
        return template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Student.class) , stel);
    }

    @Override
    public SCT_Teacher getTaecherByTel(String ttel) {
        String sql = "select * from sct_teacher where ttel = ?";
        return template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Teacher.class) , ttel);
    }

    @Override
    public SCT_Student getStudentBySid(int sid) {
        String sql = "select * from sct_student where sid = ?";
        return template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Student.class) , sid);
    }

    @Override
    public SCT_Teacher getTeacherByTid(int tid) {
        String sql = "select * from sct_teacher where tid = ?";
        return template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Teacher.class) , tid);
    }

    @Override
    public SCT_Course getCourseByCid(int cid) {
        String sql = "select * from sct_course where cid = ?";
        return template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Course.class) , cid);
    }

    @Override
    public boolean getFullByCid(int cid) {
        String sql = "select * from sct_course where countLimit <> nowCount and cid = ?";
        SCT_Course course = null;
        try{
            course = template.queryForObject(sql , new BeanPropertyRowMapper<>(SCT_Course.class) , cid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return course == null;
    }

    @Override
    public void joinClass(int sid, int cid) {
        String sql = "insert into sct_choice values(? , ?)";
        template.update(sql , sid , cid);
    }

    @Override
    public void createClass(SCT_Course sct_course) {
        String sql = "insert into sct_course values(null , ? , ? , ? , ? , 0)";
        template.update(sql , sct_course.getCname() , sct_course.getTid() , sct_course.getCountLimit() , sct_course.getGradeLimit());
    }

    @Override
    public void exitClass(int sid, int cid) {
        String sql = "delete from sct_choice where sid = ? and cid = ?";
        template.update(sql , sid , cid);
    }

    @Override
    public void deleteCourse(int cid) {
        String sql = "delete from sct_course where cid = ?";
        template.update(sql , cid);
    }

    @Override
    public void deleteClass(int cid) {
        String sql = "delete from sct_choice where cid = ?";
        template.update(sql , cid);
    }

    @Override
    public void nowCountUp(int cid) {
        String sql = "update sct_course set nowCount = nowCount + 1 where cid = ?";
        template.update(sql , cid);
    }

    @Override
    public void nowCountDown(int cid) {
        String sql = "update sct_course set nowCount = nowCount - 1 where cid = ?";
        template.update(sql , cid);
    }
}
