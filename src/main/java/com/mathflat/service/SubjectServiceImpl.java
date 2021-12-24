package com.mathflat.service;

import com.mathflat.dto.SubjectDTO;
import com.mathflat.entity.Subject;
import com.mathflat.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Long register(SubjectDTO dto) {
        log.info("DTO--------------------------");
        log.info(dto);

        Subject resSubject = subjectRepository.save(dto.toEntity());
        System.out.println(resSubject);
        return resSubject.getId();
    }

    @Override
    public void delete(Long id) {
        log.info("Student ID--------------------------");
        log.info(id);

        Optional<Subject> subject = subjectRepository.findById(id);

        if (subject.isPresent()) subjectRepository.delete(subject.get());
    }

    @Override
    public SubjectDTO findById(Long id) {
        log.info("Student ID--------------------------");
        log.info(id);

        return subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 아이디입니다.")).toDTO();
    }
}
