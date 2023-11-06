package br.com.fiap.service.Mapper;

import br.com.fiap.controller.dto.EmployeeDTO;
import br.com.fiap.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setTitle(employeeDTO.getTitle());
        employee.setSalary(employeeDTO.getSalary());
        employee.setManager(employeeDTO.getManager());
        return  employee;
    }

    public static EmployeeDTO toDTO(Employee entity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(entity.getName());
        employeeDTO.setTitle(entity.getTitle());
        employeeDTO.setSalary(entity.getSalary());
        employeeDTO.setManager(entity.getManager());
        return employeeDTO;
    }
}
