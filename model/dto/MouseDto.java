package 종합예제.model.dto;

public class MouseDto {
    private int no;
    private String productName;
    private int productPrice;
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
        return "MouseDto [no=" + no + ", productName=" + productName + ", productPrice=" + productPrice + "]";
    }
}