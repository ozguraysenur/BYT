public class Test {
    static Chain add = new Add();
    static Chain sub = new Subtract();
    static Chain mult = new Multiply();
    static Chain div = new Divide();

    public static void main(String[] args) {
        add.next(sub);
        sub.next(mult);
        mult.next(div);

        calculator(3,4,"*");
        calculator(6,3,"/");
        calculator(10,7,"+");
        calculator(11,5,"-");
        calculator(2,2,"^");


    }

    public static void calculator(int  num1 ,int num2, String oper){
        Numbers req= new Numbers(num1,num2,oper);

        add.calculate(req);  //chain is starting from the add operation
    }
}


//  prints :
//     3 * 4 = 12
//     6 / 3 = 2
//     10 + 7 = 17
//     11 - 5 = 6
//     this calculator can only add, subtract, multiply and divide.
