package service.serviceImpl;

import dao.dao;
import dao.daoImpl.daoImpl;
import domain.student;
import service.service;

import java.util.List;

public class serviceImpl implements service{
    dao dao = new daoImpl();
    @Override
    public void insertStudent(student student) {
        dao.insertStudent(student);
    }

    @Override
    public void deleteStudent(String sid) {
        dao.deleteStudent(sid);
    }

    @Override
    public void UpdateStudent(student student) {
        dao.UpdateStudent(student);
    }

    @Override
    public List<student> FindStudent(int startCount, student student) {
        return dao.FindStudent(startCount , student);
    }

    @Override
    public int FindStudentCount(student student) {
        return dao.FindStudentCount(student);
    }

    @Override
    public List<student> FindAllStudent(int startCount) {
        return dao.FindAllStudent(startCount);
    }

    @Override
    public int FindAllStudentCount() {
        return dao.FindAllStudentCount();
    }

    @Override
    public boolean isStudent(String sname, String sid) {
        return dao.isStudent(sname , sid);
    }

    @Override
    public boolean hasStudent(String sid) {
        return dao.hasStudent(sid);
    }

    @Override
    public student getstudent(String sid) {
        return dao.getstudent(sid);
    }
}
