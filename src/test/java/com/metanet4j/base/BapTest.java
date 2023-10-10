package com.metanet4j.base;

import com.metanet4j.base.bap.BapHelper;
import org.junit.Test;

/**
 * @author 1haodev
 */
public class BapTest {

    @Test
    public void testBap(){
        boolean b = BapHelper
                .isRootAddress("1WffojxvgpQBmUTigoss7VUdfN45JiiRK", "3SyWUZXvhidNcEHbAC3HkBnKoD2Q");
        System.out.println(b);
    }
}
