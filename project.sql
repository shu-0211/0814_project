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
USE mydb0814;
CREATE TABLE Mouse( 
    no int AUTO_INCREMENT , 
    productName VARCHAR(30) ,
    productPrice INT ,
    constraint PRIMARY KEY( no ) 
);

insert into Mouse( productName, productPrice )values
    ("로지텍 G102 2세대", 25000),
    ( "레이저 데스에더 V3 프로", 230000),
    ("로지텍 MX Master 3S", 139000),
    ("삼성전자 무선 마우스 SM - B5100", 15000),
    ("앱코 해커 A600", 19800) ; 
