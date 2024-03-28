package com.daquilema.appbackend.service.impl;

import org.springframework.stereotype.Service;

import com.daquilema.appbackend.dto.EmployeeDto;
import com.daquilema.appbackend.entity.Employee;
import com.daquilema.appbackend.exception.ResourceNotFoundException;
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

	@Override
	public EmployeeDto getEmployeeByUsuario(String usuario) {
	    Employee employee = employeeRepository.findByUsuario(usuario)
	            .orElseThrow(() -> new ResourceNotFoundException("El usuario '" + usuario + "' no existe en la base de datos."));
	    return EmployeeMapper.mapToEmployeeDto(employee);
	}
}

