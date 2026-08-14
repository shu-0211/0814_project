package controller;

import java.util.ArrayList;

import model.dao.MouseDao;
import model.dto.MouseDto;

public class MouseController {
    private MouseController() {}
    private static final MouseController instance = new MouseController();
    public static MouseController getInstance() {return instance;}

    private MouseDao md2 = MouseDao.getInstance();

    public boolean mouseSave(MouseDto mouseDto){
        boolean result = md2.mouseSave(mouseDto);
        return result;
    }

    public ArrayList<MouseDto> mouseFindAll(){
        ArrayList<MouseDto> result = md2.mouseFindAll();
        return result;
    }

    public boolean mouseUpdate(String name, String newName, int newPrice){
        boolean result = md2.mouseUpdate(name, newName, newPrice);
        return result;
    }

    public boolean mouseDelete(String delName) {
        boolean result = md2.mouseDelete(delName);
        return result;
    }
}