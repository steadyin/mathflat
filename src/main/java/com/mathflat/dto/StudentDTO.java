package com.mathflat.dto;

import com.mathflat.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;

//    @NotBlank(message = "이름을 필수 입력 값입니다.")
    private String name;


//    Blank(message = "나이는 필수 입력 값입니다.")
    private int age;

    private String schoolType;

    private String phoneNumber;

    public Student toEntity() {
        return Student.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .schoolType(this.schoolType)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}



