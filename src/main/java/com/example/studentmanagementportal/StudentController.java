package com.example.studentmanagementportal;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
public class StudentController {

//    we are using hashmap as database
    HashMap<Integer,Student> studentdb = new HashMap<>();  // admission no is our primary key

//    getting info of studetn by id
    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admissionNo){
        return studentdb.get(admissionNo);
    }

//    add the student to our db and this is post API and we are sending object so request body
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentdb.put(student.getAdmissionNo(),student);
        return "Student get added successfully";
    }

//    getting info by pathvariable
    @GetMapping("/get/{id}/{messege}")
    public String getStudent(@PathVariable("id") int admissionNo,@PathVariable("messege") String message){
        Student s = studentdb.get(admissionNo);
        return s + message;

    }

//    delete student
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admissionNo){
        studentdb.remove(admissionNo);

        return "student deleted";
    }

}
