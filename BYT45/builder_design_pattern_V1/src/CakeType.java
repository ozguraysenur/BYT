public enum CakeType {

    CHOCOLATE("chocolate"),
    APPLE("Apple"),
    LEMON("Lemon"),
    CLASSIC("Classic");

    private String cake;
    CakeType(String cake){
        this.cake=cake;
    }

    public String getCake() {
        return cake;
    }
}
