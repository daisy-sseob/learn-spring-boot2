-- test scope에서 hibernate를 통해서 스키마를 생성하지 않아도 이 파일을 통해 스키마를 생성하기 때문에 테스트를 무리없이 진행할 수 있다.
drop table if exists account CASCADE 
drop sequence if exists hibernate_sequence
create sequence hibernate_sequence start with 1 increment by 1
create table account (id bigint not null, email varchar(255), password varchar(255), username varchar(255), primary key (id))