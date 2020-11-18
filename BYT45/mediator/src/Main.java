import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {


        IMiddleMan mediator = new CMiddleMan();
        TomatoFarmer fHuseyin = new TomatoFarmer("Huseyin", BigDecimal.valueOf(4),mediator);
        TomatoFarmer fIsmail = new TomatoFarmer("Ismail", BigDecimal.valueOf(3),mediator);

        CMarket biedronka = new CMarket("Biedronka",Product.TOMATO,BigDecimal.valueOf(5),mediator);
        CMarket lidl = new CMarket("Lidl",Product.TOMATO,BigDecimal.valueOf(7),mediator);

        mediator.addFarmer(fHuseyin);
        mediator.addFarmer(fIsmail);

        mediator.addMarket(biedronka);
        mediator.addMarket(lidl);

        fHuseyin.sellToMiddleman();
        lidl.BuyFromMiddleman();
        fIsmail.sellToMiddleman();
        biedronka.BuyFromMiddleman();


       /*
       prints :
        Huseyin's sold Tomato to the Lidl
        Ismail's sold Tomato to the Lidl
        Ismail's sold Tomato to the Lidl
        Ismail's sold Tomato to the Biedronka
       */


    }

}