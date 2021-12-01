import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

class A {
    @NotNull
    Double x = 2.0;

    public static void tripleX(A a) throws Exception {
        a.x *= 3;
        throw new Exception("exc");
    }

    public static @NotNull A reset(A a) {
        a = new A();
        System.out.println(a);
        return a;
    }

    @Nullable
    public static Integer kek() {
        int a = 5;
        return a > 7 ? 1 : null;
    }

    public class B {
        Collection<String> col = new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        A a = new A();
        System.out.println(a);
        tripleX(a);
        reset(a);
        System.out.print(a.x);
    }
}