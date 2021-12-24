package com.mathflat.entity;

import com.mathflat.dto.StudentDTO;
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
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String schoolType;

    private String phoneNumber;

    public StudentDTO toDTO() {
        return StudentDTO.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .schoolType(this.schoolType)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
