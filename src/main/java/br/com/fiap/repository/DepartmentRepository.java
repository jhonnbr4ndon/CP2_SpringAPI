    package br.com.fiap.repository;
    
    import br.com.fiap.entity.Department;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface DepartmentRepository extends JpaRepository<Department, Long> {

        @Query("SELECT d FROM Department d WHERE d.nome = :nome")
        Department encontrarDepartamento(@Param("nome") String nome);

    }
