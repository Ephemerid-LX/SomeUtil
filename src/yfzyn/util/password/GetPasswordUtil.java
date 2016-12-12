package yfzyn.util.password;

import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yfzyn on 12/12/2016.
 */
public class GetPasswordUtil {


    /**
     * 获取一个密码字符串，
     * 密码所使用的字符集存储在String数组中。
     * @return 指定长度的字符串密码
     */
    public static String getPasswordUsingStringArray(){
        final char[] pwCharPool = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','s','x','y','z',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                '1','2','3','4','5','6','7','8','9','0',
                '-','_','=','+'};
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the password's length:");
        Integer pwLength;
        while (true) {
            String input = scanner.nextLine();
            String regex = "exit";
            Matcher matcher = Pattern.compile(regex, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE).matcher(input);
            if(matcher.matches())
                System.exit(0);

            try {
                pwLength = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("input is not a number, please input again:");
                continue;
            }

            if(pwLength < 6){
                System.out.println("too short to create,please input again:");
                continue;
            }else if(pwLength > 16) {
                System.out.println("too long to create, please input again:");
                continue;
            }else{
                break;
            }
        }
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for(int i=0; i<pwLength; i++){
            password.append(pwCharPool[random.nextInt(pwCharPool.length)]);
        }
        return password.toString();
    }
}
