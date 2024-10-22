package pe.edu.cibertec.final_exam_daw.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.final_exam_daw.model.Ordenes;
import pe.edu.cibertec.final_exam_daw.service.OrdenService;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/ordenes")
public class OperacionController {
    @Autowired
    private OrdenService ordenService;

    @GetMapping("/{id}")
    public Ordenes getOrder(@PathVariable Long id) {
        return ordenService.getOrderById(id);
    }

    @GetMapping("/remoto")
    public String metodoRemoto() {
        return ordenService.metodoRemoto();
    }
}
