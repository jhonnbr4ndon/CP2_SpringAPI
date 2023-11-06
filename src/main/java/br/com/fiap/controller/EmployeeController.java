package br.com.fiap.controller;

import br.com.fiap.controller.dto.EmployeeDTO;
import br.com.fiap.entity.Employee;
import br.com.fiap.service.EmployeeService;
import br.com.fiap.service.Mapper.EmployeeMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee", description = "CRUD do Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> criarFuncionario(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee respostaFuncionario = employeeService.criarFuncionario(EmployeeMapper.toEntity(employeeDTO));
        return ResponseEntity.ok(EmployeeMapper.toDTO(respostaFuncionario));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> listarFuncionarios() {
        List<EmployeeDTO> listarFuncionario = employeeService.procurarFuncionario().stream().map(EmployeeMapper::toDTO).toList();
        return ResponseEntity.ok(listarFuncionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> buscarFuncionario(@PathVariable Long id) {
        Employee employee = employeeService.buscarFuncionarioID(id);
        return ResponseEntity.ok(EmployeeMapper.toDTO(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> atualizarFuncionario(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee respostaFuncionario = employeeService.atualizarFuncionario(id, EmployeeMapper.toEntity(employeeDTO));
        return ResponseEntity.ok(EmployeeMapper.toDTO(respostaFuncionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        employeeService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/faixa-salario")
    public ResponseEntity<List<EmployeeDTO>> faixaSalarioFuncionario(
            @RequestParam("minSalary") Float minSalary,
            @RequestParam("maxSalary") Float maxSalary) {
        List<EmployeeDTO> employeesInSalaryRange = employeeService.faixaSalario(minSalary, maxSalary)
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
        return ResponseEntity.ok(employeesInSalaryRange);
    }
}
