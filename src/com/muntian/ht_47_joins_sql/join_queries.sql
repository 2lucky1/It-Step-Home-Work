USE students_db;

-- List of all teachers (name, last_name, id)
SELECT passports.first_name, passports.last_name, passports.id
FROM passports
INNER JOIN teachers
ON passports.id = teachers.id_passport;

-- List of teachers which teaching "Electronics"
SELECT passports.first_name, passports.last_name, passports.id FROM passports
INNER JOIN teachers
ON passports.id = teachers.id_passport
INNER JOIN subject_teacher
ON teachers.id = subject_teacher.id_teacher
INNER JOIN subjects
ON subject_teacher.id_subject = subjects.id
WHERE subjects.name = 'Electronics';

-- List of students of the full-day form of education
SELECT passports.first_name, passports.last_name, passports.id FROM passports
INNER JOIN students
ON passports.id = students.id_passport
INNER JOIN student_group
ON students.id = student_group.id_student
INNER JOIN groups
ON student_group.id_group = groups.id
INNER JOIN forms
ON groups.id_form = forms.id
WHERE forms.name = 'Full-time';

-- List of students of the distance form of education
SELECT passports.first_name, passports.last_name, passports.id FROM passports
INNER JOIN students
ON passports.id = students.id_passport
INNER JOIN student_group
ON students.id = student_group.id_student
INNER JOIN groups
ON student_group.id_group = groups.id
INNER JOIN forms
ON groups.id_form = forms.id
WHERE forms.name = 'Distance';

-- List of students which have marks below 60 points
SELECT DISTINCT passports.first_name, passports.last_name, passports.id FROM passports
INNER JOIN students
ON passports.id = students.id_passport
INNER JOIN marks
ON marks.id_student = students.id
WHERE marks.mark < 60;
