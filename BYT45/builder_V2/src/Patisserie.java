public class Patisserie {  //director
    private CakeBuilder cakeBuilder;

    public Patisserie(CakeBuilder cakeBuilder){
        this.cakeBuilder=cakeBuilder;
    }

    public Cake getCake(){
        return  this.cakeBuilder.getCake();
    }
    public void makeCake(CakeBuilder cakeBuilder){

        this.cakeBuilder.AddEgg();
        this.cakeBuilder.AddSugar();
        this.cakeBuilder.AddButter();
        this.cakeBuilder.AddMilk();
        this.cakeBuilder.Addvanilla();
        this.cakeBuilder.Addbakingpowder();
        this.cakeBuilder.Addflour();
        this.cakeBuilder.AddAdditional();
    }
}
