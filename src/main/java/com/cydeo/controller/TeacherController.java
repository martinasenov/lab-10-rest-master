package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.entity.Teacher;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {


    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    /*
           Endpoint: /api/v1/teacher

           JSON Response Body:
           <teachers data>
        */

        /*
           Endpoint: /api/v1/teacher/{username}
           HTTP Status Code: 200

           JSON Response Body:
           "success": true
           "message": "Teacher is successfully retrieved."
           "code":200
           "data":<teacher data>
        */

    @GetMapping("/{username}")
    public ResponseEntity<ResponseWrapper> getTeacherById(@PathVariable("username") String username) {
        ResponseWrapper teacherData= new ResponseWrapper("Teacher is successfully retrieved.",teacherService.findByUsername(username), HttpStatus.OK);
        return ResponseEntity.ok(teacherData);
    }


    @PostMapping
    public ResponseEntity<ResponseWrapper> createTeacher(@RequestBody TeacherDTO teacherDTO) {

        ResponseWrapper createdTeacher = new ResponseWrapper("Teacher is successfully created.", teacherService.createTeacher(teacherDTO), HttpStatus.CREATED);

        HttpHeaders headers = new HttpHeaders();
        headers.add("teacherUsername", String.valueOf(teacherDTO.getUsername()));

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(createdTeacher);
    }


       /*
           Endpoint: /api/v1/teacher
           HTTP Status Code: 201
           Custom Response Header: "teacherUsername", <created username>

           JSON Response Body:
           "success": true
           "message": "Teacher is successfully created."
           "code":201
           "data":<created teacher data>
     */

}
