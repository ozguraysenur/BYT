import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CMiddleMan implements IMiddleMan {  //concrete mediator

    private List<Client> farmerList;
    private List<Client> marketList;

    public CMiddleMan() {
        farmerList = new ArrayList<>();
        marketList = new ArrayList<>();
    }

    @Override
    public void addFarmer(Client farmer) {
        farmerList.add(farmer);
    }

    @Override
    public void addMarket(Client market) {
        marketList.add(market);
    }

    @Override
    public void buyFromFarmer(Client farmer) {
        Client market= findExpensiveMarket(farmer.getProduct());
        sell(farmer, market);
    }


    @Override
    public void sellToMarket(Client market) {
        Client farmer= findCheapestFarmer(market.getProduct());
        sell(farmer,market);
    }

    private Client findCheapestFarmer(Product product){
        Client f= null;
        for (Client farmer : farmerList){
            if(product.equals(farmer.getProduct())){
                BigDecimal price =farmer.getPrice();

                if(f == null || f.getPrice().compareTo(price)> 0 ){
                    f=farmer;
                }

            }
        }

        return f;
    }
    private Client findExpensiveMarket(Product product){
        Client m= null;
        for (Client market : marketList){
            if(product.equals(market.getProduct())){
                BigDecimal price =market.getPrice();

                if(m == null || m.getPrice().compareTo(price)< 0 ){
                    m=market;
                }

            }
        }

        return m;
    }


    private void sell(Client farmer, Client market) {
        System.out.println(farmer.getName()+ "'s sold "+farmer.getProduct().getProduct() +" to the "+ market.getName());
    }
}
