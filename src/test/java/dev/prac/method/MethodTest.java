package dev.prac.method;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class MethodTest {

    @Test
    public void uuid테스트() throws Exception{
        //given
        UUID uuid = UUID.randomUUID();
        //when
        System.out.println("uuid = "+uuid);

        //then
    }

    @Test
    public void 랜덤문자열테스트() throws Exception{
        //given
        String s = "123"+ RandomStringUtils.randomAlphabetic(20);
        //when
        System.out.println("s = " +s );

    }


}
