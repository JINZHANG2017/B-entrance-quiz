package com.thoughtworks.capability.gtb.entrancequiz.data;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// GTB: Repo建议写全拼
// GTB: StudentRepo不是一个合格的Repository层
public class StudentRepo {
    private static final String ORIGIN_STR="成吉思汗,鲁班七号,太乙真人,钟无艳,花木兰,雅典娜,芈月,白起,刘禅,庄周,马超,刘备,哪吒,大乔,蔡文姬";
    public List<Student> getStudentList(){
        return list;
    }
    private static List<Student> list=new ArrayList<>();
    static {
        // GTB: 可以使用Java8 Stream API简化
        String[] strArray=ORIGIN_STR.split(",");
        for(int i=0;i<strArray.length;i++){
            list.add(new Student(i+1,strArray[i]));
        }
    }

    private static List<Student> shuffleList=new ArrayList<>(list);

    public List<Student> getRandomStudentList(){
        //shuffle();
        return shuffleList;
    }

    public static void shuffle(){
        shuffleList=new ArrayList<>(list);
        Collections.shuffle(shuffleList);
    }
}
