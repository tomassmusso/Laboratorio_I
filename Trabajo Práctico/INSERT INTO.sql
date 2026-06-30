INSERT INTO Alumno (nombre, apellido, mail, usuario, contraseña, limiteCursos, deuda) VALUES
('Juan', 'Pérez', 'juan.perez@mail.com', 'juan.perez', '1234', 3, 0.00),
('María', 'Gómez', 'maria.gomez@mail.com', 'maria.gomez', '1234', 4, 15000.00),
('Lucas', 'Fernández', 'lucas.fernandez@mail.com', 'lucas.fernandez', '1234', 2, 0.00),
('Sofía', 'Martínez', 'sofia.martinez@mail.com', 'sofia.martinez', '1234', 5, 25000.00),
('Tomás', 'López', 'tomas.lopez@mail.com', 'tomas.lopez', '1234', 3, 8000.00),
('Valentina', 'Rodríguez', 'valentina.rodriguez@mail.com', 'valentina.rodriguez', '1234', 4, 0.00),
('Franco', 'Sosa', 'franco.sosa@mail.com', 'franco.sosa', '1234', 2, 12000.00),
('Camila', 'Suárez', 'camila.suarez@mail.com', 'camila.suarez', '1234', 3, 0.00);

INSERT INTO Profesor (nombre, apellido, mail, usuario, contraseña, departamento) VALUES
('Carlos', 'Ruiz', 'carlos.ruiz@mail.com', 'carlos.ruiz', '1234', 'Programación'),
('Laura', 'Méndez', 'laura.mendez@mail.com', 'laura.mendez', '1234', 'Matemática'),
('Diego', 'Castro', 'diego.castro@mail.com', 'diego.castro', '1234', 'Bases de Datos'),
('Ana', 'Torres', 'ana.torres@mail.com', 'ana.torres', '1234', 'Redes');

INSERT INTO Administrador (nombre, apellido, mail, usuario, contraseña, sector) VALUES
('Martín', 'García', 'martin.garcia@mail.com', 'martin.garcia', '1234', 'Administración'),
('Julieta', 'Morales', 'julieta.morales@mail.com', 'julieta.morales', '1234', 'Académico');

INSERT INTO Curso (nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, idProfesor, turno, cantidadParciales, notaAprobacion, notaPromocion) VALUES
('Programación I', 30, '2026-03-10', '2026-07-10', 120000, '2026-02-01', '2026-03-01', 100000, 1, 'Mañana', 2, 4.0, 7.0),
('Programación II', 25, '2026-03-10', '2026-07-10', 130000, '2026-02-01', '2026-03-01', 110000, 1, 'Noche', 2, 4.0, 7.0),
('Álgebra', 40, '2026-03-15', '2026-07-15', 100000, '2026-02-05', '2026-03-05', 85000, 2, 'Tarde', 2, 4.0, 7.0),
('Análisis Matemático', 35, '2026-03-15', '2026-07-15', 105000, '2026-02-05', '2026-03-05', 90000, 2, 'Mañana', 2, 4.0, 7.0),
('Bases de Datos', 30, '2026-03-20', '2026-07-20', 140000, '2026-02-10', '2026-03-10', 120000, 3, 'Noche', 3, 4.0, 7.0),
('Laboratorio de Bases de Datos', 20, '2026-03-20', '2026-07-20', 145000, '2026-02-10', '2026-03-10', 125000, 3, 'Tarde', 3, 4.0, 7.0),
('Redes I', 30, '2026-03-12', '2026-07-12', 125000, '2026-02-01', '2026-03-01', 105000, 4, 'Mañana', 2, 4.0, 7.0),
('Seguridad Informática', 25, '2026-03-12', '2026-07-12', 150000, '2026-02-01', '2026-03-01', 130000, 4, 'Noche', 2, 4.0, 7.0);

INSERT INTO Inscripcion (alumnoId, cursoId, notaFinal, finalizada) VALUES
(1,1,NULL,FALSE),
(1,3,NULL,FALSE),
(2,1,NULL,FALSE),
(2,5,NULL,FALSE),
(3,2,NULL,FALSE),
(3,7,NULL,FALSE),
(4,4,NULL,FALSE),
(4,5,NULL,FALSE),
(5,1,NULL,FALSE),
(5,8,NULL,FALSE),
(6,3,NULL,FALSE),
(6,6,NULL,FALSE),
(7,2,NULL,FALSE),
(7,4,NULL,FALSE),
(8,7,NULL,FALSE),
(8,8,NULL,FALSE);

INSERT INTO NotaParcial (inscripcionId, nota) VALUES;
