drop DATABASE if EXISTS mydb0814;
create DATABASE mydb0814;
use mydb0814;

create table Monitor(
    no int AUTO_INCREMENT ,
    constraint PRIMARY KEY(no),
    productName VARCHAR(30),
    productPrice int
);
INSERT INTO Monitor(productName, productPrice) VALUES
('LG전자 32UN880', 700000),
('삼성전자 오디세이 G7', 850000),
('델 울트라샤프 U2720Q', 650000),
('벤큐 조위 XL2546K', 690000),
('알파스캔 AOC 24G2', 250000);