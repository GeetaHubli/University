USE university_test;

set FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE students;
TRUNCATE TABLE klasses;
TRUNCATE TABLE teachers;
set FOREIGN_KEY_CHECKS = 1;

INSERT INTO `students` (`email`)
VALUES
  ('test1@gmail.com'),
  ('test2@gmail.com'),
  ('test3@gmail.com');

INSERT INTO `teachers` (`name` ,`age`,`gender`)
VALUES
  ('teacher1' , 20, 'M'),
  ('teacher2' , 45, 'F'),
  ('teacher3' , 28, 'F');

INSERT INTO `klasses` (`name`,`semester`,`credits`,`department`,`fee`, `teacher_id`)
VALUES
  ('test1', SYSDATE(), 1, 'SCIENCE', 20, 1),
  ('test2', SYSDATE(), 2, 'ENGINEERING', 30, 2),
  ('test3', SYSDATE(), 3, 'PHILOSOPHY', 40, 2);


