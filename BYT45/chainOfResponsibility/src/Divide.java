public class Divide implements Chain {

    private Chain next;

    @Override
    public void next(Chain nextChain) {
        this.next = nextChain;
    }

    @Override
    public void calculate(Numbers request) {
        if (request.getOperation() == "/") {
            System.out.println(request.getNumber1() + " / " + request.getNumber2() + " = "
                    + (request.getNumber1() / request.getNumber2()));
        } else {
            System.out.println("this calculator can only add, subtract, multiply and divide.");
        }
    }
}