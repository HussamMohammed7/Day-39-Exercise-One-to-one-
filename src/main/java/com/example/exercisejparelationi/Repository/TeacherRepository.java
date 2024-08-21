package com.example.exercisejparelationi.Repository;

import com.example.exercisejparelationi.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findTeacherById (Integer id);


}
