package pe.edu.cibertec.final_exam_daw.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ordenes")
public class Ordenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdPedido;

    private String ModelVehiculo;
    private String EstadoDelPedido;
    private String Correo;
}
