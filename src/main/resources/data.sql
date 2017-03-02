create table games (id int primary key auto_increment, aPlayer1 varchar(255), aPlayer2 varchar(255), bPlayer1 varchar(255), bPlayer2 varchar(255), aScore INTEGER , bScore INTEGER, dateOfGame TIMESTAMP);
create table players (id int primary key auto_increment, username varchar(255) UNIQUE , gamesWon INTEGER , gamesLost INTEGER, setsWon INTEGER , setsLost INTEGER, points INTEGER);

insert into games (aPlayer1, aPlayer2, bPlayer1, bPlayer2, aScore, bScore, dateOfGame) values ('Marcin', 'Janusz', 'Lukasz', 'Anastasiia', 3, 2, CURRENT_TIMESTAMP());
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points) values ('Marcin', 1, 0, 3, 2, 125);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points) values ('Lukasz', 1, 0, 3, 2, 232);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points) values ('Anastasiia', 1, 0, 3, 2, 124);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points) values ('Janusz', 1, 0, 3, 2, 123);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points) values ('Ania', 1, 0, 3, 2, 543);
