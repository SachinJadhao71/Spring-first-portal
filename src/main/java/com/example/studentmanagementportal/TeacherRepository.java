package com.example.studentmanagementportal;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
@Repository
public class TeacherRepository {

    HashMap<Integer,Teacher> teacherDb = new HashMap<>();


    public Teacher getTeacher(int teacherId) {
        if(teacherDb.containsKey(teacherId)){
            return teacherDb.get(teacherId);
        }
        else{
            return null;
        }
    }

    public String addTeacher(Teacher teacher) {
        if(teacherDb.containsKey(teacher.getTeacherId())){
            return null;
        }
        else{
            teacherDb.put(teacher.getTeacherId(), teacher);
            return "Teacher added successfully";
        }
    }

    public Teacher getTeacher(int teacherId,String message){
        if(!teacherDb.containsKey(teacherId)){
            throw new RuntimeException("teacher not found");
        }
        else{
            return teacherDb.get(teacherId);
        }
    }
}
