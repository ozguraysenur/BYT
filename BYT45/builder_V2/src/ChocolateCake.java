public class ChocolateCake implements CakeBuilder{ //concrete builder

    private Cake cake;

    public ChocolateCake(){
        this.cake =new Cake();
    }
    @Override
    public void AddSugar() {
        cake.setSugar("200g golden caster");
    }

    @Override
    public void AddEgg() {
        cake.setEgg(3);
    }

    @Override
    public void AddMilk() {
        cake.setMilk("2 tbsp");
    }

    @Override
    public void AddButter() {
        cake.setButter("200g");
    }

    @Override
    public void Addvanilla() {
        cake.setVanilla("1/2 tsp");
    }

    @Override
    public void Addflour() {
        cake.setFlour("200g");
    }

    @Override
    public void Addbakingpowder() {
        cake.setBakingpowder("1 tsp");
    }

    @Override
    public void AddAdditional() {
        cake.setCaketype(CakeType.CHOCOLATE);
    }

    @Override
    public Cake getCake() {
        return this.cake;
    }

}
