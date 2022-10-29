-- 编写建库建表 sql
create database if not exists javaBlog;

use javaBlog;

-- 创建博客表
drop table if exists blog;

create table blog
(
    blogId   int primary key auto_increment,
    title    varchar(1024),
    content  mediumtext, -- 文章内容
    userId   int,        -- 文章的作者id
    postTime datetime
) char set utf8;

-- 创建用户表
drop table if exists user;

create table user
(
    userId   int primary key auto_increment,
    userName varchar(128) unique, -- 登录的用户名不能重复
    password varchar(128)
) char set utf8;

-- 测试表
insert into user
values (null, '小明', '1111');
insert into user
values (null, 'NUC-Dodamce', '2222');
insert into user
values (null, '小刚', '0000');

insert into blog
values (null, '第一篇博客', '测试博客列表', 1, now());
insert into blog
values (null, '第二篇博客', '继续测试博客列表', 1, now());
insert into blog
values (null, '第三篇博客', '继续测试博客列表', 1, now());
insert into blog
values (null, '第一篇博客', '测试不同用户的博客列表', 2, now());

