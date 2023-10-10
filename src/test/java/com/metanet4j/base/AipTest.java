package com.metanet4j.base;

import com.google.common.base.Charsets;
import com.metanet4j.base.aip.AipHelper;
import java.nio.charset.Charset;
import org.junit.Test;

/**
 * @author 1haodev
 */
public class AipTest {


    /**
     * verifySign
     */
    @Test
    public void verifyStrMsg() {

        String message =
                "j1BAPSuaPnfGnSBM3GLV9yhxUdYe4vGbdMTIDc23e352cf4c220cc3da752073e85897bb4a46a90b92a360bc48d78f83f2320f816sgCjGK5G7rRmUonYTuyxzX9GbHaoXXAN|";
        String sig = "IJHat00dQG56uCYtnbG1M1qdJWxg2ZyI5jDrhsdJygXHHoqTeOPKSlcsSGwdaEip4lxyHufLgBBNPv1+ZxrEIo4=";

        boolean b = AipHelper.verifySign("1GEXzDk5dtmz7JVU9BqpqamcMqUcV1yARS", sig, message);
        boolean r = AipHelper.verifySign("1GEXzDk5dtmz7JVU9BqpqamcMqUcV1yARS", sig, message.getBytes(Charsets.UTF_8)
                );

        System.out.println(b);
        System.out.println(r);

    }

}
