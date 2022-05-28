//User

DROP TABLE Food_Ordering_App_User_Register_Form;
CREATE TABLE Food_Ordering_App_User_Register_Form(
	S_N0 INT AUTO_INCREMENT PRIMARY KEY,
	Full_name VARCHAR(100) NOT NULL,
	Email VARCHAR(100) NOT NULL UNIQUE,
	Contact_number BIGINT  NOT NULL UNIQUE,
	Create_Password VARCHAR(100) NOT NULL,
	Conform_Password VARCHAR(100) NOT NULL 
);


SELECT * FROM Food_Ordering_App_User_Register_Form;

INSERT INTO Food_Ordering_App_User_Register_Form(Full_name,Email,Contact_number,Create_Password,Conform_Password)
 VALUES("Kiruthika.V","kiru@gmail.com",7898908789,"kiru0192","kiru0192");
 INSERT INTO Food_Ordering_App_User_Register_Form(Full_name,Email,Contact_number,Create_Password,Conform_Password)
 VALUES("varun","varun@gmail.com",7898907643,"varun235","varun235");
  INSERT INTO Food_Ordering_App_User_Register_Form(Full_name,Email,Contact_number,Create_Password,Conform_Password)
 VALUES("Arun","arun01@gmail.com",7898907621,"arun035","arun035");
 
 DELETE FROM Food_Ordering_App_User_Register_Form WHERE Full_name='Ramya';

 TRUNCATE TABLE Food_Ordering_App_User_Register_Form;
 SELECT S_N0,Full_name,Email,Contact_number,Conform_Password FROM Food_Ordering_App_User_Register_Form;
 
 
 
 
 
 
 //Menu
 
 DROP TABLE Food_Ordering_App_Menus;
CREATE TABLE Food_Ordering_App_Menus(
	id INT AUTO_INCREMENT PRIMARY KEY,
	Veg_dishes VARCHAR(100) NOT NULL UNIQUE,
	Veg_Dishes_price INT NOT NULL,
	Non_Veg_dishes VARCHAR(100) NOT NULL UNIQUE,
	Non_Veg_dishes_price INT NOT NULL
);
INSERT INTO Food_Ordering_App_Menus (Veg_dishes,Veg_Dishes_price,Non_Veg_dishes,Non_Veg_dishes_price) 
VALUES ('Mini_dly_Sambar',40,'Chicken_65',80),
('Rava_Upma',40,'Chicken_Biryani',130),
('Dosa',25,'Mutton_Biryani',160),
('Rava_Idly',40,'Chicken_Liver_Masala',120),
('Jeera_Rice',50,'Chiken_Tikka_Masala',150),
('Chana_Masala',80,'Chicken_curry',70),
('Veg_Fried_rice',60,'Chilly_chicken',80);
INSERT INTO Food_Ordering_App_Menus (Veg_dishes,Veg_Dishes_price,Non_Veg_dishes,Non_Veg_dishes_price) 
VALUES ('veg _Kuruma',70,'Mutton_Kuruma',100);

TRUNCATE TABLE Food_Ordering_App_Menus;
SELECT Non_Veg_dishes,Non_Veg_dishes_price FROM Food_Ordering_App_Menus;
SELECT Veg_dishes,Veg_Dishes_price FROM Food_Ordering_App_Menus;
UPDATE Food_Ordering_App_Menus SET Veg_Dishes_price=100 WHERE Veg_dishes='Gobi Manchurian';
DELETE FROM Food_Ordering_App_Menus WHERE id=11;

SELECT * FROM Food_Ordering_App_Menus;

 SELECT Non_Veg_dishes,Non_Veg_dishes_price FROM Food_Ordering_App_Menus WHERE Non_Veg_dishes='Mutton Biryani';
 
 
 
 
 
 //admin login
 
 CREATE TABLE admin_Login(
id INT AUTO_INCREMENT PRIMARY KEY,
email VARCHAR(100) NOT NULL UNIQUE,
PASSWORD VARCHAR(100) NOT NULL
);
SELECT * FROM admin_Login;
INSERT INTO admin_Login(email,PASSWORD) VALUES('admin@gmail.com','admin');
SELECT email,PASSWORD FROM admin_Login WHERE email='admin@gmail.com';
DROP TABLE admin_Login;



//Transaction
CREATE TABLE Transactiion_Details(
	user_id INT NOT NULL,
	food_id INT NOT NULL,
	User_name VARCHAR(100) NOT NULL,
	payment_type INT NOT NULL,
	DATE DATE
);
DROP TABLE Transactiion_Details;
SELECT * FROM Transactiion_Details;

//Ordered food

CREATE TABLE Order_Food(
 food_id INT NOT NULL,
 user_id INT NOT NULL,
 Username VARCHAR(100) NOT NULL,
 User_address VARCHAR(100) NOT NULL,
 Ordered_food VARCHAR(100) NOT NULL,
 Bill_Amount INT NOT NULL
);
SELECT * FROM Order_Food;
DROP TABLE Order_Food;
TRUNCATE TABLE Order_Food;
SELECT SUM(Bill_Amount)  AS Total_Amount FROM Order_Food WHERE user_id=1;
SELECT COUNT(user_id) AS OrderedFood FROM Order_Food WHERE user_id=5;