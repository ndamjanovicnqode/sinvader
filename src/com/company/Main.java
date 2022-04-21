package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
       /* Matrix spaceInvaderA = new Matrix(11,8);
        char[][] invaderA = spaceInvaderA.getM_matrix();*/
        String invaderALocation = "/Users/nikoladamjanovic/Downloads/invaderA";
        MatrixParser parser = new MatrixParser(invaderALocation);
        parser.printMatrix();
        //String invaderA = parser.readFileAsString();
        //System.out.println(invaderA);


    }
}
