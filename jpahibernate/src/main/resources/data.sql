insert into course(id,name) values(10001,'Jpa And Hibernate');
insert into course(id,name) values(10002,'SpringBoot');
insert into course(id,name) values(10003,'Spring');

insert into passport(id,number) values(40001,'E123416');
insert into passport(id,number) values(40002,'E123456');
insert into passport(id,number) values(40003,'E342657');

insert into student(id,name,passport_id) values(20001,'Ranga',40001);
insert into student(id,name,passport_id) values(20002,'Adam',40002);
insert into student(id,name,passport_id) values(20003,'Jane',40003);

insert into review(id,rating,description,course_id) values(50001,'5','Great Course',10001);
insert into review(id,rating,description,course_id) values(50002,'4','Wonderful Course',10001);
insert into review(id,rating,description,course_id) values(50003,'5','Awesome Course',10003);

insert into student_course(student_id,course_id) values(20001,10001);
insert into student_course(student_id,course_id) values(20002,10001);
insert into student_course(student_id,course_id) values(20003,10001);
insert into student_course(student_id,course_id) values(20001,10003);


