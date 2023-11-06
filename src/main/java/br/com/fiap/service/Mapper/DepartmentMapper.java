package br.com.fiap.service.Mapper;

import br.com.fiap.controller.dto.DepartmentDTO;
import br.com.fiap.entity.Department;

public class DepartmentMapper {

    public static Department toEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setNome(departmentDTO.getNome());
        department.setEmployees(departmentDTO.getEmployees());
        return department;
    }

    public static DepartmentDTO toDTO(Department entity) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setNome(entity.getNome());
        dto.setEmployees(entity.getEmployees());
        return dto;
    }
}
