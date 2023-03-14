drop table if exists message;
create table message
(
    id       int auto_increment
        primary key,
    username varchar(500) null,
    text     varchar(500) null
);
insert into message values
(1,'耿雪龙','欢迎大家来到世界聊天大厅，大家尽情聊天吧！')