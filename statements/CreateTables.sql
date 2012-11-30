/* Drop Triggers */

DROP TRIGGER TRI_ACTIVITYLOG_ID;
DROP TRIGGER TRI_ACTIVITYTYPE_ID;
DROP TRIGGER TRI_ATTRACTIONREVIEW_ID;
DROP TRIGGER TRI_ATTRACTIONTYPE_ID;
DROP TRIGGER TRI_ATTRACTIONVISITED_ID;
DROP TRIGGER TRI_ATTRACTION_ID;
DROP TRIGGER TRI_CITY_ID;
DROP TRIGGER TRI_COMMENTS_ID;
DROP TRIGGER TRI_COMPANY_ID;
DROP TRIGGER TRI_DISCOUNT_ID;
DROP TRIGGER TRI_DISCUSSIONTHREADCOMMENT_ID;
DROP TRIGGER TRI_DISCUSSIONTHREAD_ID;
DROP TRIGGER TRI_DISCUSSIONTOPIC_ID;
DROP TRIGGER TRI_LIKES_ID;
DROP TRIGGER TRI_MEMBERSHIP_TYPE_ID;
DROP TRIGGER TRI_PACKAGES_ID;
DROP TRIGGER TRI_ROLE_ID;
DROP TRIGGER TRI_TEAM_ID;
DROP TRIGGER TRI_TICKETSAVAILABLE_ID;
DROP TRIGGER TRI_TRANSACTIONATTRACTION_ID;
DROP TRIGGER TRI_TRANSACTIONINFO_ID;
DROP TRIGGER TRI_TRANSACTIONPACKAGE_ID;
DROP TRIGGER TRI_TRANSACTIONREWARD_ID;
DROP TRIGGER TRI_USERBASE_ID;
DROP TRIGGER TRI_USERPHONES_ID;



/* Drop Tables */

DROP TABLE ACTIVITYLOG;
DROP TABLE ACTIVITYTYPE;
DROP TABLE ATTRACTIONEMPLOYEE;
DROP TABLE ATTRACTIONMANAGEMENT;
DROP TABLE COMMENTS;
DROP TABLE ATTRACTIONREVIEW;
DROP TABLE ATTRACTIONVISITED;
DROP TABLE DISCUSSIONTOPICBYATTRACTION;
DROP TABLE PACKAGEATTRACTION;
DROP TABLE TICKETSAVAILABLE;
DROP TABLE TRANSACTIONATTRACTION;
DROP TABLE ATTRACTION;
DROP TABLE ATTRACTIONTYPE;
DROP TABLE DISCUSSIONTOPICBYCITY;
DROP TABLE CITY;
DROP TABLE COMPANY;
DROP TABLE TRANSACTIONDISCOUNT;
DROP TABLE DISCOUNT;
DROP TABLE DISCUSSIONTHREADCOMMENT;
DROP TABLE DISCUSSIONTHREAD;
DROP TABLE DISCUSSIONTOPIC;
DROP TABLE EMPLOYEEBOSS;
DROP TABLE EMPLOYEEDATEWORKING;
DROP TABLE EMPLOYEEROLE;
DROP TABLE EMPLOYEE_TEAM;
DROP TABLE LIKES;
DROP TABLE USERWEBSITE;
DROP TABLE MEMBERSHIP_TYPE;
DROP TABLE TRANSACTIONPACKAGE;
DROP TABLE PACKAGES;
DROP TABLE REVENUE;
DROP TABLE ROLE;
DROP TABLE TEAM;
DROP TABLE TRANSACTIONREWARD;
DROP TABLE TRANSACTIONINFO;
DROP TABLE USEREMPLOYEE;
DROP TABLE USERPAYMENTINFO;
DROP TABLE USERPHONES;
DROP TABLE USERBASE;



/* Drop Sequences */

