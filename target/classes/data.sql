DROP DATABASE IF EXISTS kpacs;
CREATE DATABASE kpacs;
USE kpacs;

insert into kpac values (default , 'War and Peace','War and Peace is a novel by the Russian author Leo Tolstoy, first published serially, then published in its entirety in 1869. It is regarded as one of Tolstoy''s finest literary achievements and remains a classic of world literature.',now());
insert into kpac values (default , 'The Green Mile','The Green Mile is a 1999 American fantasy drama film written and directed by Frank Darabont and based on Stephen King''s 1996 novel of the same name.',now());
insert into kpac values (default , 'Database','A database is an organized collection of data, generally stored and accessed electronically from a computer system. ',now());
insert into kpac values (default , 'Docker','Docker is a set of platform as a service (PaaS) products that use OS-level virtualization to deliver software in packages called containers.',now());
insert into kpac values (default , 'Atari','The original Atari, Inc., founded in Sunnyvale, California in 1972 by Nolan Bushnell and Ted Dabney, was a pioneer in arcade games, home video game consoles, and home computers.',now());
insert into kpac values (default , 'Donald Trump',' The Simpsons episode "Bart to the Future", written during his 2000 campaign for the Reform party, anticipated a future Trump presidency.',now());

insert into kpac_set values (default , "Books set");
insert into kpac_set values (default , "Movies set");
insert into kpac_set values (default , "Random facts set");

insert into kpac_set_kpac values (default , 1,1);
insert into kpac_set_kpac values (default , 2,2);
insert into kpac_set_kpac values (default , 3,3);
insert into kpac_set_kpac values (default , 3,4);
insert into kpac_set_kpac values (default , 3,5);