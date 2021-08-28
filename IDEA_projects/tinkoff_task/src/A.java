class A {
    Double x = 2.0;


    public static void tripleX(A a) {
        a.x *= 3;
    }
    public static A reset(A a) {
        a = new A();
        System.out.println(a);
        return a;
    }

    public class B {

    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
        tripleX(a);
        reset(a);
        System.out.print(a.x);
    }
}