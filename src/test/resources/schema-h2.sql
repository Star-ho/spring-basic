-- auto-generated definition

create table if not exists MEMBER
(
    id          bigint auto_increment
        primary key,
    DELETED     tinyint(1) default 0 not null,
    CREATED_AT  datetime             null,
    MODIFIED_AT datetime             null,
    EMAIL       varchar(30)          not null,
    PASSWORD    varchar(60)          not null,
    ROLE        varchar(20)          not null
);

create table if not exists `ORDER`
(
    id          int auto_increment
        primary key,
    TOTAL_PRICE bigint               not null,
    MEMBER_ID   int                  null,
    DELETED     tinyint(1) default 0 not null,
    CREATED_AT  datetime             null,
    MODIFIED_AT datetime             null
);

create table if not exists ORDER_ENTRY
(
    id          bigint auto_increment
        primary key,
    DELETED     tinyint(1) default 0 not null,
    CREATED_AT  datetime             not null,
    MODIFIED_AT datetime             null,
    PRICE       bigint               not null,
    QUANTITY    int                  not null,
    ORDER_ID    bigint               not null,
    PRODUCT_ID  bigint               not null
);

create table if not exists PRODUCT
(
    id          bigint auto_increment
        primary key,
    DELETED     tinyint(1) default 0 not null,
    CREATED_AT  datetime             null,
    MODIFIED_AT datetime             null,
    LABEL       varchar(20)          not null,
    PRICE       bigint               not null
);

