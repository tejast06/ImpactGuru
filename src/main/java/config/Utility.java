package config;

import org.apache.commons.lang3.RandomStringUtils;

public class Utility {

    public static void main(String[] args){
        String randomString = RandomStringUtils.randomAlphabetic(8);
        System.out.println(randomString+"@gmail.com");
    }


}
