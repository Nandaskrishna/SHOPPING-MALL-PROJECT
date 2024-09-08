package com.mit.employeeservice_nanda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

@Autowired
private EmployeeService prod;

@GetMapping("/emp")
public List<Employee> getAllStudents() {
    return prod.getAllStudents();
}
@GetMapping("/emp/{id}")
public ResponseEntity<Employee> getStudentById(@PathVariable Long id) {
	Employee student = prod.getStudentById(id);
    if (student != null) {
        return new ResponseEntity<>(student, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@PostMapping("/emp")
public Employee createStudent(@RequestBody Employee student) {
    return prod.saveStudent(student);
}

@PutMapping("/emp/{id}")
public ResponseEntity<Employee> updateStudent(@PathVariable Long id, @RequestBody Employee studentDetails) {
	Employee student = prod.getStudentById(id);
    if (student != null) {
        student.setContactNumber(studentDetails.getContactNumber());
        student.setName(studentDetails.getName());
        student.setRole(studentDetails.getRole());
        
        Employee updatedStudent = prod.saveStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/emp/{id}")
public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
    prod.deleteStudent(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}}
