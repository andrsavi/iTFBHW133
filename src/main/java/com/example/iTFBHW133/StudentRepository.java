package com.example.iTFBHW133;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {
    private final ConcurrentHashMap<Long, Student> storage = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public Student save(Student student) {
        long id = counter.incrementAndGet();
        student.setId(id);
        storage.put(id, student);
        return student;
    }

    public Student findById(Long id) {
        return storage.get(id);
    }
}

