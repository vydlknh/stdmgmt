package com.example.demo.endpoint;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/students")
public class StudentEndpoint {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Student> findByCode(@PathVariable Integer code) {
        Optional<Student> studentOptional = studentService.findById(code);
        return studentOptional.map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/students")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@RequestBody Student student, @PathVariable Integer code) {
        Optional<Student> studentOptional = studentService.findById(code);
        return studentOptional.map(student1 -> {
            student.setCode(student1.getCode());
            return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Student> delete(@PathVariable Integer code) {
        Optional<Student> studentOptional = studentService.findById(code);
        return studentOptional.map(student -> {
            studentService.remove(code);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
