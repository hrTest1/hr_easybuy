package sdkd.com.ec.model;

/**
 * Created by sdust on 2016/7/8.
 */
public class ShoppingCartItem {
    private EbProduct product;
    private long quantity;
    private  double cost;

    public ShoppingCartItem(EbProduct product,long quantity) {
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

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
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
