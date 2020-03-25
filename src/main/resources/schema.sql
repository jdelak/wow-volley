CREATE DATABASE wvmanager;

CREATE TABLE users(
id_user serial NOT NULL,
name_user varchar(30) NOT NULL,
email_user varchar(255) NOT NULL,
password_user varchar(255) NOT NULL,
money_user int default 20000,
first_login boolean default true,
primary key (id_user)
);

CREATE TYPE type_image as ENUM ('ETHNICITY', 'FACTION', 'TEAM'); 

CREATE TABLE images(
id_image serial NOT NULL,
url_image varchar(255) NOT NULL,
name_type_image type_image,
primary key (id_image)
);

CREATE TABLE factions(
id_faction serial NOT NULL,
name_faction varchar(20) NOT NULL,
id_image_faction int NOT NULL,
primary key (id_faction)
);

CREATE TABLE ethnicities(
id_ethnicity serial NOT NULL,
name_ethnicity varchar (20) NOT NULL,
id_image_ethnicity int NOT NULL,
id_faction_ethnicity int NOT NULL,
primary key (id_ethnicity)
);

CREATE TABLE divisions(
id_division serial NOT NULL,
level_division smallint NOT NULL,
parent_division int default NULL,
pts_to_up_division smallint,
pts_to_down_division smallint,
primary key (id_division)
);

CREATE TABLE teams(
id_team serial NOT NULL,
name_team varchar(30),
id_image_team int NOT NULL,
id_faction_team int NOT NULL,
id_user_team int NOT NULL,
id_division_team int default 15,
primary key (id_team)
);

CREATE TYPE position_role as ENUM ('LIBERO', 'MIDDLE_BLOCKER', 'OUTSIDE_HITTER', 'OPPOSITE', 'SETTER');

CREATE TABLE players(
id_player serial NOT NULL,
firstname_player varchar(40) NOT NULL,
lastname_player varchar(40) NOT NULL,
attack_player smallint NOT NULL default 20,
block_player smallint NOT NULL default 20,
dig_player smallint NOT NULL default 20,
passing_player smallint NOT NULL default 20,
serve_player smallint NOT NULL default 20,
age_player smallint NOT NULL default 16,
training_count_player smallint default 10,
position_player position_role,
image_player varchar(255),
in_team_player boolean default false,
in_substitute_player boolean default false,
injured_player boolean default false,
retired_player boolean default false,
id_ethnicity_player int NOT NULL,
id_team_player int default NULL,
primary key (id_player) 
); 

CREATE TABLE matchs(
id_match serial NOT NULL,
id_team1_match int NOT NULL,
id_team2_match int NOT NULL,
team1_result_match varchar NOT NULL,
team2_result_match varchar NOT NULL,
id_division_match int NOT NULL,
date_match timestamp,
primary key (id_match)     
);

CREATE TABLE results(
id_result_match int NOT NULL,
id_team_winner int NOT NULL,
id_team_defeated int NOT NULL,
primary key(id_result_match)    
);

ALTER TABLE factions
ADD FOREIGN KEY (id_image_faction)
REFERENCES images (id_image);

ALTER TABLE ethnicities
ADD FOREIGN KEY (id_image_ethnicity)
REFERENCES images (id_image),
ADD FOREIGN KEY (id_faction_ethnicity)
REFERENCES factions (id_faction);

ALTER TABLE teams
ADD FOREIGN KEY (id_division_team)
REFERENCES divisions (id_division),
ADD FOREIGN KEY (id_user_team)
REFERENCES users (id_user),
ADD FOREIGN KEY (id_faction_team)
REFERENCES factions (id_faction);

ALTER TABLE players
ADD FOREIGN KEY (id_ethnicity_player)
REFERENCES ethnicities (id_ethnicity),
ADD FOREIGN KEY (id_team_player)
REFERENCES teams (id_team);

ALTER TABLE matchs
ADD FOREIGN KEY (id_team1_match)
REFERENCES teams (id_team),
ADD FOREIGN KEY (id_team2_match)
REFERENCES teams (id_team),
ADD FOREIGN KEY (id_division_match)
REFERENCES divisions (id_division);

ALTER TABLE results
ADD FOREIGN KEY (id_result_match)
REFERENCES matchs (id_match),
ADD FOREIGN KEY (id_team_winner)
REFERENCES teams (id_team),
ADD FOREIGN KEY (id_team_defeated)
REFERENCES teams (id_team);

CREATE SEQUENCE HIBERNATE_SEQUENCE START 1;
