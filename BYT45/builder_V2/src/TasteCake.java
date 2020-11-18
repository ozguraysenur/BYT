public class TasteCake {
    public static void main(String[] args) {
        CakeBuilder chocolate =new ChocolateCake();
        CakeBuilder lemon =new LemonCake();

        Patisserie patisserie1= new Patisserie(chocolate);
        Patisserie patisserie2= new Patisserie(lemon);

        patisserie1.makeCake(chocolate);
        Cake chocoCake =patisserie1.getCake();
        System.out.println(chocoCake);


        patisserie2.makeCake(lemon);
        Cake lemonCake =patisserie2.getCake();
        System.out.println(lemonCake);

    }
}


//    prints :
//    CHOCOLATE Cake recipe {sugar='200g golden caster', egg=3, milk='2 tbsp', butter='200g', vanilla='1/2 tsp', flour='200g', bakingpowder='1 tsp', additional product=CHOCOLATE}
//    LEMON Cake recipe {sugar='200g brown sugar', egg=2, milk='3 tbsp', butter='100g', vanilla='1 tsp', flour='400g', bakingpowder='1 tsp', additional product=LEMON}