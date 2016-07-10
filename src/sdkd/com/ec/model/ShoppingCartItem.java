package sdkd.com.ec.model;

/**
 * Created by sdust on 2016/7/8.
 */
public class ShoppingCartItem {
    private EbProduct product;
    private Long quantity;
    private  Double cost;

    public ShoppingCartItem()
    {

    }
    public ShoppingCartItem(EbProduct product,Long quantity) {
        this.product=product;
        this.quantity=quantity;
        this.cost=product.getEp_price()*quantity;
    }

    public EbProduct getProduct() {

        return product;
    }

    public void setProduct(EbProduct product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
        this.cost=product.getEp_price()*quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
