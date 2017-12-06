# server
2017 fall semester dongguk university computer science &amp; engineering embeded project 'mood light' server
### teams   
> Kim jae hun, Kim kung ryung, Lee sung min, Sin yu kyung, Yun ju hyung

## server 개발 기술
> jdk 1.8, tomcat 8.0  
> Spring Boot, Gradle  
> MySQL, MyBatis  

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
voice_num int not null primary key,  
token varchar(30) not null,  
sender_token varchar(30) not null,  
voice_name varchar(255) not null,  
date timestamp default current_timestamp,  
flag int default 0 not null  
);  

—VOICES  
CREATE TABLE VOICES(  
voice_num int auto_increment primary key,  
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
flag int default 0,  
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

### API  
**user**  

URI|method|기능설명  
----|-------|-----  
/api/users|GET|모든 유저 목록 보기  
/api/users|POST|유저 등록(회원가입)  

user 등록시 color와 diffuesr정보를 한꺼번에 넘김  
<pre><code>
//json  
 {
	"token" : "AIJD832s",
	"user" : {
		"email" : "juhyung0818@naver.com",
		"name" : "juhyung",
		"moodLight" : "asflu8a3hiwfia38ao8vy9"
	},
	"colors" : [
		{"rgb" : 1, "flag" : 0},
		{"rgb" : 2, "flag" : 1},
		{"rgb" : 3, "flag" : 1}
	],
	"diffusers" : [
		{"diffuserName" : "orange", "flag" : 1},
		{"diffuserName" : "apple", "flag" : 0}
	]
}
</code> </pre>
**voice**  

URI|method|기능설명  
----|-------|-----  
/api/files|POST|voice 보내기(upload)  
/api/files/{voiceNum}|GET|voice 다운  
/api/files/box/{token}|GET|해당 유저의 voice 목록 보기

