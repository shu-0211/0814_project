package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.KeyboardController;
import model.dto.KeyboardDto;

public class KeyboardView {
 private KeyboardView( ) {}
    private static final KeyboardView instance = new KeyboardView();
    public static KeyboardView getInstance() {
        return instance;
} // func end

    Scanner scan = new Scanner(System.in);
    private KeyboardController kc = KeyboardController.getInstance();

    public void Keyboardrun(){ 

        for( ; ;) {
            System.out.println();
            System.out.println("키보드 관리");
            System.out.println("1. 키보드 등록" + "2. 키보드 전체 조회" + "키보드 정보 변경" + "키보드 정보 삭제" + "5. 뒤로가기");

            System.out.println("선택 : ");
            int 선택 = scan.nextInt();

            if ( 선택 == 1 )
            { keyboardSave();}

            else if ( 선택 == 2) 
            { keyboardFindAll();}

            else if ( 선택 == 3)
            {keyboardUpdate();}

            else if ( 선택 == 4)
            {keyboardDelete();}

            else if (선택 == 5)
            {break;} 
                 
            else { System.out.println("> 잘못된 입력입니다.");
            }
        }
    }



    // 키보드 등록
    public void keyboardSave() 

    {System.out.println(" 상품명 입력");
    String productName = scan.next();

    System.out.print("가격입력: ");
    int productPrice = scan.nextInt();

      // 객체화
        KeyboardDto keyboardDto
                = new KeyboardDto(productName, productPrice);


        boolean result = kc.keyboardSave(keyboardDto);


        // 4. 결과 출력
        if (result) 
            {System.out.println("> 상품정보 등록성공!");}
         else {System.out.println("> 상품정보 등록실패!");}


}
        public void keyboardFindAll() {
        ArrayList<KeyboardDto> result
                = kc.keyboardFindAll();
        
        System.out.println();
        System.out.println("번호\t상품명\t가격");

         for (KeyboardDto keyboardDto : result) {
            System.out.println(
                keyboardDto.getNo()
                + "\t"
                + keyboardDto.getProductName()
                + "\t"
                + keyboardDto.getProductPrice()
            );
        }
    
    }

    public void keyboardUpdate() {

        
        System.out.print("수정할 키보드 번호: ");
        int no = scan.nextInt();

        System.out.print("수정할 상품명: ");
        String productName = scan.next();

        System.out.print("수정할 가격: ");
        int productPrice = scan.nextInt();


        KeyboardDto keyboardDto
                = new KeyboardDto(no, productName, productPrice);


        boolean result
                = kc.keyboardUpdate(keyboardDto);


        if (result) {

            System.out.println("> 상품정보 수정성공!");

        } else 
            {System.out.println("> 해당 상품번호가 없습니다.");}
    }


     public void keyboardDelete() {

         System.out.print("삭제할 키보드 번호: ");
        int no = scan.nextInt();


         boolean result
                = kc.keyboardDelete(no);


        // 결과 출력
        if (result) {

            System.out.println("> 상품정보 삭제성공!");

        } else {

            System.out.println("> 해당 상품번호가 없습니다.");
        }
    }
}