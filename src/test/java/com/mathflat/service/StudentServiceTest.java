package com.mathflat.service;

import com.mathflat.dto.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    public void testRegister() {
        StudentDTO studentDTO = StudentDTO.builder()
//                .id(1L)
                .name("test")
                .age(99)
                .schoolType("abc")
                .phoneNumber("000000")
                .build();

        service.register(studentDTO);
    }
}