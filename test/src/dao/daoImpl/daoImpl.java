package dao.daoImpl;

import dao.dao;
import domain.student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

public class daoImpl implements dao{
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public void insertStudent(student student) {
        String sql = "insert into student values(?, ?, ?, ?);";
        template.update(sql , student.getSid() , student.getSname() , student.getSbirthday() , student.getSsex());
    }

    @Override
    public void deleteStudent(String sid) {
        String sql = "delete from student where sid = ?";
        template.update(sql , sid);
    }

    @Override
    public void UpdateStudent(student student) {
        String sql = "update student set sname = ? , sbirthday = ? , ssex = ? where sid = ?";
        template.update(sql , student.getSname() , student.getSbirthday() , student.getSsex() , student.getSid());
    }

    @Override
    public List<student> FindStudent(int startCount, student student) {
        List param = new ArrayList();
        StringBuffer sb = new StringBuffer();
        sb.append("select * from student where 1 = 1 ");
        if(!student.getSid().equals("")){
            sb.append(" and sid = ? ");
            param.add(student.getSid());
        }if(!student.getSname().equals("")){
            sb.append(" and sname like ? ");
            param.add("%" + student.getSname() + "%");
        }if(!student.getSbirthday().equals("")){
            sb.append(" and sbirthday = ? ");
            param.add(student.getSbirthday());
        }if(student.getSsex() == 0 || student.getSsex() == 1){
            sb.append(" and ssex = ? ");
            param.add(student.getSsex());
        }
        sb.append(" limit ? , 5");
        param.add(startCount);
        List<student> list = null;
        try{
            list = template.query(sb.toString() , new BeanPropertyRowMapper<student>(student.class) , param.toArray());
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int FindStudentCount(student student) {
        int count = 0;
        List param = new ArrayList();
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from student where 1 = 1 ");
        if(!student.getSid().equals("")){
            sb.append(" and sid = ? ");
            param.add(student.getSid());
        }if(!student.getSname().equals("")){
            sb.append(" and sname like ? ");
            param.add("%" + student.getSname() + "%");
        }if(!student.getSbirthday().equals("")){
            sb.append(" and sbirthday = ? ");
            param.add(student.getSbirthday());
        }if(student.getSsex() == 0 || student.getSsex() == 1){
            sb.append(" and ssex = ? ");
            param.add(student.getSsex());
        }
        try{
            count = template.queryForObject(sb.toString() , Integer.class , param.toArray());
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<student> FindAllStudent(int startCount) {
        String sql = "select * from student limit ? , 5";
        List<student> students = null;
        try {
            students = template.query(sql , new BeanPropertyRowMapper<student>(student.class) , startCount);
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int FindAllStudentCount() {
        int count = 0;
        String sql = "select count(*) from student";
        try {
            count = template.queryForObject(sql , Integer.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean isStudent(String sname, String sid) {
        student student = null;
        String sql = "select * from student where sname = ? and sid = ?";
        try{
            student = template.queryForObject(sql , new BeanPropertyRowMapper<student>(student.class) , sname , sid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student != null;
    }

    @Override
    public boolean hasStudent(String sid) {
        student student = null;
        String sql = "select * from student where sid = ?";
        try{
            student = template.queryForObject(sql , new BeanPropertyRowMapper<student>(student.class) , sid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student != null;
    }

    @Override
    public student getstudent(String sid) {
        student student = null;
        String sql = "select * from student where sid = ?";
        try{
            student = template.queryForObject(sql , new BeanPropertyRowMapper<student>(student.class) , sid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
}
