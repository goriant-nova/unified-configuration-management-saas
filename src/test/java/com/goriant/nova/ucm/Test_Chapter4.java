package com.goriant.nova.ucm;

public class Test_Chapter4 {
    public static void main(String[] args) {
        //Example 1: Step-by-Step Execution Without Method Chaining
        var start = "AniMaL ";
        var trimmed = start.trim();              // "AniMaL"
        var lowercase = trimmed.toLowerCase();   // "animal"
        var result = lowercase.replace('a', 'A');// "AnimAl"
        System.out.println(result);              // In ra: AnimAl
        // Using Method chaning
        result = "AniMaL ".trim().toLowerCase().replace('a', 'A');
        System.out.println(result); // In ra: AnimAl
        //Example to Analyze
        String a = "abc";
        String b = a.toUpperCase();              // b = "ABC"
        b = b.replace("B", "2").replace('C', '3'); // b = "A23"
        System.out.println("a=" + a);            // Outputs: a=abc
        System.out.println("b=" + b);            // Outputs: b=A23
        //String Example:
        String alpha = "";
        for (char current = 'a'; current <= 'z'; current++) {
            alpha += current;
            System.out.println(alpha);
        }

        //StringBuilder Example
        StringBuilder alpha1 = new StringBuilder();
        for (char current = 'a'; current <= 'z'; current++) {
            alpha1.append(current);
            System.out.println(alpha1);
        }
        char kytu = 'a';
        System.out.println(String.valueOf(kytu));
        // StringBuilder with Method chaning
        StringBuilder a1 = new StringBuilder("abc");
        StringBuilder b1 = a1.append("de");
        b1 = b1.append("f").append("g");
        System.out.println("a=" + a1);
        System.out.println("b=" + b1);
        // khi dùng tới String
        String a2="abc";
        String b2= a2+"de";
        b2=b2+'f'+'g';
        System.out.println("a="+a2);
        System.out.println("b="+b2);

        var builder1 = new StringBuilder("abc");
        var builder2 = new StringBuilder("abc");

        System.out.println(builder1.equals(builder2)); // false

        Integer aa = 9;
        int bb = 9;
        // long char byte boolean float double short int





    }
}
