package com.valcon.videotechatodor.utils;

public class Regex {

    public static final String PASSWORD = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    public static final String USERNAME = "[A-Za-z0-9_]{3,21}$";

    public static final String EMAIL = "[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";

}
