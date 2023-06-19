package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @GetMapping("/get_info_teacher")
    public ResponseEntity getTeacher(@RequestParam("id") int teacherId){
        Teacher t = teacherService.getTeacher(teacherId);
        if(t == null){
            return new ResponseEntity("Teacher is Not present",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(t, HttpStatus.ACCEPTED);
    }

    @PostMapping("/addteacher")
    public ResponseEntity addTeacher(@RequestBody Teacher teacher){
        String s = teacherService.addTeacher(teacher);

        if(s==null){
            return new ResponseEntity("Teacher already present",HttpStatus.ALREADY_REPORTED);
        }

        return new ResponseEntity("Teacher Added successfully",HttpStatus.ACCEPTED);
    }


    @GetMapping("/getInfo/{teacherId}/{message}")
    public ResponseEntity getTeacher(@PathVariable("teacherId") int teacherId,@PathVariable("message") String message){
        Teacher t = teacherService.getTeacher(teacherId,message);

        if(t==null){
            return new ResponseEntity("teacher is Not found",HttpStatus.NOT_FOUND);
        }
        System.out.println(message);
        return new ResponseEntity(t,HttpStatus.ACCEPTED);
    }
}
