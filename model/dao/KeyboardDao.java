package model.dao;
import java.util.ArrayList;
import model.dto.KeyboardDto;

public class KeyboardDao{

    private KeyboardDao () {}
    private static final KeyboardDao instance = new KeyboardDao();
    public static KeyboardDao getinstace() { return instance;}
    private ArrayList<KeyboardDto> KeyboardList = new ArrayList<>();
    private int no = 1;


      // [1] 키보드 등록
    public boolean keyboardSave(KeyboardDto keyboardDto)
     {
        keyboardDto.setNo(no);
        no++;
        KeyboardList.add(keyboardDto);
        return true;
    }

   // [2] 키보드 전체 조회
    public ArrayList<KeyboardDto> keyboardFindAll() {
        return KeyboardList;
    }
 // [3] 키보드 정보 수정
    public boolean keyboardUpdate(KeyboardDto keyboardDto) {
        for (KeyboardDto dto : KeyboardList) {
        if (dto.getNo() == keyboardDto.getNo()) {
        dto.setProductName(keyboardDto.getProductName());
        dto.setProductPrice(keyboardDto.getProductPrice());
                return true;
            }
        }
        return false;
    }

    // [4] 키보드 정보 삭제
    public boolean keyboardDelete(int no) {
        for (int index = 0; index < KeyboardList.size(); index++)
             {KeyboardDto dto = KeyboardList.get(index);
            if (dto.getNo() == no) {
            KeyboardList.remove(index);
            return true;
            }
        }

        return false;
    }
} // class end
