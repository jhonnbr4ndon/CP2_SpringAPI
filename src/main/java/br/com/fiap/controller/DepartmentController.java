package br.com.fiap.controller;

import br.com.fiap.controller.dto.DepartmentDTO;
import br.com.fiap.entity.Department;
import br.com.fiap.service.DepartmentService;
import br.com.fiap.service.Mapper.DepartmentMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@Tag(name = "Department", description = "CRUD do Department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> criarDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
        Department respostaDepartment = departmentService.criarDepartment(DepartmentMapper.toEntity(departmentDTO));
        return ResponseEntity.ok(DepartmentMapper.toDTO(respostaDepartment));
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> listarDepartments() {
        List<DepartmentDTO> listarDepartment = departmentService.procurarDepartment().stream().map(DepartmentMapper::toDTO).toList();
        return ResponseEntity.ok(listarDepartment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> buscarDepartment(@PathVariable Long id) {
        Department department = departmentService.buscarDepartamentID(id);
        return ResponseEntity.ok(DepartmentMapper.toDTO(department));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<DepartmentDTO> encontrarDepartamentoNome(@PathVariable String nome) {
        Department department = departmentService.encontrarDepartamento(nome);
        return ResponseEntity.ok(DepartmentMapper.toDTO(department));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> atualizarDepartamento(@PathVariable Long id, @Valid @RequestBody DepartmentDTO departmentDTO) {
        Department respostaDepartamento = departmentService.atualizarDepartment(id, DepartmentMapper.toEntity(departmentDTO));
        return ResponseEntity.ok(DepartmentMapper.toDTO(respostaDepartamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDepartamento(@PathVariable Long id) {
        departmentService.deletarDepartment(id);
        return ResponseEntity.noContent().build();
    }

}
