package model.dto;

public class MonitorDto {
    private int no;
    private String productName;
    private int productPrice;

    // 2. 기본생성자, 전체 매개변수 생성자
    public MonitorDto( ){}
    public MonitorDto ( int no , String productName, int productPrice ){
        this.no = no;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // getter and setter , toString
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
        return "MonitorDto [no=" + no + ", productName=" + productName + ", productPrice=" + productPrice + "]";
    }
    

}