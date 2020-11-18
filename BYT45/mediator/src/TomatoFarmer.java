import java.math.BigDecimal;

public class TomatoFarmer extends Client { //concrete colleague
    public TomatoFarmer(String name, BigDecimal price, IMiddleMan middleMan) {
        super(name, Product.TOMATO, price, middleMan);
    }

    public void sellToMiddleman(){
        getMiddleMan().buyFromFarmer(this);
    }
}
