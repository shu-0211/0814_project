package controller;

import java.util.ArrayList;

import model.dao.MonitorDao;
import model.dto.MonitorDto;

public class MonitorController {
    private MonitorController(){}
    private static final MonitorController instance = new MonitorController();
    public static MonitorController getInstance(){return instance;}

    private MonitorDao md = MonitorDao.getInstance();

    // [1] 등록 Controller
    public boolean Monitorsave( MonitorDto monitorDto ){
        boolean result = md.Monitorsave(monitorDto);  // view에게 전달받은 매개변수를 dao에게 반환
        return result;  // dao 받은 결과 view 반환
    }

    // [2] 전체조회 Controller
    public ArrayList<MonitorDto> MonitorfindAll(){
        ArrayList<MonitorDto> result = md.MonitorfindAll();
        return result;
    } 

    // [3] 개별수정 Controller
    public boolean Monitorupdate(MonitorDto monitorDto){
        return md.Monitorupdate( monitorDto );
    }

    // [4] 개별삭제 
    public boolean Monitordelete(int no){
        return md.Monitordelete(no);
    }

}