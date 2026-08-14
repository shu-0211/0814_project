package view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

import controller.MouseController;
import model.dto.MouseDto;

public class MouseView {
    private MouseView(){}
    private static final MouseView instance = new MouseView();
    public static MouseView getInstance() {return instance;}

    private MouseController mc2 = MouseController.getInstance();
    private Scanner scanner = new Scanner(System.in,"EUC-KR");

    public void run(){
        while (true) {
            try {
                System.out.println("1.키보드 2. 마우스 3.모니터  4.종료");
                System.out.print("선택: ");
                int ch = scanner.nextInt();
                if (ch == 1) {
                    mouseMenu();
                } else if (ch == 2) {
                    KeyboardView.getInstance().Keyboardrun();
                } else if (ch == 3) {
                    MonitorView.getInstance().Monitorrun();
                } else if (ch == 4) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("다시 입력하세요" + e);
            }
            
        }
    }

    // 마우스 메뉴
    private void mouseMenu(){
        while (true) {
            System.out.println("[마우스관리] 1.마우스등록 2.마우스전체조회 3.마우스정보변경 4.마우스정보삭제 5. 뒤로가기");
            System.out.print("선택: ");
            int ch = scanner.nextInt();
            if (ch == 1) {
                mouseSave( );
            } else if (ch == 2) {
                mouseFindAll( );
            } else if (ch == 3) {
                mouseUpdate( );
            } else if (ch == 4) {
                mouseDelete( );
            } else if (ch == 5) {
                return;
            }
        }
    }

    public void mouseSave(){
        System.out.print("새로운 마우스 이름 입력: ");      String newName = scanner.next();
        System.out.print("가격 입력: ");                    int newPrice = scanner.nextInt();
        MouseDto mouseDto = new MouseDto(newName, newPrice);
        if (mc2.mouseSave(mouseDto)) {
            System.out.println("등록 성공");
        } else {
            System.out.println("등록 실패");
        }
    }

    public void mouseFindAll(){
        ArrayList<MouseDto> list = mc2.mouseFindAll();
        System.out.println("============마우스 목록============");
        if (list.isEmpty()) {
            System.out.println("등록된 마우스가 없습니다.");
            return;
        } 
        for(MouseDto dto : list){
            System.out.printf("%d  제품명: %s , 가격 %d", dto.getNo(), dto.getProductName(), dto.getProductPrice());
        }
    }

    public void mouseUpdate(){
        System.out.print("수정하려는 마우스 이름 입력: ");     String name = scanner.next();
        System.out.print("새로운 마우스 이름 입력: ");         String newName = scanner.next();
        System.out.print("변경할 가격 입력: ");                int newPrice = scanner.nextInt();
        boolean result = mc2.mouseUpdate(name, newName, newPrice);

        if (result) {
            System.out.println("수정 성공.");
        } else{
            System.out.println("수정 실패, 입력을 다시 확인하세요.");
        }
    }

    public void mouseDelete(){
        System.out.println("삭제하려는 마우스 이름 입력");     String delName = scanner.next();
        boolean result = mc2.mouseDelete(delName);

        if (result) {
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제하려는 마우스가 없습니다.");
        }
    }
}
