package com.mathflat.service;

import com.mathflat.dto.StudentDTO;
import com.mathflat.entity.Student;

public interface StudentService {
    void register(StudentDTO dto);

    StudentDTO findById(Long id);

    void delete(Long id);


}
