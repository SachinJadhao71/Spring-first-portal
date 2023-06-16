package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    we are calling function of respository class, so we have to create repository object
    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int admissionNo) {
        return studentRepository.getStudent(admissionNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudent(int admissionNo, String message){
        return studentRepository.getStudent(admissionNo,message);
    }

    public String deleteStudent(int admissionNo) {
        return studentRepository.deleteStudent(admissionNo);
    }

    public Student changeCourse(int admissionNo, String course) {
        return studentRepository.changeCourse(admissionNo,course);
    }

    public int getTotalStudent() {
        return studentRepository.getTotalStudent();
    }
}
