package com.fcb.q2.batch.repository;

import com.fcb.q2.batch.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
   /* List<Student> findFirst10ByStatusOrderByIdDesc(Boolean status);
    long countByStatus(Boolean status);*/
}
