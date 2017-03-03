create table games (id int primary key auto_increment, aPlayer1 varchar(255), aPlayer2 varchar(255), bPlayer1 varchar(255), bPlayer2 varchar(255), aScore INTEGER , bScore INTEGER, dateOfGame TIMESTAMP);
create table players (id int primary key auto_increment, username varchar(255) UNIQUE , gamesWon INTEGER , gamesLost INTEGER, setsWon INTEGER , setsLost INTEGER, points INTEGER, winCount INTEGER, lossCount INTEGER);
create table scores (id int primary key auto_increment, username varchar(255), rank INTEGER , points INTEGER, creationTime TIMESTAMP);

