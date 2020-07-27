-- Oracle
create table account (
	id number(19) not null,
	name varchar2(20) not null,
	sex char(1) not null,  -- M,F
	phone varchar2(20) default null

);
create sequence seq_account start with 1 increment by 1;


-- MS-SQL
create table account (
	id bigint identity(1,1) primary key,
	name varchar(20) not null,
	sex char(1) not null,
	phone varchar(20) default null
);