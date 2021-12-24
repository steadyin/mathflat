package com.mathflat.dto;

import com.mathflat.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    private Long id;

    private Long subjectId;

    private Long studentId;

    public Subject toEntity() {
        return Subject.builder()
                .id(this.id)
                .subjectId(this.subjectId)
                .studentId(this.studentId)
                .build();
    }
}
