package com.mathflat.service;

import com.mathflat.dto.StudentDTO;
import com.mathflat.entity.Student;
import com.mathflat.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void register(StudentDTO dto) {
        studentRepository.save(dto.toEntity());
    }

    @Override
    public void delete(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) studentRepository.delete(student.get());
    }

    @Override
    public StudentDTO findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다.")).toDTO();
    }
}
