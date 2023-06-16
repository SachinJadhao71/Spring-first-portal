package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
public class StudentController {


//    for calling the function of another class we have to create its object
    @Autowired
    StudentService studentService;


//    getting info of studetn by id

    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admissionNo){
        return studentService.getStudent(admissionNo);
    }

//    add the student to our db and this is post API and we are sending object so request body
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

//    getting info by pathvariable
    @GetMapping("/get/{id}/{messege}")
    public Student getStudent(@PathVariable("id") int admissionNo,@PathVariable("messege") String message){
       return studentService.getStudent(admissionNo,message);

    }

//    delete student
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admissionNo){
       return studentService.deleteStudent(admissionNo);
    }

//  update the course of student
    @PutMapping("/update")
    public Student changeCourse(@RequestParam("id") int admissionNo,@RequestParam("course") String course){
       return studentService.changeCourse(admissionNo,course);
    }


//  find all the student whose age is greater than 25
    @GetMapping("/getTotal")
    public int getTotalStudent(){
        return studentService.getTotalStudent();
    }

}
