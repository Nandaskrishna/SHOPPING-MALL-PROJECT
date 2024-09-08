package com.mit.employeeservice_nanda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
	 @Autowired
	    private EmployeeRepository studentRepository;

	    
	    
	    public List<Employee> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    public Employee getStudentById(Long id) {
	        return studentRepository.findById(id).orElse(null);
	    }

	    public Employee saveStudent(Employee student) {
	        return studentRepository.save(student);
	    }

	    public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }
	    }