DROP SEQUENCE SEQ_ACTIVITYLOG_ID;
DROP SEQUENCE SEQ_ACTIVITYTYPE_ID;
DROP SEQUENCE SEQ_ATTRACTIONREVIEW_ID;
DROP SEQUENCE SEQ_ATTRACTIONTYPE_ID;
DROP SEQUENCE SEQ_ATTRACTIONVISITED_ID;
DROP SEQUENCE SEQ_ATTRACTION_ID;
DROP SEQUENCE SEQ_CITY_ID;
DROP SEQUENCE SEQ_COMMENTS_ID;
DROP SEQUENCE SEQ_COMPANY_ID;
DROP SEQUENCE SEQ_DISCOUNT_ID;
DROP SEQUENCE SEQ_DISCUSSIONTHREADCOMMENT_ID;
DROP SEQUENCE SEQ_DISCUSSIONTHREAD_ID;
DROP SEQUENCE SEQ_DISCUSSIONTOPIC_ID;
DROP SEQUENCE SEQ_LIKES_ID;
DROP SEQUENCE SEQ_MEMBERSHIP_TYPE_ID;
DROP SEQUENCE SEQ_PACKAGES_ID;
DROP SEQUENCE SEQ_ROLE_ID;
DROP SEQUENCE SEQ_TEAM_ID;
DROP SEQUENCE SEQ_TICKETSAVAILABLE_ID;
DROP SEQUENCE SEQ_TRANSACTIONATTRACTION_ID;
DROP SEQUENCE SEQ_TRANSACTIONINFO_ID;
DROP SEQUENCE SEQ_TRANSACTIONPACKAGE_ID;
DROP SEQUENCE SEQ_TRANSACTIONREWARD_ID;
DROP SEQUENCE SEQ_USERBASE_ID;
DROP SEQUENCE SEQ_USERPHONES_ID;




/* Create Sequences */

