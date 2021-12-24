package com.mathflat.entity;

import com.mathflat.dto.SubjectDTO;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long subjectId;

    private Long studentId;

    public SubjectDTO toDTO() {
        return SubjectDTO.builder()
                .id(this.id)
                .subjectId(this.subjectId)
                .studentId(this.studentId)
                .build();
    }
}
