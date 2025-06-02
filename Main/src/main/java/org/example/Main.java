package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    double heightInCms =0.00;

    public static void main(String[] args) {
        System.out.println(convertToCentimeters(68));
        System.out.println(convertToCentimeters(5, 8));

    }


    public static double convertToCentimeters(int heightInInches){

        return heightInInches * 2.54;
    }
    public static double convertToCentimeters(int heightInFt, int heightInInches){

        return convertToCentimeters(heightInFt * 12 + heightInInches);
    }
}