package pe.edu.cibertec.final_exam_daw.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.final_exam_daw.model.Ordenes;

import java.util.Optional;

@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {
}
