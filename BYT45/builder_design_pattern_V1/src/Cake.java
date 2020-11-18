public class Cake  { //product

    private String sugar;
    private int egg;
    private String milk;
    private String butter;
    private String vanilla;
    private String flour;
    private String bakingpowder;
    private CakeType caketype;
     public Cake(){

     }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public int getEgg() {
        return egg;
    }

    public void setEgg(int egg) {
        this.egg = egg;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getButter() {
        return butter;
    }

    public void setButter(String butter) {
        this.butter = butter;
    }

    public String getVanilla() {
        return vanilla;
    }

    public void setVanilla(String vanilla) {
        this.vanilla = vanilla;
    }

    public String getFlour() {
        return flour;
    }

    public void setFlour(String flour) {
        this.flour = flour;
    }

    public String getBakingpowder() {
        return bakingpowder;
    }

    public void setBakingpowder(String bakingpowder) {
        this.bakingpowder = bakingpowder;
    }

    public CakeType getCaketype() {
        return caketype;
    }

    public void setCaketype(CakeType caketype) {
        this.caketype = caketype;
    }

    @Override
    public String toString() {
        return caketype + " Cake recipe {" +
                "sugar='" + sugar + '\'' +
                ", egg=" + egg +
                ", milk='" + milk + '\'' +
                ", butter='" + butter + '\'' +
                ", vanilla='" + vanilla + '\'' +
                ", flour='" + flour + '\'' +
                ", bakingpowder='" + bakingpowder + '\'' +
                ", additional product=" + caketype +
                '}';
    }
}
