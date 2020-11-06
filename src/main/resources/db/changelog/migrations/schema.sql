-- liquibase formatted SQL

-- changeset vinicius.castro:create-initial-tables



drop table if exists book_loan_history;
drop table if exists loan_history;
drop table if exists user;
drop table if exists book;
drop table if exists publishing_company;

create table user
(
    id           bigint(20)   not null auto_increment,
    name         varchar(100) not null,
    cpf          varchar(11)  not null,
    created_date datetime default current_timestamp,
    primary key (id)
);


create table publishing_company
(
    id           bigint(20)   not null auto_increment,
    created_date datetime default current_timestamp,
    name         varchar(255) not null,
    primary key (id)
);


create table book
(
    id                    bigint(20)   not null auto_increment,
    name                  varchar(255) not null,
    created_date          datetime                      default current_timestamp,
    status                enum ('AVAIABLE', 'ALOCATED') default 'AVAIABLE',
    publishing_company_id bigint(20)   not null,
    primary key (id),
    key (publishing_company_id),
    constraint foreign key (publishing_company_id) references publishing_company (id)
);

create table loan_history
(
    id              bigint(20) not null auto_increment,
    book_id         bigint(20) not null,
    user_id         bigint(20) not null,
    created_date    datetime default current_timestamp,
    devolution_date datetime,
    primary key (id),
    key (book_id),
    key (user_id),
    constraint foreign key (user_id) references user (id),
    constraint foreign key (book_id) references book (id)
);


create table book_loan_history
(
    book_id         bigint(20) not null,
    loan_history_id bigint(20) not null,
    unique (loan_history_id),
    key (book_id),
    constraint foreign key (loan_history_id) references loan_history (id),
    constraint foreign key (book_id) references book (id)
);
