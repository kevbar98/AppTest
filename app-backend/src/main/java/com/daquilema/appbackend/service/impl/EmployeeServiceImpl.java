package com.daquilema.appbackend.service.impl;

import org.springframework.stereotype.Service;

import com.daquilema.appbackend.dto.EmployeeDto;
import com.daquilema.appbackend.entity.Employee;
import com.daquilema.appbackend.mapper.EmployeeMapper;
import com.daquilema.appbackend.repository.EmployeeRepository;
import com.daquilema.appbackend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
		
	}

	

}
