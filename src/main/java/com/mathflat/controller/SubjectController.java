package com.mathflat.controller;

import com.mathflat.dto.SubjectDTO;
import com.mathflat.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public String registerSubject(@RequestBody SubjectDTO subjectDTO) {
        Long resSubjectId = subjectService.register(subjectDTO);
        return "redirect:/subject/" + resSubjectId;
    }

    @GetMapping("/{subjectId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SubjectDTO findSubject(@PathVariable Long subjectId) {
        return subjectService.findById(subjectId);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId) {
//        subjectService.delete(subjectId);
    }
}
