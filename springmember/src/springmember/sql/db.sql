create user springmember identified by springmember;
grant connect, resource to springmember;

CREATE TABLE SPRINGMEMBER(
	MID VARCHAR2(20) PRIMARY KEY,
	MNAME NVARCHAR2(200),
	MGENDER CHAR(1),
	MCITY NVARCHAR2(100)
);

INSERT INTO SPRINGMEMBER VALUES ('MING', '¹Ö', 'M', '´ë±¸');
INSERT INTO SPRINGMEMBER VALUES ('HOHO', 'È©', 'F', '±¤ÁÖ');
INSERT INTO SPRINGMEMBER VALUES ('JUNG', 'ÂÄ', 'M', 'ºÎ»ê');

COMMIT;
SELECT * FROM SPRINGMEMBER;