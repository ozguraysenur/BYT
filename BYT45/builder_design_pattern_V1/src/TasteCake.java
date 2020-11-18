public class TasteCake {

    public static void main(String[] args) {
        CakeBuilder chocolate =new ChocolateCake();
        CakeBuilder lemon =new LemonCake();

        Patisserie patisserie1= new Patisserie(chocolate);
        Patisserie patisserie2= new Patisserie(lemon);

        Cake chocoCake =patisserie1.bake();
        System.out.println(chocoCake);

        Cake lemoncake=patisserie2.bake();
        System.out.println(lemoncake);


    }
}

//  prints:
//  CHOCOLATE Cake recipe {sugar='200g golden caster', egg=3, milk='2 tbsp', butter='200g', vanilla='1/2 tsp', flour='200g', bakingpowder='1 tsp ', additional product=CHOCOLATE}
//  LEMON Cake recipe {sugar='200g brown ', egg=2, milk='4 tbsp', butter='300g', vanilla='1 tsp', flour='150g', bakingpowder='1/2 tsp ', additional product=LEMON}