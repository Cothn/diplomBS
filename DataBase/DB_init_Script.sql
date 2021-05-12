INSERT INTO `books_db`.`role` (`Title`) VALUES ('ROLE_USER');
INSERT INTO `books_db`.`role` (`Title`) VALUES ('ROLE_ADMIN');
INSERT INTO `books_db`.`role` (`Title`) VALUES ('ROLE_SUPER_ADMIN');

INSERT INTO `books_db`.`user` (`Nickname`, `Password`, `Role_Id`) VALUES ('super_admin', '$2a$10$lxIB1zZeB1SOuta6Ow5h1..WXxNcjpYoNKTx3w1naCb.Hp9cOtHSW', '3');
INSERT INTO `books_db`.`user` (`Nickname`, `Password`, `Role_Id`) VALUES ('admin', '$2a$10$8Ouj6pQ7jDWHXjlFcBNGXO6myncfZmkCdHLyQWx2uNyyg/woQ0nC2', '2');
INSERT INTO `books_db`.`user` (`Nickname`, `Password`, `Role_Id`) VALUES ('user', '$2a$10$sxPuXo7KIlFeGDgMyzTh4.N6ruUws4BuDOMXiq9BOf6QWe8SNjB2K', '1');

INSERT INTO `books_db`.`audiobook_file` (`Extension`, `File_path`) VALUES ('fb2', 'book.fb2');
INSERT INTO `books_db`.`audiobook_file` (`Extension`, `File_path`) VALUES ('fb2', 'book1.fb2');
INSERT INTO `books_db`.`audiobook_file` (`Extension`, `File_path`) VALUES ('fb2', 'book2.fb2');

INSERT INTO `books_db`.`audiobook` (`User_Id`, `Distributed`, `Title`, `Picture_Path`, `Publication_Year`, `Description`, `Add_Date`, `Audiobook_File_Id`) VALUES ('1', '1', 'one', 'pic.png', '2000', 'descript', '2021-04-21', '1');
INSERT INTO `books_db`.`audiobook` (`User_Id`, `Distributed`, `Title`, `Picture_Path`, `Publication_Year`, `Description`, `Add_Date`, `Audiobook_File_Id`) VALUES ('1', '1', 'two', 'pic.png', '2001', 'descript', '2021-04-21 20:49:00', '2');
INSERT INTO `books_db`.`audiobook` (`User_Id`, `Distributed`, `Title`, `Picture_Path`, `Publication_Year`, `Description`, `Add_Date`, `Audiobook_File_Id`) VALUES ('1', '1', 'three', 'pic.png', '2002', 'descript2', '2021-04-21 22:49:00', '3');

INSERT INTO `books_db`.`creator` (`Title`, `Author`) VALUES ('First', '1');
INSERT INTO `books_db`.`creator` (`Title`, `Author`) VALUES ('Two', '0');
INSERT INTO `books_db`.`creator` (`Title`, `Author`) VALUES ('Three', '1');
INSERT INTO `books_db`.`creator` (`Title`, `Author`) VALUES ('Four', '0');

INSERT INTO `books_db`.`genre` (`Title`) VALUES ('фантастика');
INSERT INTO `books_db`.`genre` (`Title`) VALUES ('фентези');
INSERT INTO `books_db`.`genre` (`Title`) VALUES ('криминал');
INSERT INTO `books_db`.`genre` (`Title`) VALUES ('детектив');

INSERT INTO `books_db`.`audiobook_genre` (`Audiobook_Id`, `Genre_Id`) VALUES ('1', '1');
INSERT INTO `books_db`.`audiobook_genre` (`Audiobook_Id`, `Genre_Id`) VALUES ('1', '3');
INSERT INTO `books_db`.`audiobook_genre` (`Audiobook_Id`, `Genre_Id`) VALUES ('2', '2');
INSERT INTO `books_db`.`audiobook_genre` (`Audiobook_Id`, `Genre_Id`) VALUES ('2', '4');
INSERT INTO `books_db`.`audiobook_genre` (`Audiobook_Id`, `Genre_Id`) VALUES ('3', '1');
INSERT INTO `books_db`.`audiobook_genre` (`Audiobook_Id`, `Genre_Id`) VALUES ('3', '4');

INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('1', '1');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('1', '2');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('1', '3');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('1', '4');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('2', '1');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('2', '2');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('2', '3');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('2', '4');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('3', '3');
INSERT INTO `books_db`.`audiobook_creator` (`Audiobook_Id`, `Creator_Id`) VALUES ('3', '4');

INSERT INTO `books_db`.`comment` (`Audiobook_Id`, `User_Id`, `Text`, `send_date_time`) VALUES ('1', '1', 'qwe', '2021.04.22');
INSERT INTO `books_db`.`comment` (`Audiobook_Id`, `User_Id`, `Text`, `send_date_time`) VALUES ('1', '1', 'qwe1', '2021.04.21');
INSERT INTO `books_db`.`comment` (`Audiobook_Id`, `User_Id`, `Text`, `send_date_time`) VALUES ('1', '1', 'qwe2', '2021.04.23');
INSERT INTO `books_db`.`comment` (`Audiobook_Id`, `User_Id`, `Text`, `send_date_time`) VALUES ('1', '1', 'qwe3', '2021.04.20');
