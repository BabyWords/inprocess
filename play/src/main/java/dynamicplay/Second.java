package dynamicplay;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Second {

    class GrandFather {
        void thinking() {
            System.out.println("grand father");
        }
    }

    class Father extends GrandFather {
        void thinking() {
            System.out.println("grand father");
        }
    }

    class Son extends Father {
        void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);

//                MethodHandle mh = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass()).bindTo(this);
//                mh.invoke();
            } catch (Throwable e) {

            }
        }
    }

    public static void main(String args[]){
        (new Second().new Son()).thinking();
    }
}
