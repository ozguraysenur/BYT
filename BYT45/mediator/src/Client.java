import java.math.BigDecimal;

public abstract class Client { //colleague

    private String name;
    private Product product;
    private BigDecimal price;
    private IMiddleMan middleMan;

    public Client(String name, Product product, BigDecimal price, IMiddleMan middleMan) {
        this.name = name;
        this.product = product;
        this.price = price;
        this.middleMan = middleMan;
    }


    public String getName() {
        return name;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public IMiddleMan getMiddleMan() {
        return middleMan;
    }
}
