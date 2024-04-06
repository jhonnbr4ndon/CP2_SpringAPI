package br.com.fiap.service;

import br.com.fiap.entity.Department;
import br.com.fiap.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    public Department criarDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public List<Department> procurarDepartment() {
        return departmentRepository.findAll();
    }

    public Department buscarDepartamentID(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID"));
    }
    @Transactional
    public Department atualizarDepartment(Long id, Department newDepartment) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado com o ID"));

        existingDepartment.setNome(newDepartment.getNome());
        existingDepartment.setEmployees(newDepartment.getEmployees());

        return existingDepartment;
    }

    public void deletarDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department encontrarDepartamento(String nome) {

        return departmentRepository.encontrarDepartamento(nome);
    }
}
