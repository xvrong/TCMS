/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/7/11 14:06:50                           */
/*==============================================================*/

DROP TABLE IF EXISTS allyear;

DROP TABLE IF EXISTS Manager;

DROP TABLE IF EXISTS taking;

DROP TABLE IF EXISTS class;

DROP TABLE IF EXISTS course;

DROP TABLE IF EXISTS student;

DROP TABLE IF EXISTS teacher;

/*==============================================================*/
/* Table: allyear                                               */
/*==============================================================*/
CREATE TABLE allyear
(
	 yearID               INT NOT NULL,
	 PRIMARY KEY (yearId)
);


/*==============================================================*/
/* Table: taking                                                */
/*==============================================================*/
CREATE TABLE taking
(
	 takingID              INT NOT NULL AUTO_INCREMENT,
   classID              INT NOT NULL,
   studentID            INT NOT NULL,
   state                BOOL NOT NULL DEFAULT TRUE,
   PRIMARY KEY (takingID)
);

/*==============================================================*/
/* Table: Manager                                               */
/*==============================================================*/
CREATE TABLE Manager
(
   managerID            VARCHAR(36) NOT NULL,
   PASSWORD             VARCHAR(36) NOT NULL,
   PRIMARY KEY (managerID)
);

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
CREATE TABLE class
(
   classID              INT NOT NULL AUTO_INCREMENT,
   courseID             INT NOT NULL,
   teacherID            INT NOT NULL,
   studentnum           INT NOT NULL DEFAULT 0,
   education            INT NOT NULL,
   grade                INT NOT NULL,
   start_year           INT NOT NULL,
   state                BOOL NOT NULL DEFAULT TRUE,
   order_number         INT NOT NULL,
   maxstudentnum        INT NOT NULL DEFAULT 30,
   PRIMARY KEY (classID)
);

ALTER TABLE class COMMENT 'class';

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
CREATE TABLE course
(
   courseID             INT NOT NULL AUTO_INCREMENT,
   coursename           VARCHAR(36) NOT NULL,
   education            INT NOT NULL,
   price                NUMERIC(9,2) NOT NULL,
   state                BOOL NOT NULL DEFAULT TRUE,
   PRIMARY KEY (courseID)
);

ALTER TABLE course COMMENT 'course';

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
CREATE TABLE student
(
   studentID            INT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(36) NOT NULL,
   education            INT NOT NULL,
   birthday             DATE,
   sex                  VARCHAR(36),
   state                BOOL NOT NULL DEFAULT TRUE,
   PASSWORD             VARCHAR(36) NOT NULL,
   PRIMARY KEY (studentID)
);

/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
CREATE TABLE teacher
(
   teacherID            INT NOT NULL AUTO_INCREMENT,
   NAME                 VARCHAR(36) NOT NULL,
   salary               NUMERIC(11,2) NOT NULL,
   state                BOOL NOT NULL DEFAULT TRUE,
   sex                  VARCHAR(36),
   birthday             DATE,
   PASSWORD             VARCHAR(36) NOT NULL,
   PRIMARY KEY (teacherID)
);

