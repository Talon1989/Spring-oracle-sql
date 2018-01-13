# Spring-oracle-sql
Testing for oracle db connection. Oracle Sql to create and populate 'BOOK' table:

drop table BOOK;
create table BOOK
(book_id NUMBER(20) NOT NULL
, book_name VARCHAR2(20) NOT NULL
, book_author VARCHAR2(20)
, book_price NUMBER(20)
, CONSTRAINT book_pk PRIMARY KEY (book_id)
);
insert all
into book (book_id, book_name, book_author, book_price) values (1, 'Nintenty-Eighty-Four', 'George Orwell', 15)
into book (book_id, book_name, book_author, book_price) values (2, 'Sidereus Nuncius', 'Galileo Galilei', 19)
select * from dual;
