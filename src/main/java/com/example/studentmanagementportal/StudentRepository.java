package com.example.studentmanagementportal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepository {

    //    we are using hashmap as database
    HashMap<Integer,Student> studentdb = new HashMap<>();  // admission no is our primary key

    public Student getStudent(int admissionNo) {
        if(studentdb.containsKey(admissionNo)) {
            return studentdb.get(admissionNo);
        }

        return null;
    }

    public String addStudent(Student student) {
        if(studentdb.containsKey(student.getAdmissionNo())){
            return "student is already present";
        }

        studentdb.put(student.getAdmissionNo(),student);
        return "student added successfully";
    }

    public Student getStudent(int admissionNo, String message){
        if(studentdb.containsKey(admissionNo)){
            return studentdb.get(admissionNo);
        }
        return null;
    }

    public String deleteStudent(int admissionNo) {
        if(studentdb.containsKey(admissionNo)){
            studentdb.remove(admissionNo);
            return "student deleted successfully";
        }
        else{
            return "student is not present";
        }
    }

    public Student changeCourse(int admissionNo, String course) {
        if(studentdb.containsKey(admissionNo)){
            Student s = studentdb.get(admissionNo);

            s.setCourse(course);

            studentdb.put(admissionNo,s);

            return studentdb.get(admissionNo);
        }

        return null;
    }

    public int getTotalStudent() {

        int count=0;
//        traverse on our Db
        for(int key : studentdb.keySet()){
            Student s = studentdb.get(key);
            if(s.getAge() > 25){
                count++;
            }
        }

        return count;
    }
}
