package repl;

import org.junit.Test;

/**
 * Created by hanmomhanda on 2016-02-20.
 */
public class REPL {

    @Test
    public void varArgs() throws Exception {
        class Temp {
            public void testVarObjs(String base, Object... args) {
                String result = "";
                for (int i = 0, len = args.length ; i < len ; i++) {
                    result = base + args[i];
                    System.out.println(result);
                }
            }
        }

        Temp temp = new Temp();
        temp.testVarObjs("BASE");
        System.out.println("------------");
        temp.testVarObjs("BASE", 1);
        System.out.println("------------");
        temp.testVarObjs("BASE", 1, 2, 3);
    }
}
