public interface IMiddleMan {   //mediator
    void addFarmer(Client farmer);
    void addMarket(Client market);

    void buyFromFarmer(Client farmer);
    void sellToMarket(Client market);

}
