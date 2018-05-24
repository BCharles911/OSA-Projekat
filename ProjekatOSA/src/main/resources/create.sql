create table users (
	id_user BIGINT AUTO_INCREMENT
	name_user VARCHAR(40) NOT NULL,
	username VARCHAR(40) NOT NULL,
	password VARCHAR(30) NOT NULL,
	role VARCHAR(30) NOT NULL
	




);


create table posts (post_title varchar(40) NOT NULL,
				post_descr VARCHAR(300) NOT NULL,
				FOREIGN KEY(author_id) REFERENCES users(id_user),
				date_created DATE NOT NULL,
				post_likes BIGINT NOT NULL,
				post_dislikes BIGINT NOT NULL

);



