package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.data.StudentRepo;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @GetMapping("/student/list")
    public ResponseEntity<List<Student>> getStudentList(){
//        List<String> list=new ArrayList<>();
//        list.add("hello");
        StudentRepo studentRepo=new StudentRepo();
        List<Student> studentList = studentRepo.getStudentList();
        return ResponseEntity.ok(studentList);
    }
}
