package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.data.StudentRepo;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
// GTB: 无用的代码应该删除
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StudentController {
    // GTB: 违反Restful实践, url不合理
    // GTB: ResponseEntity应该使用泛型
    @GetMapping("/student/list")
    public ResponseEntity<List<Student>> getStudentList(@RequestParam Integer isShuffle){
        // GTB: 无用的代码应该删除
//        List<String> list=new ArrayList<>();
//        list.add("hello");
        // GTB: 代码风格问题，等号两边要加空格，很多该加空格的地方都没加空格
        // GTB: StudentRepo实例应该被注入进来，而非自己new
        StudentRepo studentRepo=new StudentRepo();
        // GTB: 无用的初始值
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
    // GTB: 应该定义对象来接收RequestBody
    // GTB: Post请求应该返回201
    // GTB: 方法名不合理，名不副实
    public ResponseEntity getStudentList(@RequestBody Map studentNameMap){
//        List<String> list=new ArrayList<>();
//        list.add("hello");
        StudentRepo studentRepo=new StudentRepo();
        List<Student> studentList=studentRepo.getStudentList();
        // GTB: “studentList.size() + 1”不可读，建议引入中间变量
        // GTB: 保存数据的操作应该封装进Repository
        // GTB: 不符合三层架构，缺少Service层来处理业务逻辑
        studentList.add(new Student(studentList.size()+1,studentNameMap.get("name").toString()));
        return ResponseEntity.ok().build();
    }
}
