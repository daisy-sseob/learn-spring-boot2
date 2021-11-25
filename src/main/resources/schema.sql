-- 이 파일을 통해 database 초기화가 진행된다. test scope에서는 현재 인메모리 database를 사용하고 있는데 
-- spring.jpa.hibernate.ddl-auto=validate 옵션으로 테스트할 경우 스키마가 없어서 에러가 발생하지만 아래 스키마 초기화 과정을 이용해 에러를 방지한다.
drop table if exists account CASCADE 
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table account (id bigint not null, email varchar(255), password varchar(255), username varchar(255), primary key (id))