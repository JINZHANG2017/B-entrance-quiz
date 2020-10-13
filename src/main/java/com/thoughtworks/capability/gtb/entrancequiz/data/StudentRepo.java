package com.thoughtworks.capability.gtb.entrancequiz.data;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepo {
    private static final String ORIGIN_STR="成吉思汗,鲁班七号,太乙真人,钟无艳,花木兰,雅典娜,芈月,白起,刘禅,庄周,马超,刘备,哪吒,大乔,蔡文姬";
    public List<Student> getStudentList(){
        return list;
    }
    private static List<Student> list=new ArrayList<>();
    static {
        String[] strArray=ORIGIN_STR.split(",");
        for(int i=0;i<strArray.length;i++){
            list.add(new Student(i+1,strArray[i]));
        }
    }
}
