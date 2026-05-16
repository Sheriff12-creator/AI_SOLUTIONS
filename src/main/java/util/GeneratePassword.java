package util;

import util.PasswordUtil;

public class GeneratePassword {

    public static void main(String[] args) {

        String password = "Admin@2026";

        String hashed = PasswordUtil.hashPassword(password);

        System.out.println(hashed);
    }
}