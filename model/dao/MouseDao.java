package 종합예제.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import 종합예제.model.dto.MouseDto;

public class MouseDao extends BaseDao {
    private MouseDao() {}
    private static final MouseDao instance = new MouseDao();
    public static MouseDao getInstance() {return instance;}

    public boolean mouseSave(MouseDto mouseDto) {
        try {
            // SQL 작성 -> 마우스 레코드 하나 추가
            String sql = "insert into Mouse(productName, productPrice) values(?,?)";
            // 기재
            PreparedStatement ps = conn.prepareStatement(sql); //BaseDao에서 상속받음

            // ? 와일드카드에 마우스 이름, 가격 대입
            ps.setString(1, mouseDto.getProductName());
            ps.setInt(2, mouseDto.getProductPrice());

            int result = ps.executeUpdate(); // 실행 후 처리된 레코드 수 반환

            if (result == 1) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return false;
    }

    public ArrayList<MouseDto> mouseFindAll(){
        ArrayList<MouseDto> resultList = new ArrayList<>();
        try {
            // SQL문 작성 -> 마우스 전체 조회
            String sql = "select * from Mouse";

            // SQL문 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            // 기재된 SQL문 실행
            ResultSet rs = ps.executeQuery();

            //레코드 하나씩 받아오는 것을 새로운 dto 배열에 담기
            while (rs.next()) {
                // 현재 DB 정보를 하나하나씩 DTO로 변환
                MouseDto mouseDto = new MouseDto();
                mouseDto.setNo();
                mouseDto.setProductName();
                mouseDto.setProductPrice();

                // 변환한 dto를 배열에다 담기
                resultList.add(mouseDto);
            }
        } catch (SQLException e) {
            System.out.println( e );
        }

        return resultList;
    }

    public boolean mouseUpdate(String name, String newName, int newPrice){
        try {
            // sql 작성하기
            String sql = "update Mouse set productName = ?, productPrice = ? where productName = ?";

            // sql 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            // 와일드카드 - 매개변수 대입
            ps.setString(1, newName);
            ps.setInt(2, newPrice);
            ps.setString(3, name);

            int result = ps.executeUpdate(); // 실행

            if (result == 1) { //결과 반환 : 업데이트된 레코드 수가 1인가? 
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean mouseDelete(String delName){
        try {
            String sql = "delete from Mouse where productName = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, delName);

            int result = ps.executeUpdate();

            if (result == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println( e );
        }
        return false;
    }
}