INSERT INTO Administrador (nombre, apellido, mail, usuario, contraseña, sector)
VALUES
('Juan', 'Pérez', 'juan.perez@universidad.com', 'juan.perez', '1234', 'Académica'),
('María', 'Gómez', 'maria.gomez@universidad.com', 'maria.gomez', '1234', 'Administración');

INSERT INTO Profesor (nombre, apellido, mail, usuario, contraseña, departamento)
VALUES
('Carlos', 'López', 'carlos.lopez@universidad.com', 'carlos.lopez', '1234', 'Informática'),
('Ana', 'Martínez', 'ana.martinez@universidad.com', 'ana.martinez', '1234', 'Matemática'),
('Diego', 'Fernández', 'diego.fernandez@universidad.com', 'diego.fernandez', '1234', 'Programación');

INSERT INTO Alumno (nombre, apellido, mail, usuario, contraseña, limiteCursos, deuda)
VALUES
('Lucía', 'Ramírez', 'lucia.ramirez@alumnos.com', 'lucia.ramirez', '1234', 3, 0),
('Martín', 'Suárez', 'martin.suarez@alumnos.com', 'martin.suarez', '1234', 4, 0),
('Valentina', 'Torres', 'valentina.torres@alumnos.com', 'valentina.torres', '1234', 5, 0),
('Tomás', 'Ruiz', 'tomas.ruiz@alumnos.com', 'tomas.ruiz', '1234', 2, 0),
('Sofía', 'Castro', 'sofia.castro@alumnos.com', 'sofia.castro', '1234', 3, 0),
('Joaquín', 'Morales', 'joaquin.morales@alumnos.com', 'joaquin.morales', '1234', 4, 0);

INSERT INTO Curso (nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, idProfesor, turno, cantidadParciales, notaAprobacion, notaPromocion)
VALUES
('Programación I', 30, '2026-08-10', '2026-12-05', 120000, '2026-07-01', '2026-07-31', 100000, 1, 'Mañana', 2, 4, 7),
('Base de Datos', 25, '2026-08-10', '2026-12-05', 130000, '2026-07-01', '2026-07-31', 110000, 1, 'Noche', 2, 4, 7),
('Matemática Discreta', 35, '2026-08-10', '2026-12-05', 110000, '2026-07-01', '2026-07-31', 95000, 2, 'Tarde', 3, 4, 7),
('Algoritmos', 40, '2026-08-10', '2026-12-05', 140000, '2026-07-01', '2026-07-31', 120000, 3, 'Mañana', 2, 4, 7),
('Ingeniería de Software', 30, '2026-08-10', '2026-12-05', 150000, '2026-07-01', '2026-07-31', 130000, 3, 'Noche', 2, 4, 7);

INSERT INTO Inscripcion (alumnoId, cursoId, notaFinal, finalizada)
VALUES
(1, 1, NULL, FALSE),
(1, 3, NULL, FALSE),
(2, 1, NULL, FALSE),
(2, 2, NULL, FALSE),
(3, 2, NULL, FALSE),
(3, 4, NULL, FALSE),
(4, 5, NULL, FALSE),
(5, 3, NULL, FALSE),
(5, 4, NULL, FALSE),
(6, 1, NULL, FALSE),
(6, 5, NULL, FALSE);
