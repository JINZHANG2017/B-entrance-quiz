package com.thoughtworks.capability.gtb.entrancequiz.api;

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
    public ResponseEntity<List<String>> getStudentList(){
        List<String> list=new ArrayList<>();
        list.add("hello");
        return ResponseEntity.ok(list);
    }
}
