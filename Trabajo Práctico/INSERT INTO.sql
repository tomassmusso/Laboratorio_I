INSERT INTO Administrador (nombre, apellido, mail, usuario, contraseña, sector)
VALUES ('Juan', 'Pérez', 'juan.perez@universidad.com', 'juan.perez', '1234', 'Académica'),
('María', 'Gómez', 'maria.gomez@universidad.com', 'maria.gomez', '1234', 'Administración');

INSERT INTO Profesor (nombre, apellido, mail, usuario, contraseña, departamento)
VALUES
('Carlos', 'López', 'carlos.lopez@universidad.com', 'carlos.lopez', '1234', 'Informática'),
('Ana', 'Martínez', 'ana.martinez@universidad.com', 'ana.martinez', '1234', 'Matemática'),
('Diego', 'Fernández', 'diego.fernandez@universidad.com', 'diego.fernandez', '1234', 'Programación'),
('Laura', 'Sánchez', 'laura.sanchez@universidad.com', 'laura.sanchez', '1234', 'Bases de Datos'),
('Pablo', 'Rojas', 'pablo.rojas@universidad.com', 'pablo.rojas', '1234', 'Algoritmos');

INSERT INTO Alumno (nombre, apellido, mail, usuario, contraseña, limiteCursos, deuda)
VALUES
('Lucía', 'Ramírez', 'lucia.ramirez@alumnos.com', 'lucia.ramirez', '1234', 3, 0),
('Martín', 'Suárez', 'martin.suarez@alumnos.com', 'martin.suarez', '1234', 4, 0),
('Valentina', 'Torres', 'valentina.torres@alumnos.com', 'valentina.torres', '1234', 5, 0),
('Tomás', 'Ruiz', 'tomas.ruiz@alumnos.com', 'tomas.ruiz', '1234', 2, 0),
('Sofía', 'Castro', 'sofia.castro@alumnos.com', 'sofia.castro', '1234', 3, 0),
('Joaquín', 'Morales', 'joaquin.morales', 'joaquin.morales', '1234', 4, 0),
('Camila', 'Herrera', 'camila.herrera@alumnos.com', 'camila.herrera', '1234', 3, 0),
('Mateo', 'Vargas', 'mateo.vargas@alumnos.com', 'mateo.vargas', '1234', 4, 0),
('Agustina', 'Molina', 'agustina.molina@alumnos.com', 'agustina.molina', '1234', 5, 0),
('Nicolás', 'Benítez', 'nicolas.benitez@alumnos.com', 'nicolas.benitez', '1234', 2, 0),
('Florencia', 'Acosta', 'florencia.acosta@alumnos.com', 'florencia.acosta', '1234', 3, 0),
('Bruno', 'Cabrera', 'bruno.cabrera@alumnos.com', 'bruno.cabrera', '1234', 4, 0),
('Martina', 'Navarro', 'martina.navarro@alumnos.com', 'martina.navarro', '1234', 5, 0);

INSERT INTO Curso (nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, idProfesor, turno, cantidadParciales, notaAprobacion, notaPromocion)
VALUES
('Programación I', 30, '2026-08-10', '2026-12-05', 120000, '2026-07-01', '2026-07-31', 100000, 1, 'Mañana', 2, 4, 7),
('Base de Datos', 25, '2026-08-10', '2026-12-05', 130000, '2026-07-01', '2026-07-31', 110000, 4, 'Noche', 2, 4, 7),
('Matemática Discreta', 35, '2026-08-10', '2026-12-05', 110000, '2026-07-01', '2026-07-31', 95000, 2, 'Tarde', 3, 4, 7),
('Algoritmos', 40, '2026-08-10', '2026-12-05', 140000, '2026-07-01', '2026-07-31', 120000, 5, 'Mañana', 2, 4, 7),
('Ingeniería de Software', 30, '2026-08-10', '2026-12-05', 150000, '2026-07-01', '2026-07-31', 130000, 3, 'Noche', 2, 4, 7),
('Sistemas Operativos', 25, '2026-08-10', '2026-12-05', 125000, '2026-07-01', '2026-07-31', 105000, 1, 'Tarde', 2, 4, 7),
('Arquitectura de Computadoras', 20, '2026-08-10', '2026-12-05', 135000, '2026-07-01', '2026-07-31', 115000, 2, 'Mañana', 3, 4, 7),
('Inteligencia Artificial', 30, '2026-08-10', '2026-12-05', 160000, '2026-07-01', '2026-07-31', 140000, 5, 'Noche', 2, 4, 7);
