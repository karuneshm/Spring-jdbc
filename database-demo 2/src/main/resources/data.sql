create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);

INSERT INTO PERSON (ID,NAME,LOCATION,birth_date)
VALUES(10001,'Karunesh','Bangalore',sysdate());
INSERT INTO PERSON (ID,NAME,LOCATION,birth_date)
VALUES(10002,'James','NY',sysdate());
INSERT INTO PERSON (ID,NAME,LOCATION,birth_date)
VALUES(10003,'Peter','Sydney',sysdate());
INSERT INTO PERSON (ID,NAME,LOCATION,birth_date)
VALUES(10004,'Julie','Bangalore',sysdate());