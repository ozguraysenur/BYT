import java.math.BigDecimal;

public class CMarket extends Client {  //concrete colleague
    public CMarket(String marketName, Product product, BigDecimal price, IMiddleMan middleMan) {
        super(marketName, product, price, middleMan);
    }
    public void BuyFromMiddleman(){
        getMiddleMan().sellToMarket(this);
    }
}
