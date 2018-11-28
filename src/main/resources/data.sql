DROP TABLE EMPLOYEE;

CREATE TABLE EMPLOYEE (
  I_ID INTEGER PRIMARY KEY,
  S_Login VARCHAR(255),
  S_Name VARCHAR(255),
  I_Age INTEGER,
  S_Role VARCHAR(255),
);

INSERT INTO EMPLOYEE(I_ID, S_Login, S_Name, I_Age,S_Role) VALUES(4,'Andry','Andrey',28,'admin');
INSERT INTO EMPLOYEE(I_ID, S_Login, S_Name, I_Age,S_Role) VALUES(5,'Petr','Petya',29,'web disainer');
INSERT INTO EMPLOYEE(I_ID, S_Login, S_Name, I_Age,S_Role) VALUES(6,'Serzh','Sergey',58,'Driver');
INSERT INTO EMPLOYEE(I_ID, S_Login, S_Name, I_Age,S_Role) VALUES(7,'Boss','BossBoss',32,'boss');