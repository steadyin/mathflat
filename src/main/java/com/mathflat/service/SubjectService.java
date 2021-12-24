package com.mathflat.service;

import com.mathflat.dto.SubjectDTO;

public interface SubjectService {
    Long register(SubjectDTO dto);

    SubjectDTO findById(Long id);

    void delete(Long id);
}
