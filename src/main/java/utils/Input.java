package utils;

import java.util.Scanner;

import static utils.Print.print;

public class Input {
    public static final Scanner SCANNER_NUM = new Scanner(System.in);
    public static final Scanner SCANNER_STR = new Scanner(System.in);

    public static Integer getNum() {
        return getNum("");
    }

    public static Integer getNum(String str) {
        print(str);
        return SCANNER_NUM.nextInt();
    }

    public static String getStr() {
        return getStr("");
    }

    public static String getStr(String str) {
        print(str);
        return SCANNER_STR.nextLine();
    }
    public static double getDouble(String str) {
        print(str);
        return SCANNER_NUM.nextDouble();
    }
}
