package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;
    public Teacher getTeacher(int teacherId) {
        return teacherRepository.getTeacher(teacherId);
    }

    public String addTeacher(Teacher teacher) {
        return teacherRepository.addTeacher(teacher);
    }

    public Teacher getTeacher(int teacherId,String message){
        return teacherRepository.getTeacher(teacherId,message);
    }
}
