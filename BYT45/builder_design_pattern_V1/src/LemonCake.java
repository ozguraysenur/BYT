public class LemonCake implements CakeBuilder { //concrete builder

    private Cake cake;

    public LemonCake(){
        this.cake =new Cake();
    }
    @Override
    public Cake getCake() {
        this.setEgg(2).setSugar("200g brown ")
                .setMilk("4 tbsp")
                .setButter("300g")
                .setvanilla("1 tsp")
                .setbakingpowder("1/2 tsp ")
                .setflour("150g")
                .setAdditional();
        return cake;
    }

    @Override
    public CakeBuilder setSugar(String sugar) {
        cake.setSugar(sugar);
        return this;
    }

    @Override
    public CakeBuilder setEgg(int egg) {
        cake.setEgg(egg);
        return this;
    }

    @Override
    public CakeBuilder setMilk(String milk) {
        cake.setMilk(milk);
        return this;
    }

    @Override
    public CakeBuilder setButter(String butter) {
        cake.setButter(butter);
        return this;
    }

    @Override
    public CakeBuilder setvanilla(String vanilla) {
        cake.setVanilla(vanilla);
        return this;
    }

    @Override
    public CakeBuilder setflour(String flour) {
        cake.setFlour(flour);
        return this;
    }

    @Override
    public CakeBuilder setbakingpowder(String bpowder) {
        cake.setBakingpowder(bpowder);
        return this;
    }

    @Override
    public CakeBuilder setAdditional() {
        cake.setCaketype(CakeType.LEMON);
        return this;
    }
}
