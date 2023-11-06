package br.com.fiap.service;

import br.com.fiap.entity.Employee;
import br.com.fiap.repository.DepartmentRepository;
import br.com.fiap.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee criarFuncionario(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> procurarFuncionario() {
        return employeeRepository.findAll();
    }

    public Employee buscarFuncionarioID(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID"));
    }


    @Transactional
    public Employee atualizarFuncionario(Long id, Employee newEmployee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado com o ID"));

        existingEmployee.setName(newEmployee.getName());
        existingEmployee.setTitle(newEmployee.getTitle());
        existingEmployee.setSalary(newEmployee.getSalary());
        existingEmployee.setManager(newEmployee.getManager());

        return existingEmployee;
    }

    public void deletarFuncionario(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> faixaSalario(Float minSalary, Float maxSalary) {
        return employeeRepository.findBySalaryRange(minSalary, maxSalary);
    }

}
