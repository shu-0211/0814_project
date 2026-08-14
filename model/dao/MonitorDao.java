package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.dao.BaseDao;
import model.dto.MonitorDto;

public class MonitorDao extends BaseDao{
    private MonitorDao (){}
    private static final MonitorDao instance = new MonitorDao();
    public static MonitorDao getInstance() { return instance; }

    // [1] 등록 DAO
    public boolean Monitorsave (MonitorDto monitorDto) {
        
        try{
            // 1.1. SQL 작성 , 값에 와일드카드(?) 이용한 매개변수 대입
            String sql = "insert into board(ProductName, ProductPrice) values( ? , ? )";

            // 1.2 연동된 데이터베이스에 SQL 기재 
            PreparedStatement ps =  conn.prepareStatement(sql); // conn 맴버변수는 BaseDao에게 물려받음
            
            // 1.3 기재된 SQL문법내 ?(와일드카드) 매개변수 값 대입, ps.set( ?번호 , 값);
            ps.setString(1,monitorDto.getProductName()); // 1(첫번째 ? ) 에 dto content 대입
            ps.setInt(2,monitorDto.getProductPrice()); // 2(두번째 ? ) 에 dto writer 대입

            // 1.4 기재된 SQL 실행 , .executeUpdate() insert/update/delete 에서 사용
            int result =  ps.executeUpdate();  // 실행 후 처리된 레코드 수 반환

            // 1.5 SQL 결과
            if(result == 1) return true; // 성공의미 


        }catch(SQLException e){ System.out.println(e);}

        // 1.5 SQL 결과
        return false; // 실패 의미를 갖는 false 반환
    
    } //  save() end

    // [2] 전체조회 DAO
    public ArrayList<MonitorDto> MonitorfindAll(){
        
        ArrayList<MonitorDto> list = new ArrayList<>();  // 2.7 레코드정보들을 담을 리스트
        try{
            // 2.1 SQL 작성
            String sql = "select * from Monitor";

            // 2.2 SQL을 기제한다. 
            PreparedStatement ps = conn.prepareStatement(sql);  //  예외 발생

            // 2.3 ?매개변수 대입한다.
            ResultSet rs = ps.executeQuery();  //  2.4 기재된 SQL 실행  .executeQuery() select
            
            // 2.5 SQL 결과 ( select 조회 결과는 항상 테이블로 반환한다. ) 즉] 레코드 하나씩 타입변환
            while (rs.next()) { // rs.next() : 다음 레코드(행) 이동 , 마지막 레코드까지 반복 뜻  // 레코드 수만큼반복
                // 2.6 현재 레코드 정보 --> DTO 변환
                MonitorDto monitorDto = new MonitorDto();
                monitorDto.setNo(rs.getInt("no")); // rs.get 타입 ("가져올속성명")
                monitorDto.setProductName(rs.getString("ProductName"));
                monitorDto.setProductPrice(rs.getInt("ProductPrice"));

                // 2.7 변환한 DTO --> 리스트에 담기 
                list.add(monitorDto); 

            }

        }catch( SQLException e){ System.out.println(e); }

        // 2.8 리스트 반환
        return list;

    } // findAll() end


    // [3] 개별수정 DAO
    public boolean Monitorupdate(MonitorDto monitorDto){
        
        try{
            String sql = "update Monitor set ProductName = ? , ProductPrice = ? where no = ? "; // 1.1 SQL 작성
            
            PreparedStatement ps = conn.prepareStatement(sql); // 1.2 SQL 기재 *예외*
            
            ps.setString(1, monitorDto.getProductName());// 1.3 SQL내 ? 매개변수대입
            ps.setInt(2, monitorDto.getProductPrice());
            ps.setInt(3, monitorDto.getNo());
            
            int result = ps.executeUpdate(); // 1.4 SQL 실행
            
            if(result == 1) return true; // 1.5 실행 결과 반환
        
        
        }catch(SQLException e){System.out.println(e);}
        
        return false;

    } // update( ) end


    // [4] 개별삭제 DAO  MonitorDto
    public boolean Monitordelete(int no ){
        try{
            String sql = "delete from Monitor where no = ?"; // 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, no);  // SQL 문법내 첫번째 ?에 매개변수 값 대입
            int result = ps.executeUpdate();

        if (result == 1)return true;

        }catch(SQLException e){System.out.println(e);}
        return false;
    }

}