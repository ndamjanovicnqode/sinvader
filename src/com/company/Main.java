package com.company;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final char MATCHING_CHAR = 'o';

    public static void main(String[] args) throws Exception {
        final String invaderALocation = args[0];
        MatrixParser parser = new MatrixParser(invaderALocation);
        char[][] invaderA = parser.getFilledMatrix();
        //printMatrix(invaderA);

        final String inputLocation = args[1];
        MatrixParser parserA = new MatrixParser(inputLocation);
        char[][] searchMatrix = parserA.getFilledMatrix();
        //printMatrix(searchMatrix);

        processMatrix(invaderA, searchMatrix);
    }

    private static void processMatrix(char[][] invaderA, char[][] searchMatrix) {
        List<Character> exactMatches = new ArrayList<Character>();
        List<Character> invaderOnly = new ArrayList<Character>();
        List<Character> searchOnly = new ArrayList<Character>();
        int totalInvaders = 0;

        for (int i = 0; i < searchMatrix.length - invaderA.length + 1; i ++) {
            for (int j = 0; j < searchMatrix[0].length - invaderA[0].length + 1; j++) {
                for (int k = 0; k < invaderA.length; k++) {
                    for (int p = 0; p < invaderA[0].length; p++) {

                        char invaderMatrixChar = invaderA[k][p];
                        char searchMatrixChar = searchMatrix[i + k][j + p];

                        if (searchMatrixChar == MATCHING_CHAR && invaderMatrixChar == MATCHING_CHAR){
                            exactMatches.add(searchMatrixChar);
                            totalInvaders++;
                        }else if (searchMatrixChar == MATCHING_CHAR) {
                            searchOnly.add(searchMatrixChar);;
                        } else if (invaderMatrixChar == MATCHING_CHAR) {
                            invaderOnly.add(invaderMatrixChar);
                        }
                    }
                }
                //totalInvaders = exactMatches.get(i);
                System.out.println(totalInvaders);
                float percentage = 0;

                if (totalInvaders > 0) {
                    percentage = (exactMatches.get(j) * 100.0f) / totalInvaders;
                }

                System.out.println(percentage);
                System.out.println(totalInvaders);
            }
        }

        System.out.println(totalInvaders);
    }

    private static void printMatrix(char[][] invaderA) {
        for (int i = 0; i < invaderA.length; i++) {
            for (int j = 0; j < invaderA[i].length; j++) {
                System.out.print(invaderA[i][j]);
            }
            System.out.println(" ");
        }
    }
}
