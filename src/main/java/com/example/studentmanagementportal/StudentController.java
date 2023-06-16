package com.example.studentmanagementportal;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
public class StudentController {


//    for calling the function of another class we have to create its object
    @Autowired
    StudentService studentService;


//    getting info of studetn by id

    @GetMapping("/get_info")
    public ResponseEntity getStudent(@RequestParam("id") int admissionNo){
        Student s = studentService.getStudent(admissionNo);

        if(s==null){
            return new ResponseEntity("student is not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }

//    add the student to our db and this is post API and we are sending object so request body
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s = studentService.addStudent(student);

       return new ResponseEntity(s,HttpStatus.CREATED);
    }

//    getting info by pathvariable
    @GetMapping("/get/{id}/{messege}")
    public ResponseEntity getStudent(@PathVariable("id") int admissionNo,@PathVariable("messege") String message){
       Student s = studentService.getStudent(admissionNo,message);

       if(s==null){
           return new ResponseEntity("Student Not found",HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity(s,HttpStatus.ACCEPTED);

    }

//    delete student
    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int admissionNo){
       String s = studentService.deleteStudent(admissionNo);

       return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }

//  update the course of student
    @PutMapping("/update")
    public ResponseEntity changeCourse(@RequestParam("id") int admissionNo,@RequestParam("course") String course){
       Student s =  studentService.changeCourse(admissionNo,course);

       if(s==null){
           return new ResponseEntity("student not found",HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }


//  find all the student whose age is greater than 25
    @GetMapping("/getTotal")
    public ResponseEntity getTotalStudent(){
        int total =  studentService.getTotalStudent();

        if(total <= 0){
            return new ResponseEntity("No students are greater than 25",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(total,HttpStatus.ACCEPTED);
    }

}
