package com.fcb.q2.batch.repository;

import com.fcb.q2.batch.entity.Student;
import com.fcb.q2.batch.repository.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaRepoWriter /*implements ItemWriter<Student>*/ {
    @Autowired
    StudentRepository studentRepository;

  /*  @Override
    public void write(Student items) throws Exception {
//        List<Student> students = items.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Size of list is " + students.size());
        *//*for(Student student : students){
            student.setStatus(true);
        }*//*
        studentRepository.saveAll(students);
    }*/
}
