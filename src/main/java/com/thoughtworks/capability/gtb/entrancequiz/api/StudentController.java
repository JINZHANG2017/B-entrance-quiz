package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.data.StudentRepo;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/student/list")
    public ResponseEntity getStudentList(@RequestBody Map studentNameMap){
//        List<String> list=new ArrayList<>();
//        list.add("hello");
        StudentRepo studentRepo=new StudentRepo();
        List<Student> studentList=studentRepo.getStudentList();
        studentList.add(new Student(studentList.size()+1,studentNameMap.get("name").toString()));
        return ResponseEntity.ok().build();
    }
}
