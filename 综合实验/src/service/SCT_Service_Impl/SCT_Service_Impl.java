package service.SCT_Service_Impl;

import dao.SCT_Dao;
import dao.SCT_Dao_Impl.SCT_Dao_Impl;
import domain.SCT_Course;
import domain.SCT_Student;
import domain.SCT_Teacher;
import service.SCT_Service;

import java.util.List;

public class SCT_Service_Impl implements SCT_Service {

    SCT_Dao dao = new SCT_Dao_Impl();

    @Override
    public void stu_register(SCT_Student sct_student) {
        dao.stu_register(sct_student);
    }

    @Override
    public void tea_register(SCT_Teacher sct_teacher) {
        dao.tea_register(sct_teacher);
    }

    @Override
    public boolean stu_login(String sname, String spassword) {
        return dao.stu_login(sname , spassword);
    }

    @Override
    public boolean tea_login(String tname, String tpassword) {
        return dao.tea_login(tname , tpassword);
    }

    @Override
    public boolean stu_check(String sCardId) {
        return dao.stu_check(sCardId);
    }

    @Override
    public boolean tea_check(String tCardId) {
        return dao.tea_check(tCardId);
    }

    @Override
    public boolean stuInClass(int sid , int cid) {
        return dao.stuInClass(sid , cid);
    }

    @Override
    public void updateStuInfo(SCT_Student sct_student, int sid) {
        dao.updateStuInfo(sct_student , sid);
    }

    @Override
    public void updateTeaInfo(SCT_Teacher sct_teacher, int tid) {
        dao.updateTeaInfo(sct_teacher , tid);
    }

    @Override
    public void updateCourseInfo(SCT_Course course, int cid) {
        dao.updateCourseInfo(course , cid);
    }

    @Override
    public List<SCT_Course> getAllCourse(int startCount) {
        return dao.getAllCourse(startCount);
    }

    @Override
    public int getAllCount() {
        return dao.getAllCount();
    }

    @Override
    public List<SCT_Course> getCourseByLimit(int grade , int startCount) {
        return dao.getCourseByLimit(grade , startCount);
    }

    @Override
    public int getCourseCountByLimit(int grade) {
        return dao.getCourseCountByLimit(grade);
    }

    @Override
    public List<SCT_Course> getCourseIdByStu(int sid , int startCount) {
        return dao.getCourseIdByStu(sid , startCount);
    }

    @Override
    public int getCourseCountByStu(int sid) {
        return dao.getCourseCountByStu(sid);
    }

    @Override
    public List<SCT_Course> getCourseByTea(int tid, int startCount) {
        return dao.getCourseByTea(tid , startCount);
    }

    @Override
    public int getCourseCountByTea(int tid) {
        return dao.getCourseCountByTea(tid);
    }

    @Override
    public SCT_Student getStudentByTel(String stel) {
        return dao.getStudentByTel(stel);
    }

    @Override
    public SCT_Teacher getTaecherByTel(String ttel) {
        return dao.getTaecherByTel(ttel);
    }

    @Override
    public SCT_Student getStudentBySid(int sid) {
        return dao.getStudentBySid(sid);
    }

    @Override
    public SCT_Teacher getTeacherByTid(int tid) {
        return dao.getTeacherByTid(tid);
    }

    @Override
    public SCT_Course getCourseByCid(int cid) {
        return dao.getCourseByCid(cid);
    }

    @Override
    public boolean getFullByCid(int cid) {
        return dao.getFullByCid(cid);
    }

    @Override
    public void joinClass(int sid, int cid) {
        dao.joinClass(sid , cid);
        dao.nowCountUp(cid);
    }

    @Override
    public void createClass(SCT_Course sct_course) {
        dao.createClass(sct_course);
    }

    @Override
    public void exitClass(int sid, int cid) {
        dao.exitClass(sid , cid);
        dao.nowCountDown(cid);
    }

    @Override
    public void deleteClass(int cid) {
        dao.deleteClass(cid);
        dao.deleteCourse(cid);
    }

}
