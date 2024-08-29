package com.goriant.nova.ucm;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;

import java.util.Objects;

public class Test_String {
    public static void main(String[] args) {
//       String student1 ="Nguyen Van A";
//       String student2 ="Nguyen Van A";
//       String student3 =" Nguyen Van A";
//       String KQ = student3.trim();
//        System.out.println((student2==student1));
//        System.out.println((KQ==student1));
//        System.out.println((student2.equals(student1)));
//        System.out.println((KQ.equals(student1)));
//        System.out.println(String.valueOf(student1.hashCode()));

        String str1 = "ABC" ;
        String str2 ="ABC";
        String str3 =null;
        String str4 =null;
        if (str1.equals(str2)) System.out.println("String1 bằng String 2");
        else System.out.println("String 1 ko bằng String 2");

        System.out.println(String.valueOf(Objects.equals(str1,str2)));
        System.out.println(String.valueOf(Objects.equals(str1,str3)));
        System.out.println(String.valueOf(Objects.equals(str4,str3)));

    }

}
