package model.dto;


public class KeyboardDto {

    // 멤버변수
    private int no;
    private String productName;
    private int productPrice;

    // 기본 생성자
    public KeyboardDto() {}

    // 등록 생성자
    public KeyboardDto(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // 수정 생성자
    public KeyboardDto(int no, String productName, int productPrice) {
        this.no = no;
        this.productName = productName;
        this.productPrice = productPrice;
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() { 
        return "KeyboardDto [no=" + no
                + ", productName=" + productName
                + ", productPrice=" + productPrice + "]";
    }
} // class end