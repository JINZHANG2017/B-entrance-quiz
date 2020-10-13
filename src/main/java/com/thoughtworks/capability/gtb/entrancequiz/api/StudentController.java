package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.data.StudentRepo;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class StudentController {
    @GetMapping("/student/list")
    public ResponseEntity<List<Student>> getStudentList(@RequestParam Integer isShuffle){
//        List<String> list=new ArrayList<>();
//        list.add("hello");
        StudentRepo studentRepo=new StudentRepo();
        List<Student> studentList=new ArrayList<>();
        if(isShuffle!=null&&isShuffle==1){
            studentList=studentRepo.getRandomStudentList();
        }else{
            studentList=studentRepo.getStudentList();
        }
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("/student/shuffle")
    public ResponseEntity<List<Student>> shuffleStudentList(){
//        List<String> list=new ArrayList<>();
//        list.add("hello");
        StudentRepo studentRepo=new StudentRepo();
        List<Student> studentList=new ArrayList<>();
        StudentRepo.shuffle();
        studentList=studentRepo.getRandomStudentList();
        return ResponseEntity.ok(studentList);
    }

//    @GetMapping("/student/list")
//    public ResponseEntity<List<Student>> getStudentList(){
////        List<String> list=new ArrayList<>();
////        list.add("hello");
//        StudentRepo studentRepo=new StudentRepo();
//        List<Student> studentList = studentRepo.getStudentList();
//        return ResponseEntity.ok(studentList);
//    }
}
