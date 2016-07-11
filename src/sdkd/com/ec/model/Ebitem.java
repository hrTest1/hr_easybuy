package sdkd.com.ec.model;

/**
 * Created by canhe on 2016/7/9.
 */
public class Ebitem {
    private EbProduct product;
    private int number;
    private double productprice;
    public Ebitem(EbProduct product,int number){
        this.product = product;
        this.number = number;
        this.productprice = product.getEp_price()*number;
    }

    public EbProduct getProduct() {
        return product;
    }
    public void setProduct(EbProduct product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public double getProductprice() {
        return productprice;
    }
    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

}
