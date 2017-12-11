USE students_db;

-- Number of teachers
SELECT COUNT(*) FROM teachers;

-- Number of students from 211F group
SELECT COUNT(*) FROM student_group
INNER JOIN groups
ON id_group = groups.id
WHERE groups.name = '211F';

-- Number of students of full-time form
SELECT COUNT(*) FROM passports
INNER JOIN students
ON passports.id = students.id_passport
INNER JOIN student_group
ON students.id = student_group.id_student
INNER JOIN groups
ON student_group.id_group = groups.id
INNER JOIN forms
ON groups.id_form = forms.id
WHERE forms.name = 'Full-time';

-- Average mark of students from 212 group
SELECT AVG (mark) FROM marks
INNER JOIN groups
ON marks.id_group = groups.id
WHERE groups.name = '212';

-- A form of education with highest number of students
SELECT name FROM forms
INNER JOIN groups
ON forms.id = groups.id
INNER JOIN student_group
ON 
