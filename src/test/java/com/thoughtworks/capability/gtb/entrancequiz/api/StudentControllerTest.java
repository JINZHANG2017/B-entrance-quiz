package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.data.StudentRepo;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldGetStudentList() throws Exception {
        mockMvc
                .perform(get("/student/list?isShuffle=0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].name", is("成吉思汗")));
    }

    @Test
    public void shouldGetRandomStudentList() throws Exception {
        mockMvc
                .perform(get("/student/list?isShuffle=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)));
    }

    @Test
    public void shouldShuffleStudentList() throws Exception {
        mockMvc
                .perform(get("/student/shuffle"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldAddStudent() throws Exception {

        StudentRepo studentRepo=new StudentRepo();
        List<Student> studentList=studentRepo.getStudentList();
        assertEquals(15,studentList.size());
        mockMvc
                .perform(post("/student/list").content("{\"name\":\"张三\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        studentList=studentRepo.getStudentList();
        assertEquals(16,studentList.size());
        assertEquals("张三",studentList.get(15).getName());
    }

}