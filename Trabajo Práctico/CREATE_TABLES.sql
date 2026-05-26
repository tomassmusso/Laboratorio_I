CREATE TABLE Alumno (
    id INT PRIMARY KEY,
    nombre VARCHAR(25),
    apellido VARCHAR(25),
    mail VARCHAR(50),
    usuario VARCHAR(20),
    contraseña VARCHAR(20),
    limiteCursos INT,
    saldo DOUBLE
);

CREATE TABLE Profesor (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    mail VARCHAR(100),
    usuario VARCHAR(50),
    contraseña VARCHAR(50),
    departamento VARCHAR(50)
);

CREATE TABLE Administrador (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    mail VARCHAR(100),
    usuario VARCHAR(50),
    contraseña VARCHAR(50),
    sector VARCHAR(50)
);

CREATE TABLE Curso (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    cupo INT,
    precio DOUBLE,
    idProfesor INT,
    turno VARCHAR(50),
    cantidadParciales INT,
    parcialesAprobadosNecesarios INT,
    notaPromocion DOUBLE
);

CREATE TABLE Inscripcion (
    id INT PRIMARY KEY,
    alumnoId INT,
    cursoId INT,
    notaFinal DOUBLE
);

CREATE TABLE NotaParcial (
    id INT PRIMARY KEY,
    inscripcionId INT,
    nota DOUBLE
);
