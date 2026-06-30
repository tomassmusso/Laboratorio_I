-- ===========================
-- ADMINISTRADORES
-- ===========================

INSERT INTO Administrador (nombre, apellido, mail, usuario, contraseña, sector) VALUES
('Juan', 'Pérez', 'juan.perez@campus.com', 'juan.perez', '1234', 'Académico'),
('María', 'Gómez', 'maria.gomez@campus.com', 'maria.gomez', '1234', 'Administración');



-- ===========================
-- PROFESORES
-- ===========================

INSERT INTO Profesor (nombre, apellido, mail, usuario, contraseña, departamento) VALUES
('Carlos', 'Fernández', 'cfernandez@campus.com', 'cfernandez', '1234', 'Programación'),
('Laura', 'Martínez', 'lmartinez@campus.com', 'lmartinez', '1234', 'Bases de Datos'),
('Diego', 'Sosa', 'dsosa@campus.com', 'dsosa', '1234', 'Matemática'),
('Ana', 'Ruiz', 'aruiz@campus.com', 'aruiz', '1234', 'Física'),
('Martín', 'López', 'mlopez@campus.com', 'mlopez', '1234', 'Inteligencia Artificial');



-- ===========================
-- ALUMNOS
-- ===========================

INSERT INTO Alumno (nombre, apellido, mail, usuario, contraseña, limiteCursos, deuda) VALUES
('Tomás', 'Musso', 'tomas@gmail.com', 'tmusso', '1234', 2, 0),
('Lucía', 'Benítez', 'lucia@gmail.com', 'lbenitez', '1234', 3, 0),
('Nicolás', 'Suárez', 'nico@gmail.com', 'nsuarez', '1234', 2, 0),
('Valentina', 'Rojas', 'vale@gmail.com', 'vrojas', '1234', 4, 0),
('Santiago', 'Díaz', 'santi@gmail.com', 'sdiaz', '1234', 3, 0),
('Camila', 'Moreno', 'camila@gmail.com', 'cmoreno', '1234', 2, 0),
('Franco', 'Alonso', 'franco@gmail.com', 'falonso', '1234', 3, 0),
('Milagros', 'Navarro', 'mili@gmail.com', 'mnavarro', '1234', 2, 0);



-- ===========================
-- CURSOS
-- ===========================

INSERT INTO Curso
(nombre, cupo, fechaInicio, fechaFin, precio, fechaInicioDescuento, fechaFinDescuento, precioDescuento, idProfesor, turno, cantidadParciales, notaAprobacion, notaPromocion)
VALUES
('Java Inicial',30,'2026-08-01','2026-11-01',60000,'2026-07-20','2026-07-31',50000,1,'Mañana',2,6,8),

('Programación Orientada a Objetos',25,'2026-08-03','2026-11-10',65000,'2026-07-20','2026-08-01',55000,1,'Tarde',2,6,8),

('Bases de Datos',20,'2026-08-10','2026-11-15',55000,'2026-07-25','2026-08-05',48000,2,'Noche',2,6,7),

('SQL Avanzado',20,'2026-09-01','2026-12-01',62000,'2026-08-20','2026-08-31',55000,2,'Mañana',2,6,8),

('Álgebra',35,'2026-08-01','2026-11-01',50000,'2026-07-20','2026-07-31',45000,3,'Tarde',2,6,8),

('Análisis Matemático',30,'2026-08-05','2026-11-20',55000,'2026-07-25','2026-08-05',50000,3,'Noche',2,6,8),

('Física I',40,'2026-08-01','2026-11-10',45000,'2026-07-20','2026-07-31',40000,4,'Mañana',2,6,7),

('Machine Learning',20,'2026-09-01','2026-12-15',90000,'2026-08-20','2026-08-31',80000,5,'Noche',3,7,9);



-- ===========================
-- INSCRIPCIONES
-- ===========================

INSERT INTO Inscripcion (alumnoId, cursoId, notaFinal, finalizada) VALUES
(1,1,NULL,FALSE),
(1,3,NULL,FALSE),

(2,1,NULL,FALSE),
(2,2,NULL,FALSE),
(2,8,NULL,FALSE),

(3,3,NULL,FALSE),
(3,5,NULL,FALSE),

(4,4,NULL,FALSE),
(4,7,NULL,FALSE),

(5,2,NULL,FALSE),
(5,6,NULL,FALSE),

(6,8,NULL,FALSE),

(7,1,NULL,FALSE),
(7,5,NULL,FALSE),

(8,3,NULL,FALSE);



-- ===========================
-- NOTAS PARCIALES
-- (vacío para cargar desde el programa)
-- ===========================
