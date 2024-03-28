package com.daquilema.appbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daquilema.appbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
}
