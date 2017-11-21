package com.example.demo.test;

import java.io.IOException;
import java.util.*;

interface E{
    String doS() throws IOException;

}
class Employee implements E  {
public void ex(){


}

    @Override
    public String doS()  {
        return null;
    }
}
class Programmer extends Employee{
int i=10;

    @Override
    public void ex() {

    }
    public static int x;
    public static int foo(int y)
    {
        return y * 2;
    }
}

class Ex {
    public static void main(String args[]) {
        List<String> toDo=new ArrayList<>();
        toDo.add("dishes");
        toDo.add("laundry");
        toDo.add("bills");
        Integer i=10;
        assert (i>20):"hey assert";
        int z = 5;
        assert z > 0; /* Line 11 */
        assert z > 2: Programmer.foo(z); /* Line 12 */
        if ( z < 7 )
            assert z > 4; /* Line 14 */

        switch (z)
        {
            case 4: System.out.println("4 ");
            case 5: System.out.println("5 ");
            default: assert z < 10;
        }

        if ( z < 10 )
            assert z > 4: z++; /* Line 22 */
        System.out.println(z);


    }
}