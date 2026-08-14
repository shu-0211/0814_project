package 종합예제.controller;

import java.util.ArrayList;

import 종합예제.model.dao.MouseDao;
import 종합예제.model.dto.MouseDto;

public class MouseController {
    private MouseController() {}
    private static final MouseController instance = new MouseController();
    public static MouseController getInstance() {return instance;}

    private MouseDao md = MouseDao.getInstance();

    public boolean mouseSave(MouseDto mouseDto){
        boolean result = md.mouseSave(mouseDto);
        return result;
    }

    public ArrayList<MouseDto> mouseFindAll(){
        ArrayList<MouseDto> result = md.mouseFindAll();
        return result;
    }

    public boolean mouseUpdate(String name, String newName, int newPrice){
        boolean result = md.mouseUpdate(name, newName, newPrice);
        return result;
    }

    public boolean mouseDelete(String delName) {
        boolean result = md.mouseDelete(delName);
        return result;
    }
}