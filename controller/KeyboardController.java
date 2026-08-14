package controller;

import java.util.ArrayList;

import model.dao.KeyboardDao;
import model.dto.KeyboardDto;

public class KeyboardController {
    private KeyboardController( ) {}
    private static final KeyboardController instance = new KeyboardController();
    public static KeyboardController getInstance() {
        return instance;
    } // func end


    private KeyboardDao kd = KeyboardDao.getinstace();
    // 키보드 등록하기
    public boolean keyboardSave(KeyboardDto keyboardDto) {
        boolean result = kd.keyboardSave( keyboardDto);
        return result;
    }
      // 키보드 전체조회
    public ArrayList<KeyboardDto> keyboardFindAll() {
        ArrayList<KeyboardDto> result = kd.keyboardFindAll();
        return result;
    }
      // 키보드 정보수정
    public boolean keyboardUpdate(KeyboardDto keyboardDto) 
       { boolean result = kd.keyboardUpdate(keyboardDto);
        return result;}

        // 키보드 정보삭제
    public boolean keyboardDelete(int no) 
       {boolean result = kd.keyboardDelete(no);
        return result;}
   

} // class end