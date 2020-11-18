public enum Product {

    TOMATO("Tomato"),
    POTATO("Potato");

    private String product;
    Product(String product){
        this.product=product;
    }

    public String getProduct() {
        return product;
    }
}
