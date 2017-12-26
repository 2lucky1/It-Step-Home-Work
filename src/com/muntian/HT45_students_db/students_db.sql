DROP DATABASE IF EXISTS students_db;
CREATE DATABASE students_db;
USE students_db;

CREATE TABLE passports(
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE students(
    id INT NOT NULL AUTO_INCREMENT,
    id_passport INT NOT NULL,
    edmission_date DATE,
    graduation_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_passport) REFERENCES passports (id)
);

CREATE TABLE forms(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(32),
    PRIMARY KEY (id)
);

CREATE TABLE groups(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(16),
    id_form INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_form) REFERENCES forms (id)    
);

CREATE TABLE student_group(
    id_student INT,
    id_group INT,
    FOREIGN KEY (id_student) REFERENCES students (id),
    FOREIGN KEY (id_group) REFERENCES groups (id)    
);

CREATE TABLE teachers(
    id INT NOT NULL AUTO_INCREMENT,
    id_passport INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_passport) REFERENCES passports (id)    
);

CREATE TABLE subjects(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE subject_teacher(
    id_subject INT,
    id_teacher INT,
    FOREIGN KEY (id_subject) REFERENCES subjects (id),
    FOREIGN KEY (id_teacher) REFERENCES teachers (id)    
);

CREATE TABLE marks(
    id INT NOT NULL AUTO_INCREMENT,
    id_student INT NOT NULL,
    id_group INT NOT NULL,
    id_subject INT NOT NULL,
    mark INT(4),
    date DATE,
    id_teacher INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_student) REFERENCES students (id),
    FOREIGN KEY (id_group) REFERENCES groups (id), 
    FOREIGN KEY (id_subject) REFERENCES subjects (id), 
    FOREIGN KEY (id_teacher) REFERENCES teachers (id)
);