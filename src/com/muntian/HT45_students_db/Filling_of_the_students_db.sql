USE students_db;


INSERT INTO passports (first_name, last_name) 
VALUES ('Igor', 'Golovko'), ('Valeryi', 'Zaginaiko'), ('Vasilyi', 'Topornikov'),
('Vladislav', 'Brovko'), ('Vasgen', 'Aganyesian'), ('Valentin', 'Ignatenko'),
('Aleksei', 'Dubin'), ('Petr', 'Luchko'), ('Maria', 'Belaya'), ('Yulyia', 'Gorod`ko'),

('Denis', 'Shtern'), ('Jaedong', 'Lee'), ('Samir', 'Nilson'), ('David', 'Rot'),
('Fransua', 'Duram'), ('Jan', 'Degoni'), ('Lucy', 'Vertran'), ('Benjamin', 'van der Veen'),

('Anatoliy', 'Bevz'), ('Viacheslav', 'Vasylev'), ('Nikolai', 'Kostin'), ('Elena', 'Sheikina'), ('Anatoliy', 'Kiyko'),
('Gennadiy', 'Get`man'), ('Andrey', 'Afanasov'), ('Sergey', 'Arpul`'), ('Uriy', 'Mikhailenko'), ('Nikolai', 'Visin');

    -- Filling of the students
-- Graduated students
INSERT INTO students (id_passport, edmission_date, graduation_date)
VALUES (1, '2006-09-01', '2011-07-20'), (2, '2006-09-01', '2011-07-20');

-- Current students
INSERT INTO students (id_passport, edmission_date)
VALUES (3, '2015-09-01'), (4, '2015-09-01'), (5, '2017-09-01'), (6, '2017-09-01'), (7, '2014-09-01'), (8, '2014-09-01'),
(9, '2014-09-01'), (10, '2014-09-01'),

-- Foreign students
(11, '2016-09-01'), (12, '2016-09-01'), (13, '2016-09-01'), (14, '2016-09-01'), (15, '2016-09-01'), (16, '2016-09-01'),
(17, '2017-09-01'), (18, '2017-09-01');


-- Filling of the forms
INSERT INTO forms (name) 
VALUES ('Full-time'), ('Distance');

-- Filling of the groups
INSERT INTO groups (name, id_form) 
VALUES ('252', 1), ('211', 1), ('212', 1), ('214', 1), ('211F', 1), ('211D', 2), ('217D');

-- Filling of the student_group
INSERT INTO student_group (id_student, id_group) 
VALUES (1, 1), (2, 1), (3, 2), (4, 2), (5, 3), (6, 3); 

-- Filling of the teachers
INSERT INTO teachers (id_passport) 
VALUES (7), (8);

-- Filling of the subjects
INSERT INTO subjects (name) 
VALUES ('Electrical transport'), ('Theoretical fundamentals of electrical engineering'),
 ('Higher mathimatics'), ('Electric drive'), ('Electronics');

-- Filling of the subject_teacher
INSERT INTO subject_teacher (id_subject, id_teacher) 
VALUES (1, 1), (2, 1), (3, 2), (4, 1), (5, 2), (5, 1);

-- Filling of the marks
INSERT INTO marks (id_student, id_group, id_subject, mark, date, id_teacher) 
VALUES (1, 1, 1, 90, '2006-01-12', 1), (1, 1, 2, 80, '2006-01-14', 1), (1, 1, 3, 77, '2006-01-21', 2), 
(2, 1, 1, 84, '2006-01-12', 1), (2, 1, 2, 82, '2006-01-14', 1), (2, 1, 3, 88, '2006-01-26', 2), 
(3, 2, 4, 60, '2015-01-20', 1), (3, 2, 5, 85, '2015-01-15', 2), 
(4, 2, 4, 78, '2015-01-20', 1), (4, 2, 5, 72, '2015-01-15', 2);

INSERT INTO marks (id_student, id_group, id_subject, id_teacher) 
VALUES (5, 3, 1, 1), (5, 3, 3, 2), (6, 3, 1, 1), (6, 3, 3, 2);