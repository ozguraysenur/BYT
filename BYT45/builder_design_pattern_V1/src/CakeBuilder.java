public interface CakeBuilder {

    Cake getCake();
    CakeBuilder setSugar(String sugar);
    CakeBuilder setEgg(int egg);
    CakeBuilder setMilk(String milk);
    CakeBuilder setButter(String butter);
    CakeBuilder setvanilla(String vanilla);
    CakeBuilder setflour(String flour);
    CakeBuilder setbakingpowder(String bpowder);
    CakeBuilder setAdditional();
}
