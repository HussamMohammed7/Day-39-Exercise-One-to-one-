package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.Api.ApiException;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher) {
        Teacher updateTeacher = teacherRepository.findTeacherById(id);

        if (updateTeacher == null) {
            throw new ApiException("Teacher not found");
        }
        updateTeacher.setName(teacher.getName());
        updateTeacher.setAge(teacher.getAge());
        updateTeacher.setEmail(teacher.getEmail());
        updateTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(updateTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher deleteTeacher = teacherRepository.findTeacherById(id);

        if (deleteTeacher == null) {
            throw new ApiException("Teacher not found");
        }

        teacherRepository.delete(deleteTeacher);
    }
    public Teacher getTeacher(Integer teacherId) {
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        return teacher;
    }
}
