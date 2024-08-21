package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@Valid @RequestBody Teacher teacher, @PathVariable Integer id) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body("Teacher deleted successfully");
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity getTeacher(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacher(id));

    }
}
