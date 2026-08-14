package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.MonitorController;
import model.dto.MonitorDto;

public class MonitorView {

    private MonitorView(){} 
    private static final MonitorView instance = new MonitorView(); 
    public static MonitorView getInstance( ){ return instance; }
    
    // [*] MVC패턴 흐름의 controller 싱글톤 호출
    private MonitorController mc = MonitorController.getInstance();

      // [*] 입력객체
    private Scanner scan = new Scanner(System.in);

    public void Monitorrun(){
        while (true) {
            try{
                System.out.println("1. 등록 2. 전체조회 3. 개별수정 4. 개별삭제  5. 뒤로가기    선택 : ");
                int ch = scan.nextInt();
                if( ch ==1){ Monitorsave(); }
                else if(ch == 2){ MonitorfindAll(); }
                else if(ch == 3){ Monitorupdate(); }
                else if(ch == 4){ Monitordelete(); }
                else if(ch == 5){ break; }

            }catch( InputMismatchException e){
                // 입력 성공했지만 타입반환에서 예외이므로 입력 객체 초기화
                scan = new Scanner(System.in);        
                System.out.println("[다시입력]" + e);
            }
           
        } // 무한루프 종료

    } //  run() end

    public void Monitorsave (){
        System.out.print("내용 : "); String 상품명 = scan.next();   // 1.1 저장할 자료 입력하기 
        System.out.print("작성자 : "); int 가격 = scan.nextInt();
        MonitorDto monitorDto = new MonitorDto( 0, 상품명, 가격);  // 1.2 자료 객체화 하기 , no (아무거나/ 사용 x)


        // 컨트롤러에게 전달
        boolean result = mc.Monitorsave( monitorDto );
        if(result){System.out.println(">등록성공 ");}
        else{System.out.println(">등록실패");}
    
    } // msave() end

    // [2] 전체 조회 VIEW
    public void MonitorfindAll (){
        ArrayList<MonitorDto> result = mc.MonitorfindAll();       // 1. 컨트롤러에게 모든 게시물 정보 요청하고 받는다. 
        for( MonitorDto dto : result){  // 2. 반복문 이용하여 출력
            System.out.println(dto.getNo() + " / " + dto.getProductName() + " / " + dto.getProductPrice());
        }
    }

    // [3] 개별수정 VIEW 
    public void Monitorupdate (){
        System.out.print("수정할 번호 : "); int 수정할번호 = scan.nextInt();
        System.out.print("수정할 내용 : "); String 수정할이름 = scan.next();
        System.out.print("수정할 내용 : "); int 수정할가격 = scan.nextInt();
        MonitorDto boardDto = new MonitorDto(수정할번호, 수정할이름 , 수정할가격); // writer 사용안함.null
        boolean result = mc.Monitorupdate(boardDto);
        if(result) {System.out.println(">수정성공");}
        else{System.out.println(">수정 실패(없는 번호)");}
    }

    // [4] 개별삭제 VIEW
    public void Monitordelete (){
        System.out.print("삭제할번호 : "); int aaa = scan.nextInt();
        boolean result = mc.Monitordelete(aaa); // 매개변수가 1개이므로 dto 없이 
        if(result){System.out.println(">삭제성공");}
        else{System.out.println(">삭제 실패(없는 번호)");}
    }
}
