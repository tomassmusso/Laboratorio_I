INSERT INTO Administrador (nombre, apellido, mail, usuario, contraseña, sector) VALUES
('Juan', 'Perez', 'juan.perez@mail.com', 'juan.perez', '1234', 'Academico'),
('Maria', 'Gomez', 'maria.gomez@mail.com', 'maria.gomez', '1234', 'Gestion'),
('Lucas', 'Fernandez', 'lucas.fernandez@mail.com', 'lucas.fernandez', '1234', 'Sistemas');

INSERT INTO Profesor (nombre, apellido, mail, usuario, contraseña, departamento) VALUES
('Carlos', 'Lopez', 'carlos.lopez@mail.com', 'carlos.lopez', '1234', 'Informatica'),
('Ana', 'Martinez', 'ana.martinez@mail.com', 'ana.martinez', '1234', 'Matematica'),
('Diego', 'Ruiz', 'diego.ruiz@mail.com', 'diego.ruiz', '1234', 'Fisica'),
('Sofia', 'Diaz', 'sofia.diaz@mail.com', 'sofia.diaz', '1234', 'Datos'),
('Martin', 'Sosa', 'martin.sosa@mail.com', 'martin.sosa', '1234', 'Software');

INSERT INTO Alumno (nombre, apellido, mail, usuario, contraseña, limiteCursos, deuda) VALUES
('Tomas', 'Musso', 'tomas.musso@mail.com', 'tomas.musso', '1234', 3, 0),
('Valentina', 'Rossi', 'valentina.rossi@mail.com', 'valentina.rossi', '1234', 2, 0),
('Bruno', 'Alvarez', 'bruno.alvarez@mail.com', 'bruno.alvarez', '1234', 4, 0),
('Camila', 'Vega', 'camila.vega@mail.com', 'camila.vega', '1234', 2, 0),
('Nicolas', 'Herrera', 'nicolas.herrera', 'nicolas.herrera', '1234', 3, 0);

INSERT INTO Curso (
nombre, cupo, fechaInicio, fechaFin,
precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento,
idProfesor, turno, cantidadParciales, notaAprobacion, notaPromocion
) VALUES
('Java Inicial', 30, '2026-01-10', '2026-03-10', 50000, '2026-01-10', '2026-01-20', 40000, 1, 'Mañana', 2, 6.0, 8.5),
('Python Data Science', 25, '2026-02-01', '2026-04-01', 60000, '2026-02-01', '2026-02-10', 50000, 4, 'Tarde', 3, 6.5, 8.0),
('Bases de Datos', 20, '2026-03-01', '2026-05-01', 45000, '2026-03-01', '2026-03-10', 40000, 2, 'Noche', 2, 6.0, 7.5),
('Fisica I', 40, '2026-01-15', '2026-03-15', 30000, '2026-01-15', '2026-01-25', 25000, 3, 'Mañana', 2, 6.0, 7.0),
('Algoritmos Avanzados', 15, '2026-04-01', '2026-06-01', 70000, '2026-04-01', '2026-04-10', 65000, 5, 'Tarde', 3, 7.0, 9.0);
