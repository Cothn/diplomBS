INSERT INTO `books_db`.`role` (`Title`) VALUES ('Admin');
INSERT INTO `books_db`.`role` (`Title`) VALUES ('User');
INSERT INTO `books_db`.`role` (`Title`) VALUES ('SuperAdmin');

INSERT INTO `books_db`.`user` (`Nickname`, `Password`, `Role_Id`) VALUES ('super_admin', '123', '3');

INSERT INTO `books_db`.`audiobook_file` (`Extension`, `File_path`) VALUES ('fb2', 'book.fb2');

INSERT INTO `books_db`.`audiobook` (`User_Id`, `Distributed`, `Title`, `Picture_Path`, `Publication_Year`, `Description`, `Add_Date`, `Audiobook_File_Id`) VALUES ('1', '1', 'one', 'pic.png', '2000', 'descript', '2021-04-21', '1');