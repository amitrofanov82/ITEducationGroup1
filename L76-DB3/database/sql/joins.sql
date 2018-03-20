CREATE TABLE users (
	id int PRIMARY KEY,
	name varchar(20),
	
);

CREATE TABLE chess_game (
	id int NOT NULL,
	user1_id int NOT NULL REFERENCES users (id),
	user2_id int NOT NULL,
	kolvo_hodov int,
	game_result varchar(30),
	FOREIGN KEY (user2_id) REFERENCES users (id),
	CHECK (kolvo_hodov <1000)
);

CREATE TABLE married_couple (
	user1_id int NOT NULL,
	user2_id int NOT NULL,
	PRIMARY KEY (user1_id, user2_id)
	//как избежать дублирования пар
);

INSERT INTO users (id, name) 
	values (1, 'vasya'), (2, 'lena'),(3, 'vatsa');

INSERT INTO chess_game (id, user1_id, user2_id, game_result) values (1, 1, 2, 'B');
INSERT INTO chess_game (id, user1_id, user2_id, game_result) values (1, 2, 1, 'B');
INSERT INTO chess_game (id, user1_id, user2_id, game_result) values (1, 1, 2, 'W');

SELECT * FROM USERS U, CHESS_GAME C
	WHERE NAME='vasya' AND U.ID=C.USER1_ID;
	
SELECT * FROM USERS INNER JOIN CHESS_GAME 
	ON USERS.id=chess_game.user1_id;

SELECT * FROM USERS OUTER LEFT JOIN CHESS_GAME 
	ON USERS.id=chess_game.user1_id;

SELECT * FROM USERS LEFT JOIN CHESS_GAME 
	ON USERS.id=chess_game.user1_id;
	