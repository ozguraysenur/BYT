public interface Chain {

    public void next(Chain nextChain);
    public void calculate(Numbers request);
}
