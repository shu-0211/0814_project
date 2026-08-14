package day13.종합예제.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
    // 여러개 DAO 클래스들에게 JDBC연동 인스턴스 상속
    // 1. 연동 정보

    private String url = "jdbc:mysql://127.0.0.1:3306/mydb0814";
    private String user = "root";
    private String passward = "1234";

    // 2. 연동 인터페이스 , protected : 상속관계이면 다른패키지도 접근 혀용
    protected Connection conn;

    // 3.연동 메소드 
    private void connect(){

        try{
            // 3-1 : Driver (동적) z클래스 로드 한다. 
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3-2 : 데이터베이스 서버와 연동 후 성공하면 conn(인터페이스) 대입
            conn = DriverManager.getConnection(url, user, passward);
        }catch(Exception e ){System.out.println("DB연동 실패 " + e);}




    }  // connect() end

    protected BaseDao(){ connect();}


} // class end
