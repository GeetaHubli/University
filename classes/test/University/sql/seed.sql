USE university_test;

TRUNCATE TABLE students;
TRUNCATE TABLE klasses;
TRUNCATE TABLE teachers;

INSERT INTO `students` (`email`)
VALUES
  ('test1@gmail.com'),
  ('test2@gmail.com'),
  ('test3@gmail.com');

INSERT INTO `klasses` (`name`,`semester`,`credits`,`department`,`fee`)
VALUES
  ('test1', SYSDATE(), 1, 'SCIENCE', 20),
  ('test2', SYSDATE(), 2, 'ENGINEERING', 30),
  ('test3', SYSDATE(), 3, 'PHILOSOPHY', 40);

INSERT INTO `teachers` (`name` ,`age`,`gender`)
VALUES
  ('teacher1' , 20, 'M'),
  ('teacher2' , 45, 'F'),
  ('teacher3' , 28, 'F');
