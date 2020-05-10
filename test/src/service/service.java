package service;

import domain.student;

import java.util.List;

public interface service {

    //增
    public void insertStudent(student student);
    //删
    public void deleteStudent(String sid);
    //改
    public void UpdateStudent(student student);
    //查
    public List<student> FindStudent(int startCount , student student);
    public int FindStudentCount(student student);
    public List<student> FindAllStudent(int startCount);
    public int FindAllStudentCount();
    public boolean isStudent(String sname , String sid);
    public boolean hasStudent(String sid);
    public student getstudent(String sid);
}
