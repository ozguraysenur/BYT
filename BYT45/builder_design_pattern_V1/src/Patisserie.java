public class Patisserie { //director
    private CakeBuilder cakeBuilder;

    public Patisserie(CakeBuilder cakeBuilder){
        this.cakeBuilder=cakeBuilder;
    }
    public Cake bake(){
        return cakeBuilder.getCake();
    }

}
