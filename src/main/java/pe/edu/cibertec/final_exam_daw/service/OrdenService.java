package pe.edu.cibertec.final_exam_daw.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.final_exam_daw.model.Ordenes;
import pe.edu.cibertec.final_exam_daw.repository.OrdenesRepository;

import java.util.Optional;

@Service
public class OrdenService {
    @Autowired
    private OrdenesRepository ordenesRepository;

    @CircuitBreaker(name = "getOrderService", fallbackMethod = "getOrderFallback")
    public Ordenes getOrderById(Long id) {
        String remoteResponse = metodoRemoto();
        Optional<Ordenes> orderOptional = ordenesRepository.findById(id);
        if (orderOptional.isPresent()) {
            Ordenes ordenes = orderOptional.get();
            ordenes.setEstadoDelPedido(ordenes.getEstadoDelPedido() + " - " + remoteResponse);
            return ordenes;
        } else {
            throw new RuntimeException("Pedido no encontrado");
        }
    }

    @CircuitBreaker(name = "metodoRemoto", fallbackMethod = "fallbackMetodoRemoto")
    public String metodoRemoto() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("Error en llamada");
        }
        return "Respuesta exitosa del servicio remoto";
    }

    public Ordenes getOrderFallback(Long id, Throwable throwable) {
        Ordenes fallbackOrder = new Ordenes();
        fallbackOrder.setIdPedido(id);
        fallbackOrder.setModelVehiculo("Unknown Model");
        fallbackOrder.setEstadoDelPedido("Servicio no disponible");
        fallbackOrder.setCorreo("unknown@example.com");
        return fallbackOrder;
    }

    public String fallbackMetodoRemoto(Throwable throwable) {
        return "Respuesta del fallback - El servicio remoto falló";
    }
}
