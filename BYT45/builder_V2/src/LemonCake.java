public class LemonCake implements CakeBuilder{ //concrete builder
    private Cake cake;

    public LemonCake(){
        this.cake =new Cake();
    }
    @Override
    public void AddSugar() {
        cake.setSugar("200g brown sugar");
    }

    @Override
    public void AddEgg() {
        cake.setEgg(2);
    }

    @Override
    public void AddMilk() {
        cake.setMilk("3 tbsp");
    }

    @Override
    public void AddButter() {
        cake.setButter("100g");
    }

    @Override
    public void Addvanilla() {
        cake.setVanilla("1 tsp");
    }

    @Override
    public void Addflour() {
        cake.setFlour("400g");
    }

    @Override
    public void Addbakingpowder() {
        cake.setBakingpowder("1 tsp");
    }

    @Override
    public void AddAdditional() {
        cake.setCaketype(CakeType.LEMON);
    }

    @Override
    public Cake getCake() {
        return this.cake;
    }
}