ALTER TABLE class ADD CONSTRAINT FK_open_course FOREIGN KEY (courseID)
      REFERENCES course (courseID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE class ADD CONSTRAINT FK_teacher FOREIGN KEY (teacherID)
      REFERENCES teacher (teacherID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE taking ADD CONSTRAINT FK_taking_class FOREIGN KEY (classID)
      REFERENCES class (classID) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE taking ADD CONSTRAINT FK_taking_student FOREIGN KEY (studentID)
      REFERENCES student (studentID) ON DELETE RESTRICT ON UPDATE RESTRICT;
      
      
      
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲一',0,'2014-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲二',0,'2015-9-2','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲三',1,'2008-8-27','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲四',0,'2012-10-7','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲五',0,'2012-3-23','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲六',2,'2005-1-18','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲容升',0,'2016-5-12','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲容升永远滴神',2,'2000-4-5','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲七',2,'2006-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲八',0,'2013-2-21','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲九',0,'2013-11-20','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十',1,'2009-8-7','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十一',1,'2008-12-1','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十二',0,'2017-3-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十三',2,'1999-8-7','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十四',2,'1998-11-2','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十五',0,'2016-6-7','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十六',0,'2011-3-4','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十七',0,'2008-8-9','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十八',2,'2014-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲十九',1,'2008-8-7','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲二十',1,'2009-6-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲二一',1,'2009-10-22','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲二二',1,'2009-9-3','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲二蛋',1,'2009-2-13','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲二三',1,'2008-12-1','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲二四',1,'2008-1-7','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲语文',2,'2005-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲数学',2,'2003-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲英语',2,'2005-1-7','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲物理',2,'2005-6-22','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲化学',2,'2003-1-13','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲生物',2,'2000-10-27','女',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲政治',0,'2009-1-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲历史',0,'2011-9-27','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲地理',0,'2013-12-30','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升哥哥',0,'2010-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升一',0,'2011-4-2','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升二',0,'2010-5-27','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升三',0,'2010-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升四',0,'2010-8-7','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升四',0,'2010-12-6','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升五',0,'2010-3-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲一',0,'2011-6-23','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲一',0,'2012-8-7','男',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'曲八',0,'2009-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升六',0,'2008-2-17','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升七',2,'2001-8-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升八',0,'2015-4-7','女',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'升九',0,'2013-9-7','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'初中生',1,'2006-1-27','男',1,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'毕业生代表',2,'1997-12-13','女',0,'123456');
      INSERT INTO student (studentID,NAME,education,birthday,sex,state,PASSWORD) VALUES (0,'大滑稽',2,'1994-6-27','男',0,'123456');
      
      
      
      
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'思维培养',0,1200,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'舞蹈',0,12000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'跆拳道',0,8000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'钢琴',0,20000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'美术',0,5000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'语文',0,4300,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'数学',0,4300,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'英语',0,4000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'语文',1,8000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'数学',1,8000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'英语',1,8000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'政治',1,6000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'历史',1,6000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'地理',1,5500,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'生物',1,5500,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'物理',1,7000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'化学',1,4000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'语文',2,20000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'数学',2,20000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'英语',2,20000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'物理',2,180000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'化学',2,180000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'生物',2,160000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'政治',2,140000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'历史',2,140000,1);
      INSERT INTO course (courseID,coursename,education,price,state) VALUES (0,'地理',2,140000,1);
      
      
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (1,"胡晓峰",4000,1,"男",'1970-12-31',"19700112hxf");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (2,"刘静",5100.74,1,"女",'1982-05-04',"19820504Liu");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (3,"李丽",4752.37,1,"女",'1988-09-04',"LL19880904");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (4,"何继军", 3765,0,"男",'1985-09-04',"123456hjj ");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (5,"李明",5300.15,0,"男",'1989-10-01',"!Lm19891001");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (6,"徐飞",4800,0,"男",'1979-06-15',"0615aaa");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (7,"孙平",3990,0,"男",'1990-09-29',"900929");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (8,"张红",4125.30,0,"女",'1987-11-07',"zhanghong1107");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (9,"姚小琴",5775.62,0,"女",'1980-08-17',"Xqin19080801");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (10,"王洋",6520.71,1,"男",'1991-03-11',"88888888wy");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (11,"姜玉梅",6200.15,0,"女",'1974-04-29',"740429Jym ");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (12,"谢静",5635,0,"女",'1984-07-27',"19840727x");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (13," 刘静",4900,1,"女",'1977-02-18',"19770218lj");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (14,"宋涛",4996.3,0,"男",'1979-03-20'," 19790320St");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (15,"马志宇",5000.35,0,"男",'1983-10-10',"Mzyu831010");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (16,"王玉迪辰",5329.76,0,"男",'1987-04-25',"wwdc123456");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (17,"梁敏",4010.23,1,"女",'1981-12-15',"19811215lm");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (18,"张旭刚",5200,0,"男",'1972-05-25',"54321zxg");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (19,"马龙",4620,0,"男",'1992-02-22',"19920222ml.");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (20,"王生栋 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (22,"王二 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (23,"王三 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (24,"王四 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (25,"王五 ",3500,1,"女",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (26,"王六 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (27,"王七 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (28,"王八 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (29,"王九 ",3500,1,"女",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (30,"王十 ",3500,1,"男",' 1975-01-02',"19750102w");
      INSERT INTO teacher(teacherID,NAME,salary,state,sex,birthday, PASSWORD) VALUES (21,"曲容升永远滴神 ",3500000,1,"男",' 1975-01-02',"19750102w");
      
      
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(1,1,4,0,0,6,2005,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(2,2,7,0,0,6,2005,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(3,1,4,0,0,6,2006,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(4,5,11,0,0,6,2006,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(5,3,12,0,0,6,2007,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(6,5,11,0,0,6,2007,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(7,6,4,0,0,6,2008,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(8,7,5,0,0,6,2008,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(9,6,19,0,0,6,2009,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(10,7,5,0,0,6,2009,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(11,4,20,0,0,6,2010,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(12,8,6,0,0,6,2010,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(13,1,4,0,0,6,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(14,2,3,0,0,6,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(15,3,12,0,0,6,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(16,4,20,0,0,6,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(17,5,3,0,0,6,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(18,9,14,0,1,3,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(19,10,15,0,1,3,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(20,11,6,0,1,3,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(21,14,1,0,1,3,2011,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(22,15,2,0,1,3,2011,0,1,30);
       
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(23,1,4,0,0,6,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(24,2,3,0,0,6,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(25,3,12,0,0,6,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(26,4,20,0,0,6,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(27,5,3,0,0,6,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(28,9,14,0,1,3,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(29,10,15,0,1,3,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(30,11,6,0,1,3,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(31,14,1,0,1,3,2012,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(32,15,2,0,1,3,2012,0,1,30);
      
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(33,6,21,0,0,6,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(34,7,22,0,0,6,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(35,8,23,0,0,6,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(36,4,24,0,0,6,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(37,5,25,0,0,6,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(38,9,26,0,1,3,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(39,10,27,0,1,3,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(40,11,28,0,1,3,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(41,16,29,0,1,3,2013,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(42,17,30,0,1,3,2013,0,1,30);
       
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(43,6,21,0,0,6,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(44,7,22,0,0,6,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(45,8,23,0,0,6,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(46,2,14,0,0,6,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(47,3,15,0,0,6,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(48,12,5,0,1,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(49,13,6,0,1,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(50,14,7,0,1,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(51,16,29,0,1,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(52,17,30,0,1,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(53,18,9,0,2,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(54,19,10,0,2,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(55,20,11,0,2,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(56,24,12,0,2,3,2014,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(57,25,8,0,2,3,2014,0,1,30);
       
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(58,6,1,0,0,6,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(59,7,2,0,0,6,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(60,8,3,0,0,6,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(61,2,10,0,0,6,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(62,3,13,0,0,6,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(63,12,5,0,1,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(64,13,6,0,1,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(65,14,7,0,1,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(66,10,18,0,1,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(67,15,19,0,1,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(68,18,9,0,2,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(69,19,10,0,2,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(70,20,11,0,2,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(71,24,12,0,2,3,2015,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(72,25,8,0,2,3,2015,0,1,30);
       
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(73,1,10,0,0,6,2016,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(74,2,13,0,0,6,2016,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(75,3,17,0,0,6,2016,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(76,4,20,0,0,6,2016,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(77,5,21,0,0,6,2016,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(78,12,5,0,1,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(79,13,6,0,1,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(80,14,7,0,1,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(81,10,18,0,1,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(82,15,19,0,1,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(83,21,30,0,2,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(84,19,10,0,2,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(85,22,16,0,2,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(86,23,15,0,2,3,2016,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(87,26,14,0,2,3,2016,0,1,30);
       
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(88,1,10,0,0,5,2017,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(89,2,13,0,0,5,2017,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(90,3,17,0,0,5,2017,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(91,4,20,0,0,5,2017,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(92,5,21,0,0,5,2017,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(93,12,5,0,1,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(94,13,6,0,1,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(95,14,7,0,1,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(96,10,18,0,1,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(97,15,19,0,1,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(98,21,30,0,2,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(99,19,27,0,2,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(100,22,16,0,2,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(101,23,15,0,2,3,2017,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(102,26,14,0,2,3,2017,0,1,30);
       
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(103,1,10,0,0,4,2018,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(104,6,1,0,0,4,2018,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(105,7,2,0,0,4,2018,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(106,8,3,0,0,4,2018,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(107,5,21,0,0,4,2018,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(108,17,30,0,1,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(109,16,29,0,1,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(110,9,28,0,1,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(111,10,27,0,1,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(112,11,26,0,1,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(113,21,30,0,2,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(114,24,8,0,2,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(115,22,16,0,2,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(116,23,15,0,2,3,2018,0,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(117,25,9,0,2,3,2018,0,1,30);
       
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(118,1,10,0,0,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(119,6,1,0,0,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(120,7,2,0,0,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(121,8,3,0,0,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(122,5,20,0,0,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(123,9,30,0,1,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(124,10,29,0,1,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(125,11,28,0,1,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(126,12,27,0,1,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(127,13,26,0,1,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(128,18,25,0,2,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(129,19,24,0,2,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(130,20,23,0,2,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(131,21,22,0,2,3,2019,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(132,22,21,0,2,3,2019,1,1,30);
      
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(133,1,10,0,0,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(134,2,1,0,0,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(135,3,2,0,0,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(136,4,3,0,0,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(137,5,20,0,0,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(138,14,30,0,1,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(139,15,29,0,1,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(140,16,28,0,1,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(141,17,27,0,1,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(142,13,26,0,1,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(143,23,25,0,2,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(144,24,24,0,2,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(145,25,23,0,2,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(146,26,22,0,2,2,2020,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(147,22,21,0,2,2,2020,1,1,30);
        
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(148,1,21,0,0,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(149,2,1,0,0,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(150,3,2,0,0,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(151,4,3,0,0,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(152,5,20,0,0,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(153,14,30,0,1,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(154,15,29,0,1,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(155,16,28,0,1,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(156,17,27,0,1,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(157,13,26,0,1,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(158,23,25,0,2,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(159,24,24,0,2,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(160,25,10,0,2,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(161,26,13,0,2,1,2021,1,1,30);
      INSERT INTO class(classID,courseID,teacherID,studentnum,education,grade,start_year,state,order_number,maxstudentnum)VALUES(162,22,17,0,2,1,2021,1,1,30);
        
    
      
      
      
      INSERT INTO taking (classID,studentID,state) VALUES (103,1,1);
      INSERT INTO taking (classID,studentID,state) VALUES (104,1,1);
      INSERT INTO taking (classID,studentID,state) VALUES (105,1,1);
      INSERT INTO taking (classID,studentID,state) VALUES (88,2,1);
      INSERT INTO taking (classID,studentID,state) VALUES (139,3,1);
      INSERT INTO taking (classID,studentID,state) VALUES (140,3,1);
      INSERT INTO taking (classID,studentID,state) VALUES (44,3,0);
      INSERT INTO taking (classID,studentID,state) VALUES (47,3,0);
      INSERT INTO taking (classID,studentID,state) VALUES (73,4,1);
      INSERT INTO taking (classID,studentID,state) VALUES (74,4,1);
      INSERT INTO taking (classID,studentID,state) VALUES (75,4,1);
      INSERT INTO taking (classID,studentID,state) VALUES (76,4,1);
      INSERT INTO taking (classID,studentID,state) VALUES (77,4,1);
      INSERT INTO taking (classID,studentID,state) VALUES (76,5,1);
      INSERT INTO taking (classID,studentID,state) VALUES (77,5,1);
      INSERT INTO taking (classID,studentID,state) VALUES (128,6,1);
      INSERT INTO taking (classID,studentID,state) VALUES (129,6,1);
      INSERT INTO taking (classID,studentID,state) VALUES (11,6,0);
      INSERT INTO taking (classID,studentID,state) VALUES (73,7,1);
      INSERT INTO taking (classID,studentID,state) VALUES (74,7,1);
      INSERT INTO taking (classID,studentID,state) VALUES (75,7,1);
      INSERT INTO taking (classID,studentID,state) VALUES (83,8,0);
      INSERT INTO taking (classID,studentID,state) VALUES (38,8,0);
      INSERT INTO taking (classID,studentID,state) VALUES (39,8,0);
      INSERT INTO taking (classID,studentID,state) VALUES (40,8,0);
      INSERT INTO taking (classID,studentID,state) VALUES (5,8,0);
      INSERT INTO taking (classID,studentID,state) VALUES (128,9,1);
      INSERT INTO taking (classID,studentID,state) VALUES (76,10,1);
      INSERT INTO taking (classID,studentID,state) VALUES (77,10,1);
      INSERT INTO taking (classID,studentID,state) VALUES (74,11,1);
      INSERT INTO taking (classID,studentID,state) VALUES (75,11,1);
      INSERT INTO taking (classID,studentID,state) VALUES (76,11,1);
      INSERT INTO taking (classID,studentID,state) VALUES (77,11,1);
      INSERT INTO taking (classID,studentID,state) VALUES (48,12,0);
      INSERT INTO taking (classID,studentID,state) VALUES (49,12,0);
      INSERT INTO taking (classID,studentID,state) VALUES (140,12,0);
      INSERT INTO taking (classID,studentID,state) VALUES (48,13,0);
      INSERT INTO taking (classID,studentID,state) VALUES (49,13,0);
      INSERT INTO taking (classID,studentID,state) VALUES (50,13,0);
      INSERT INTO taking (classID,studentID,state) VALUES (51,13,0);
      INSERT INTO taking (classID,studentID,state) VALUES (52,13,0);
      INSERT INTO taking (classID,studentID,state) VALUES (148,14,1);
      INSERT INTO taking (classID,studentID,state) VALUES (149,14,1);
      INSERT INTO taking (classID,studentID,state) VALUES (98,15,0);
      INSERT INTO taking (classID,studentID,state) VALUES (8,15,0);
      INSERT INTO taking (classID,studentID,state) VALUES (162,16,0);
      INSERT INTO taking (classID,studentID,state) VALUES (161,16,0);
      INSERT INTO taking (classID,studentID,state) VALUES (109,16,0);
      INSERT INTO taking (classID,studentID,state) VALUES (110,16,0);
      INSERT INTO taking (classID,studentID,state) VALUES (111,16,0);
      INSERT INTO taking (classID,studentID,state) VALUES (112,16,0);
      INSERT INTO taking (classID,studentID,state) VALUES (27,16,0);
      INSERT INTO taking (classID,studentID,state) VALUES (148,17,1);
      INSERT INTO taking (classID,studentID,state) VALUES (149,17,1);
      INSERT INTO taking (classID,studentID,state) VALUES (150,17,1);
      INSERT INTO taking (classID,studentID,state) VALUES (151,17,1);
      INSERT INTO taking (classID,studentID,state) VALUES (152,17,1);
      INSERT INTO taking (classID,studentID,state) VALUES (151,18,0);
      INSERT INTO taking (classID,studentID,state) VALUES (151,19,0);
      INSERT INTO taking (classID,studentID,state) VALUES (148,19,0);
      INSERT INTO taking (classID,studentID,state) VALUES (149,19,0);
      INSERT INTO taking (classID,studentID,state) VALUES (161,20,1);
      INSERT INTO taking (classID,studentID,state) VALUES (162,20,1);
      INSERT INTO taking (classID,studentID,state) VALUES (149,20,1);
      INSERT INTO taking (classID,studentID,state) VALUES (95,20,0);
      INSERT INTO taking (classID,studentID,state) VALUES (153,21,1);
      INSERT INTO taking (classID,studentID,state) VALUES (154,21,1);
      INSERT INTO taking (classID,studentID,state) VALUES (155,21,1);
      INSERT INTO taking (classID,studentID,state) VALUES (156,21,1);
      INSERT INTO taking (classID,studentID,state) VALUES (157,21,1);
      INSERT INTO taking (classID,studentID,state) VALUES (58,21,0);
      INSERT INTO taking (classID,studentID,state) VALUES (59,21,0);
      INSERT INTO taking (classID,studentID,state) VALUES (60,21,0);
      INSERT INTO taking (classID,studentID,state) VALUES (61,21,0);
      INSERT INTO taking (classID,studentID,state) VALUES (62,21,0);
      INSERT INTO taking (classID,studentID,state) VALUES (153,22,1);
      INSERT INTO taking (classID,studentID,state) VALUES (154,22,1);
      INSERT INTO taking (classID,studentID,state) VALUES (155,22,1);
      INSERT INTO taking (classID,studentID,state) VALUES (156,22,1);
      INSERT INTO taking (classID,studentID,state) VALUES (157,22,1);
      INSERT INTO taking (classID,studentID,state) VALUES (58,22,0);
      INSERT INTO taking (classID,studentID,state) VALUES (59,22,0);
      INSERT INTO taking (classID,studentID,state) VALUES (60,22,0);
      INSERT INTO taking (classID,studentID,state) VALUES (61,22,0);
      INSERT INTO taking (classID,studentID,state) VALUES (62,22,0);
      INSERT INTO taking (classID,studentID,state) VALUES (153,23,1);
      INSERT INTO taking (classID,studentID,state) VALUES (154,23,1);
      INSERT INTO taking (classID,studentID,state) VALUES (155,23,1);
      INSERT INTO taking (classID,studentID,state) VALUES (156,23,1);
      INSERT INTO taking (classID,studentID,state) VALUES (157,23,1);
      INSERT INTO taking (classID,studentID,state) VALUES (43,23,0);
      INSERT INTO taking (classID,studentID,state) VALUES (44,23,0);
      INSERT INTO taking (classID,studentID,state) VALUES (45,23,0);
      INSERT INTO taking (classID,studentID,state) VALUES (46,23,0);
      INSERT INTO taking (classID,studentID,state) VALUES (47,23,0);
      INSERT INTO taking (classID,studentID,state) VALUES (153,24,1);
      INSERT INTO taking (classID,studentID,state) VALUES (154,24,1);
      INSERT INTO taking (classID,studentID,state) VALUES (62,24,0);
      INSERT INTO taking (classID,studentID,state) VALUES (155,25,1);
      INSERT INTO taking (classID,studentID,state) VALUES (156,25,1);
      INSERT INTO taking (classID,studentID,state) VALUES (157,25,1);
      INSERT INTO taking (classID,studentID,state) VALUES (62,25,0);
      INSERT INTO taking (classID,studentID,state) VALUES (138,26,1);
      INSERT INTO taking (classID,studentID,state) VALUES (139,26,1);
      INSERT INTO taking (classID,studentID,state) VALUES (140,26,1);
      INSERT INTO taking (classID,studentID,state) VALUES (141,26,1);
      INSERT INTO taking (classID,studentID,state) VALUES (142,26,1);
      INSERT INTO taking (classID,studentID,state) VALUES (127,27,1);
      INSERT INTO taking (classID,studentID,state) VALUES (34,27,0);
      INSERT INTO taking (classID,studentID,state) VALUES (143,28,1);
      INSERT INTO taking (classID,studentID,state) VALUES (144,28,1);
      INSERT INTO taking (classID,studentID,state) VALUES (145,28,1);
      INSERT INTO taking (classID,studentID,state) VALUES (146,28,1);
      INSERT INTO taking (classID,studentID,state) VALUES (147,28,1);
      INSERT INTO taking (classID,studentID,state) VALUES (143,29,1);
      INSERT INTO taking (classID,studentID,state) VALUES (144,29,1);
      INSERT INTO taking (classID,studentID,state) VALUES (145,29,1);
      INSERT INTO taking (classID,studentID,state) VALUES (146,29,1);
      INSERT INTO taking (classID,studentID,state) VALUES (147,29,1);
      INSERT INTO taking (classID,studentID,state) VALUES (93,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (94,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (95,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (146,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (13,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (14,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (15,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (16,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (17,29,0);
      INSERT INTO taking (classID,studentID,state) VALUES (160,30,1);
      INSERT INTO taking (classID,studentID,state) VALUES (158,31,1);
      INSERT INTO taking (classID,studentID,state) VALUES (159,31,1);
      INSERT INTO taking (classID,studentID,state) VALUES (160,31,1);
      INSERT INTO taking (classID,studentID,state) VALUES (108,31,0);
      INSERT INTO taking (classID,studentID,state) VALUES (109,31,0);
      INSERT INTO taking (classID,studentID,state) VALUES (112,31,0);
      INSERT INTO taking (classID,studentID,state) VALUES (158,32,1);
      INSERT INTO taking (classID,studentID,state) VALUES (159,32,1);
      INSERT INTO taking (classID,studentID,state) VALUES (160,32,1);
      INSERT INTO taking (classID,studentID,state) VALUES (161,32,1);
      INSERT INTO taking (classID,studentID,state) VALUES (162,32,1);
      INSERT INTO taking (classID,studentID,state) VALUES (108,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (109,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (110,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (111,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (112,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (23,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (24,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (25,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (26,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (27,32,0);
      INSERT INTO taking (classID,studentID,state) VALUES (158,33,0);
      INSERT INTO taking (classID,studentID,state) VALUES (26,33,0);
      INSERT INTO taking (classID,studentID,state) VALUES (27,33,0);
      INSERT INTO taking (classID,studentID,state) VALUES (73,34,1);
      INSERT INTO taking (classID,studentID,state) VALUES (88,35,1);
      INSERT INTO taking (classID,studentID,state) VALUES (89,35,1);
      INSERT INTO taking (classID,studentID,state) VALUES (90,35,1);
      INSERT INTO taking (classID,studentID,state) VALUES (91,35,1);
      INSERT INTO taking (classID,studentID,state) VALUES (92,35,1);
      INSERT INTO taking (classID,studentID,state) VALUES (105,36,1);
      INSERT INTO taking (classID,studentID,state) VALUES (106,36,1);
      INSERT INTO taking (classID,studentID,state) VALUES (119,37,1);
      INSERT INTO taking (classID,studentID,state) VALUES (136,38,1);
      INSERT INTO taking (classID,studentID,state) VALUES (137,38,1);
      INSERT INTO taking (classID,studentID,state) VALUES (148,39,1);
      INSERT INTO taking (classID,studentID,state) VALUES (73,40,1);
      INSERT INTO taking (classID,studentID,state) VALUES (74,40,1);
      INSERT INTO taking (classID,studentID,state) VALUES (75,40,1);
      INSERT INTO taking (classID,studentID,state) VALUES (76,40,1);
      INSERT INTO taking (classID,studentID,state) VALUES (77,40,1);
      INSERT INTO taking (classID,studentID,state) VALUES (77,41,1);
      INSERT INTO taking (classID,studentID,state) VALUES (152,42,1);
      INSERT INTO taking (classID,studentID,state) VALUES (122,43,1);
      INSERT INTO taking (classID,studentID,state) VALUES (134,44,1);
      INSERT INTO taking (classID,studentID,state) VALUES (118,45,0);
      INSERT INTO taking (classID,studentID,state) VALUES (119,45,0);
      INSERT INTO taking (classID,studentID,state) VALUES (120,45,0);
      INSERT INTO taking (classID,studentID,state) VALUES (121,45,0);
      INSERT INTO taking (classID,studentID,state) VALUES (120,46,1);
      INSERT INTO taking (classID,studentID,state) VALUES (121,46,1);
      INSERT INTO taking (classID,studentID,state) VALUES (120,47,1);
      INSERT INTO taking (classID,studentID,state) VALUES (121,47,1);
      INSERT INTO taking (classID,studentID,state) VALUES (118,47,1);
      INSERT INTO taking (classID,studentID,state) VALUES (145,48,1);
      INSERT INTO taking (classID,studentID,state) VALUES (146,48,1);
      INSERT INTO taking (classID,studentID,state) VALUES (147,48,1);
      INSERT INTO taking (classID,studentID,state) VALUES (93,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (94,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (95,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (96,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (97,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (23,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (25,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (27,48,0);
      INSERT INTO taking (classID,studentID,state) VALUES (74,49,1);
      INSERT INTO taking (classID,studentID,state) VALUES (75,49,1);
      INSERT INTO taking (classID,studentID,state) VALUES (120,50,1);
      INSERT INTO taking (classID,studentID,state) VALUES (123,51,1);
      INSERT INTO taking (classID,studentID,state) VALUES (125,51,1);
      INSERT INTO taking (classID,studentID,state) VALUES (33,51,0);
      INSERT INTO taking (classID,studentID,state) VALUES (34,51,0);
      INSERT INTO taking (classID,studentID,state) VALUES (35,51,0);
      INSERT INTO taking (classID,studentID,state) VALUES (36,51,0);
      INSERT INTO taking (classID,studentID,state) VALUES (37,51,0);
      INSERT INTO taking (classID,studentID,state) VALUES (1,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (2,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (18,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (19,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (20,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (21,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (22,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (53,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (54,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (55,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (56,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (57,52,0);
      INSERT INTO taking (classID,studentID,state) VALUES (158,53,0);
      INSERT INTO taking (classID,studentID,state) VALUES (159,53,0);
      INSERT INTO taking (classID,studentID,state) VALUES (160,53,0);
      INSERT INTO taking (classID,studentID,state) VALUES (161,53,0);
      INSERT INTO taking (classID,studentID,state) VALUES (162,53,0);
      
      UPDATE class SET studentnum=(SELECT COUNT(*) FROM taking WHERE taking.classID=class.classID);
      
      INSERT INTO Manager(managerID,PASSWORD) VALUES ('qrs','123456');
      
			INSERT INTO allyear(yearID) VALUES(2021);