CREATE SEQUENCE SEQ_ACTIVITYLOG_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ACTIVITYTYPE_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ATTRACTIONREVIEW_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ATTRACTIONTYPE_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ATTRACTIONVISITED_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ATTRACTION_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_CITY_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_COMMENTS_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_COMPANY_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_DISCOUNT_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_DISCUSSIONTHREADCOMMENT_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_DISCUSSIONTHREAD_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_DISCUSSIONTOPIC_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_LIKES_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_MEMBERSHIP_TYPE_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_PACKAGES_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ROLE_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_TEAM_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_TICKETSAVAILABLE_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_TRANSACTIONATTRACTION_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_TRANSACTIONINFO_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_TRANSACTIONPACKAGE_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_TRANSACTIONREWARD_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_USERBASE_ID INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_USERPHONES_ID INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE ACTIVITYLOG
(
	ID NUMBER NOT NULL,
	ACTIVITYTYPEID NUMBER,
	USERID NUMBER NOT NULL,
	DESCRIPTION VARCHAR2(200),
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE ACTIVITYTYPE
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	POINTSEARNED NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE ATTRACTION
(
	ID NUMBER NOT NULL,
	CODE VARCHAR2(10) NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	ADDRESS VARCHAR2(70),
	DESCRIPTION VARCHAR2(2000),
	DEFAULT_NO_TICKETS NUMBER NOT NULL,
	CITYID NUMBER NOT NULL,
	ATTRACTIONTYPEID NUMBER NOT NULL,
	TIMINGS VARCHAR2(30) NOT NULL,
	COMMISSION NUMBER(5,2) NOT NULL,
	COMPANYID NUMBER NOT NULL,
	DIRECTORID NUMBER,
	COSTPERTICKET NUMBER(7,2) NOT NULL,
	CREATEDBY DATE NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY DATE NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE ATTRACTIONEMPLOYEE
(
	EMPLOYEEID NUMBER NOT NULL,
	ATTRACTIONID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (EMPLOYEEID, ATTRACTIONID)
);


CREATE TABLE ATTRACTIONMANAGEMENT
(
	ATTRACTIONID NUMBER NOT NULL,
	MAINTENANCECOUNT NUMBER DEFAULT 0 NOT NULL,
	SECURITYCOUNT NUMBER DEFAULT 0 NOT NULL,
	TICKETINGCOUNT NUMBER DEFAULT 0 NOT NULL,
	CURATORCOUNT NUMBER DEFAULT 0 NOT NULL,
	TOURGUIDECOUNT NUMBER DEFAULT 0 NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	STAFFDELEGATIONFLAG NUMBER(1,0),
	PRIMARY KEY (ATTRACTIONID)
);


CREATE TABLE ATTRACTIONREVIEW
(
	ID NUMBER NOT NULL,
	ATTRACTIONID NUMBER NOT NULL,
	USERID NUMBER NOT NULL,
	DESCRIPTION VARCHAR2(2000),
	TITLE VARCHAR2(70),
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE ATTRACTIONTYPE
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE ATTRACTIONVISITED
(
	ID NUMBER NOT NULL,
	TRANSACTIONID NUMBER,
	ATTRACTIONID NUMBER,
	USERID NUMBER,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE CITY
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE COMMENTS
(
	ID NUMBER NOT NULL,
	REVIEWID NUMBER NOT NULL,
	COMMENTTEXT VARCHAR2(2000),
	USERID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE COMPANY
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	ADDRESS VARCHAR2(40),
	CITYID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE DISCOUNT
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	MEMBERSHIPTYPEID NUMBER NOT NULL,
	-- % / $
	FORMULA VARCHAR2(20) NOT NULL,
	FORMULAVALUE NUMBER(7,2) NOT NULL,
	NOOFTRANSACTIONS NUMBER,
	ISACTIVE NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE DISCUSSIONTHREAD
(
	ID NUMBER NOT NULL,
	TOPICID NUMBER NOT NULL,
	TITLE VARCHAR2(70),
	DESCRIPTION VARCHAR2(2000),
	USERID NUMBER,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE DISCUSSIONTHREADCOMMENT
(
	ID NUMBER NOT NULL,
	THREADID NUMBER NOT NULL,
	TITLE VARCHAR2(70),
	DESCRIPTION VARCHAR2(2000),
	USERID NUMBER,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE DISCUSSIONTOPIC
(
	ID NUMBER NOT NULL,
	TITLE VARCHAR2(70) NOT NULL,
	DESCRIPTION VARCHAR2(2000),
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE DISCUSSIONTOPICBYATTRACTION
(
	ATTRACTIONID NUMBER NOT NULL,
	DISCUSSIONTOPICID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ATTRACTIONID, DISCUSSIONTOPICID)
);


CREATE TABLE DISCUSSIONTOPICBYCITY
(
	CITYID NUMBER NOT NULL,
	DISCUSSIONTOPICID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (CITYID, DISCUSSIONTOPICID)
);


CREATE TABLE EMPLOYEEBOSS
(
	EMPLOYEEID NUMBER NOT NULL,
	BOSSEMPLOYEEID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (EMPLOYEEID, BOSSEMPLOYEEID)
);


CREATE TABLE EMPLOYEEDATEWORKING
(
	DAYOFF DATE NOT NULL,
	LEAVE_REASON VARCHAR2(50),
	USERID NUMBER NOT NULL,
	CREATEDBY NUMBER,
	CREATEON DATE,
	MODIFIEDBY NUMBER,
	MODIFIEDON DATE,
	PRIMARY KEY (DAYOFF, USERID)
);


CREATE TABLE EMPLOYEEROLE
(
	EMPLOYEEID NUMBER NOT NULL,
	ROLEID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (EMPLOYEEID, ROLEID)
);


CREATE TABLE EMPLOYEE_TEAM
(
	EMPLOYEEID NUMBER NOT NULL,
	TEAMID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (EMPLOYEEID, TEAMID)
);


CREATE TABLE LIKES
(
	ID NUMBER NOT NULL,
	-- 1- City
	-- 2- Review
	-- 3- Topic
	-- 4- Attraction
	CONTENTTYPE NUMBER(7,0) NOT NULL,
	USERID NUMBER,
	-- 1- Like
	-- 2- Dislike
	LIKEORDISLIKE NUMBER NOT NULL,
	-- This can be the ID of the city, review, topic or attraction
	FOREIGNID NUMBER(7,0) NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE MEMBERSHIP_TYPE
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	CREDIT_POINTS_NEEDED NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE PACKAGEATTRACTION
(
	PACKAGEID NUMBER NOT NULL,
	ATTRACTIONID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (PACKAGEID, ATTRACTIONID)
);


CREATE TABLE PACKAGES
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	DESCRIPTION VARCHAR2(2000),
	COSTPERTICKET NUMBER(7,2) NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE REVENUE
(
	TRANSACTIONID NUMBER NOT NULL,
	REVENUEAMOUNT NUMBER,
	-- 0-deleted
	-- 1-Own Revenue
	-- 2-Commision Earned
	REVENUETYPE NUMBER,
	CREATEDBY NUMBER,
	CREATEON DATE,
	MODIFIEDBY NUMBER,
	MODIFIEDON DATE,
	PRIMARY KEY (TRANSACTIONID)
);


CREATE TABLE ROLE
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	DESCRIPTION VARCHAR2(200),
	-- Marketing / Operations
	TYPE NVARCHAR2(20),
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE TEAM
(
	ID NUMBER NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	BOSS_EMPLOYEE_ID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE TICKETSAVAILABLE
(
	ID NUMBER NOT NULL,
	ATTRACTIONID NUMBER NOT NULL,
	REMAININGTICKETS NUMBER NOT NULL,
	DATEAVAILABLE DATE NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE TRANSACTIONATTRACTION
(
	ID NUMBER NOT NULL,
	TRANSACTIONID NUMBER NOT NULL,
	ATTRACTIONID NUMBER NOT NULL,
	TICKETCOUNT NUMBER DEFAULT 1 NOT NULL,
	TICKETEXPIRATIONDATE DATE NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE TRANSACTIONDISCOUNT
(
	TRANSACTIONID NUMBER NOT NULL,
	DISCOUNTID NUMBER NOT NULL,
	DISCOUNTAMOUNT NUMBER(7,2) NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (TRANSACTIONID, DISCOUNTID)
);


CREATE TABLE TRANSACTIONINFO
(
	ID NUMBER NOT NULL,
	USERID NUMBER NOT NULL,
	AMOUNT NUMBER NOT NULL,
	REWARDPOINTSUSED NUMBER(7,0) DEFAULT 0 NOT NULL,
	CREDITCARDAMOUNT NUMBER(7,2) DEFAULT 0 NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE TRANSACTIONPACKAGE
(
	ID NUMBER NOT NULL,
	TRANSACTIONID NUMBER NOT NULL,
	PACKAGEID NUMBER NOT NULL,
	TICKETCOUNT NUMBER DEFAULT 1 NOT NULL,
	TICKETEXPIRATIONDATE DATE NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE TRANSACTIONREWARD
(
	ID NUMBER NOT NULL,
	TRANSACTIONID NUMBER NOT NULL,
	REWARDPOINTSBOUGHT NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE USERBASE
(
	ID NUMBER NOT NULL,
	DISPLAYNAME VARCHAR2(50) NOT NULL,
	EMAIL VARCHAR2(30) NOT NULL,
	PASSWORD VARCHAR2(20) NOT NULL,
	ADDRESS VARCHAR2(70) NOT NULL,
	CITY VARCHAR2(50),
	ZIPCODE VARCHAR2(20) NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE USEREMPLOYEE
(
	USERID NUMBER NOT NULL,
	SSN NUMBER(9,0) NOT NULL,
	COMPANYID NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (USERID)
);


CREATE TABLE USERPAYMENTINFO
(
	USERID NUMBER NOT NULL,
	CREDITCARDNUMBER NUMBER NOT NULL,
	EXPIRYDATE DATE NOT NULL,
	CODE NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (USERID)
);


CREATE TABLE USERPHONES
(
	ID NUMBER NOT NULL,
	USERID NUMBER NOT NULL,
	PHONENUMBER NUMBER(15,0) NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (ID)
);


CREATE TABLE USERWEBSITE
(
	USERID NUMBER NOT NULL,
	REWARDPOINTS NUMBER NOT NULL,
	CREDITPOINTS NUMBER NOT NULL,
	MEMBERSHIPTYPE NUMBER NOT NULL,
	CREATEDBY NUMBER NOT NULL,
	CREATEDON DATE NOT NULL,
	MODIFIEDBY NUMBER NOT NULL,
	MODIFIEDON DATE NOT NULL,
	PRIMARY KEY (USERID)
);



/* Create Foreign Keys */

ALTER TABLE ACTIVITYLOG
	ADD FOREIGN KEY (ACTIVITYTYPEID)
	REFERENCES ACTIVITYTYPE (ID)
;


ALTER TABLE ATTRACTIONEMPLOYEE
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE ATTRACTIONMANAGEMENT
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE ATTRACTIONREVIEW
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE ATTRACTIONVISITED
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE DISCUSSIONTOPICBYATTRACTION
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE PACKAGEATTRACTION
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE TICKETSAVAILABLE
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE TRANSACTIONATTRACTION
	ADD FOREIGN KEY (ATTRACTIONID)
	REFERENCES ATTRACTION (ID)
;


ALTER TABLE COMMENTS
	ADD FOREIGN KEY (REVIEWID)
	REFERENCES ATTRACTIONREVIEW (ID)
;


ALTER TABLE ATTRACTION
	ADD FOREIGN KEY (ATTRACTIONTYPEID)
	REFERENCES ATTRACTIONTYPE (ID)
;


ALTER TABLE ATTRACTION
	ADD FOREIGN KEY (CITYID)
	REFERENCES CITY (ID)
;


ALTER TABLE DISCUSSIONTOPICBYCITY
	ADD FOREIGN KEY (CITYID)
	REFERENCES CITY (ID)
;


ALTER TABLE ATTRACTION
	ADD CONSTRAINT FK_COMPANY_ATTRACTION FOREIGN KEY (COMPANYID)
	REFERENCES COMPANY (ID)
;


ALTER TABLE TRANSACTIONDISCOUNT
	ADD FOREIGN KEY (DISCOUNTID)
	REFERENCES DISCOUNT (ID)
;


ALTER TABLE DISCUSSIONTHREADCOMMENT
	ADD FOREIGN KEY (THREADID)
	REFERENCES DISCUSSIONTHREAD (ID)
;


ALTER TABLE DISCUSSIONTHREAD
	ADD FOREIGN KEY (TOPICID)
	REFERENCES DISCUSSIONTOPIC (ID)
;


ALTER TABLE DISCUSSIONTOPICBYATTRACTION
	ADD FOREIGN KEY (DISCUSSIONTOPICID)
	REFERENCES DISCUSSIONTOPIC (ID)
;


ALTER TABLE DISCUSSIONTOPICBYCITY
	ADD FOREIGN KEY (DISCUSSIONTOPICID)
	REFERENCES DISCUSSIONTOPIC (ID)
;


ALTER TABLE DISCOUNT
	ADD FOREIGN KEY (MEMBERSHIPTYPEID)
	REFERENCES MEMBERSHIP_TYPE (ID)
;


ALTER TABLE USERWEBSITE
	ADD FOREIGN KEY (MEMBERSHIPTYPE)
	REFERENCES MEMBERSHIP_TYPE (ID)
;


ALTER TABLE PACKAGEATTRACTION
	ADD FOREIGN KEY (PACKAGEID)
	REFERENCES PACKAGES (ID)
;


ALTER TABLE TRANSACTIONPACKAGE
	ADD FOREIGN KEY (PACKAGEID)
	REFERENCES PACKAGES (ID)
;


ALTER TABLE EMPLOYEEROLE
	ADD FOREIGN KEY (ROLEID)
	REFERENCES ROLE (ID)
;


ALTER TABLE EMPLOYEE_TEAM
	ADD FOREIGN KEY (TEAMID)
	REFERENCES TEAM (ID)
;


ALTER TABLE ATTRACTIONVISITED
	ADD FOREIGN KEY (TRANSACTIONID)
	REFERENCES TRANSACTIONINFO (ID)
;


ALTER TABLE REVENUE
	ADD FOREIGN KEY (TRANSACTIONID)
	REFERENCES TRANSACTIONINFO (ID)
;


ALTER TABLE TRANSACTIONATTRACTION
	ADD FOREIGN KEY (TRANSACTIONID)
	REFERENCES TRANSACTIONINFO (ID)
;


ALTER TABLE TRANSACTIONDISCOUNT
	ADD FOREIGN KEY (TRANSACTIONID)
	REFERENCES TRANSACTIONINFO (ID)
;


ALTER TABLE TRANSACTIONPACKAGE
	ADD FOREIGN KEY (TRANSACTIONID)
	REFERENCES TRANSACTIONINFO (ID)
;


ALTER TABLE TRANSACTIONREWARD
	ADD FOREIGN KEY (TRANSACTIONID)
	REFERENCES TRANSACTIONINFO (ID)
;


ALTER TABLE ACTIVITYLOG
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE ATTRACTIONREVIEW
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE ATTRACTIONVISITED
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE COMMENTS
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE DISCUSSIONTHREAD
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE DISCUSSIONTHREADCOMMENT
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE LIKES
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE TRANSACTIONINFO
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE USEREMPLOYEE
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE USERPAYMENTINFO
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE USERPHONES
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE USERWEBSITE
	ADD FOREIGN KEY (USERID)
	REFERENCES USERBASE (ID)
;


ALTER TABLE ATTRACTION
	ADD FOREIGN KEY (DIRECTORID)
	REFERENCES USEREMPLOYEE (USERID)
;


ALTER TABLE ATTRACTIONEMPLOYEE
	ADD FOREIGN KEY (EMPLOYEEID)
	REFERENCES USEREMPLOYEE (USERID)
;


ALTER TABLE EMPLOYEEBOSS
	ADD FOREIGN KEY (EMPLOYEEID)
	REFERENCES USEREMPLOYEE (USERID)
;


ALTER TABLE EMPLOYEEBOSS
	ADD FOREIGN KEY (BOSSEMPLOYEEID)
	REFERENCES USEREMPLOYEE (USERID)
;


ALTER TABLE EMPLOYEEDATEWORKING
	ADD FOREIGN KEY (USERID)
	REFERENCES USEREMPLOYEE (USERID)
;


ALTER TABLE EMPLOYEEROLE
	ADD FOREIGN KEY (EMPLOYEEID)
	REFERENCES USEREMPLOYEE (USERID)
;


ALTER TABLE EMPLOYEE_TEAM
	ADD FOREIGN KEY (EMPLOYEEID)
	REFERENCES USEREMPLOYEE (USERID)
;


ALTER TABLE TEAM
	ADD FOREIGN KEY (BOSS_EMPLOYEE_ID)
	REFERENCES USEREMPLOYEE (USERID)
;



/* Create Triggers */
/
CREATE TRIGGER TRI_ACTIVITYLOG_ID BEFORE INSERT ON ACTIVITYLOG
FOR EACH ROW
BEGIN
	SELECT SEQ_ACTIVITYLOG_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_ACTIVITYTYPE_ID BEFORE INSERT ON ACTIVITYTYPE
FOR EACH ROW
BEGIN
	SELECT SEQ_ACTIVITYTYPE_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_ATTRACTIONREVIEW_ID BEFORE INSERT ON ATTRACTIONREVIEW
FOR EACH ROW
BEGIN
	SELECT SEQ_ATTRACTIONREVIEW_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_ATTRACTIONTYPE_ID BEFORE INSERT ON ATTRACTIONTYPE
FOR EACH ROW
BEGIN
	SELECT SEQ_ATTRACTIONTYPE_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_ATTRACTIONVISITED_ID BEFORE INSERT ON ATTRACTIONVISITED
FOR EACH ROW
BEGIN
	SELECT SEQ_ATTRACTIONVISITED_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_ATTRACTION_ID BEFORE INSERT ON ATTRACTION
FOR EACH ROW
BEGIN
	SELECT SEQ_ATTRACTION_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_CITY_ID BEFORE INSERT ON CITY
FOR EACH ROW
BEGIN
	SELECT SEQ_CITY_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_COMMENTS_ID BEFORE INSERT ON COMMENTS
FOR EACH ROW
BEGIN
	SELECT SEQ_COMMENTS_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_COMPANY_ID BEFORE INSERT ON COMPANY
FOR EACH ROW
BEGIN
	SELECT SEQ_COMPANY_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_DISCOUNT_ID BEFORE INSERT ON DISCOUNT
FOR EACH ROW
BEGIN
	SELECT SEQ_DISCOUNT_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_DISCUSSIONTHREADCOMMENT_ID BEFORE INSERT ON DISCUSSIONTHREADCOMMENT
FOR EACH ROW
BEGIN
	SELECT SEQ_DISCUSSIONTHREADCOMMENT_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_DISCUSSIONTHREAD_ID BEFORE INSERT ON DISCUSSIONTHREAD
FOR EACH ROW
BEGIN
	SELECT SEQ_DISCUSSIONTHREAD_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_DISCUSSIONTOPIC_ID BEFORE INSERT ON DISCUSSIONTOPIC
FOR EACH ROW
BEGIN
	SELECT SEQ_DISCUSSIONTOPIC_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_LIKES_ID BEFORE INSERT ON LIKES
FOR EACH ROW
BEGIN
	SELECT SEQ_LIKES_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_MEMBERSHIP_TYPE_ID BEFORE INSERT ON MEMBERSHIP_TYPE
FOR EACH ROW
BEGIN
	SELECT SEQ_MEMBERSHIP_TYPE_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_PACKAGES_ID BEFORE INSERT ON PACKAGES
FOR EACH ROW
BEGIN
	SELECT SEQ_PACKAGES_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_ROLE_ID BEFORE INSERT ON ROLE
FOR EACH ROW
BEGIN
	SELECT SEQ_ROLE_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_TEAM_ID BEFORE INSERT ON TEAM
FOR EACH ROW
BEGIN
	SELECT SEQ_TEAM_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_TICKETSAVAILABLE_ID BEFORE INSERT ON TICKETSAVAILABLE
FOR EACH ROW
BEGIN
	SELECT SEQ_TICKETSAVAILABLE_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_TRANSACTIONATTRACTION_ID BEFORE INSERT ON TRANSACTIONATTRACTION
FOR EACH ROW
BEGIN
	SELECT SEQ_TRANSACTIONATTRACTION_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_TRANSACTIONINFO_ID BEFORE INSERT ON TRANSACTIONINFO
FOR EACH ROW
BEGIN
	SELECT SEQ_TRANSACTIONINFO_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_TRANSACTIONPACKAGE_ID BEFORE INSERT ON TRANSACTIONPACKAGE
FOR EACH ROW
BEGIN
	SELECT SEQ_TRANSACTIONPACKAGE_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_TRANSACTIONREWARD_ID BEFORE INSERT ON TRANSACTIONREWARD
FOR EACH ROW
BEGIN
	SELECT SEQ_TRANSACTIONREWARD_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_USERBASE_ID BEFORE INSERT ON USERBASE
FOR EACH ROW
BEGIN
	SELECT SEQ_USERBASE_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/
CREATE TRIGGER TRI_USERPHONES_ID BEFORE INSERT ON USERPHONES
FOR EACH ROW
BEGIN
	SELECT SEQ_USERPHONES_ID.NEXTVAL
	INTO :NEW.ID
	FROM DUAL;
END;
/


create or replace 
trigger trg_employeeteamCountCheck
Before insert on EMPLOYEE_TEAM
For Each Row
DECLARE  count_team number;
             
BEGIN
select count(employeeid) into count_team from employee_team where employeeid=:NEW.employeeid;
 
 if count_team >= 3 then
 
RAISE_APPLICATION_ERROR(-20005, 'EMPLOYEE_NOT_ALLOWED_IN_4_TEAMS');
end if;
 END;
/
/* Comments */

COMMENT ON COLUMN DISCOUNT.FORMULA IS '% / $';
COMMENT ON COLUMN LIKES.CONTENTTYPE IS '1- City
2- Review
3- Topic
4- Attraction';
COMMENT ON COLUMN LIKES.LIKEORDISLIKE IS '1- Like
2- Dislike';
COMMENT ON COLUMN LIKES.FOREIGNID IS 'This can be the ID of the city, review, topic or attraction';
COMMENT ON COLUMN REVENUE.REVENUETYPE IS '0-deleted
1-Own Revenue
2-Commision Earned';
COMMENT ON COLUMN ROLE.TYPE IS 'Marketing / Operations';


