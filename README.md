### teams   
Kim jae hun  
Yun ju hyung  
Lee sung min  
Kim kung ryung  
Sin yu kyung  

# server
2017 fall semester dongguk university computer science &amp; engineering embeded project 'mood light' server
> 임베디드 강의 프로젝트 과제  
> 은은한 빛과 좋은 향기로 자취생들에게 힐링을 주는 무드등  
> 음성편지 기능과 불쾌지수를 측정   

## server 개발 기술
> jdk 1.8, tomcat 8.0  
> Spring Boot, Gradle  
> MySQL, MyBatis  
> plugin : lombok  

### MySQL(DDL)  
— COLORS
CREATE TABLE  COLORS(  
token varchar(30) not null,  
rgb int not null,  
flag int not null default 0,  
primary key (token, rgb)  
);  

—VOICE_MAIL
CREATE TABLE VOICE_MAIL(  
voice_num int not null auto_increment primary key,  
token varchar(30) not null,  
sender_token varchar(30) not null,  
date timestamp default current_timestamp,  
flag int default 0 not null  
);  

—VOICES  
CREATE TABLE VOICES(  
voice_num int primary key,  
voice_name varchar(255) not null,  
save_voice_name varchar(4000) not null,  
date timestamp default current_timestamp not null,  
content_type varchar(255) not null,  
length int not null  
);  

—USERS  
CREATE TABLE USERS(  
token varchar(30) not null primary key,  
email varchar(200),  
name varchar(100),  
mood_light varchar(300)  
);  

—FRIENDS  
CREATE TABLE FRIENDS(  
my_token varchar(30) not null,  
friend_token varchar(30) not null,  
flag int,  
primary key(my_token, friend_token)  
);  

—DIFFUSERS  
CREATE TABLE DIFFUSERS(  
token varchar(30) not null,  
diffuser_name varchar(300) not null,  
flag int,  
primary key (token, diffuser_name)  
);  

— DISCOMFORT_INDEX  
CREATE TABLE DISCOMFORT_INDEX(  
token varchar(30) not null,  
temperature decimal not null,  
humidity decimal not null,  
discomfort_expression varchar(1000)  
);  
