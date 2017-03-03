create table games (id int primary key auto_increment, aPlayer1 varchar(255), aPlayer2 varchar(255), bPlayer1 varchar(255), bPlayer2 varchar(255), aScore INTEGER , bScore INTEGER, dateOfGame TIMESTAMP);
create table players (id int primary key auto_increment, username varchar(255) UNIQUE , gamesWon INTEGER , gamesLost INTEGER, setsWon INTEGER , setsLost INTEGER, points INTEGER, winCount INTEGER, lossCount INTEGER);
create table scores (id int primary key auto_increment, username varchar(255), rank INTEGER , points INTEGER, creationTime TIMESTAMP);

insert into games (aPlayer1, aPlayer2, bPlayer1, bPlayer2, aScore, bScore, dateOfGame) values ('Marcin', 'Janusz', 'Lukasz', 'Anastasiia', 3, 2, CURRENT_TIMESTAMP());
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points, winCount, lossCount) values ('Marcin', 1, 0, 3, 2, 100, 0, 0);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points, winCount, lossCount) values ('Lukasz', 1, 0, 3, 2, 100, 0, 0);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points, winCount, lossCount) values ('Anastasiia', 2, 0, 3, 2, 100, 0, 0);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points, winCount, lossCount) values ('Janusz', 1, 0, 3, 2, 100, 0, 0);
insert into players (username, gamesWon, gamesLost, setsWon, setsLost, points, winCount, lossCount) values ('Ania', 1, 0, 3, 2, 100, 0, 0);
