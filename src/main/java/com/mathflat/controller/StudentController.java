package com.mathflat.controller;

import com.mathflat.dto.StudentDTO;
import com.mathflat.error.BaseException;
import com.mathflat.response.Response;
import com.mathflat.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseBody

    public Response<?> registerStudent(@RequestBody StudentDTO studentDTO) {
        studentService.register(studentDTO);
        return Response.createResponse();
//        return "redirect:/student/" + resStudentId;
    }

    @GetMapping("/{studentId}")
    @ResponseBody
    public Response<?> findStudent(@PathVariable Long studentId) throws BaseException {
//        throw new BaseException(BusinessExceptionMessage.STUDENT_NOT_FOUND);
        return Response.createResponse(studentService.findById(studentId));
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/test")
    public void test() {
        throw new BaseException("TESTSET");
    }
}
