CREATE DATABASE FinalExam;
USE FinalExam;

CREATE TABLE ordenes (
    IdPedido BIGINT AUTO_INCREMENT PRIMARY KEY,
    ModelVehiculo VARCHAR(255) NOT NULL,
    EstadoDelPedido VARCHAR(100) NOT NULL,
    Correo VARCHAR(255) NOT NULL
);

INSERT INTO ordenes (ModelVehiculo, EstadoDelPedido, Correo)
VALUES
('Model S', 'Pedido realizado', 'cliente1@tesla.com'),
('Model X', 'En producción', 'cliente2@tesla.com'),
('Model 3', 'En tránsito', 'cliente3@tesla.com'),
('Model Y', 'Entregado', 'cliente4@tesla.com');

SELECT * FROM ordenes;
