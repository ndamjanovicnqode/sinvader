package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final char MATCHING_CHAR = 'o';

    public static void main(String[] args) throws Exception {
        final String invaderALocation = args[0];
        MatrixParser parser = new MatrixParser(invaderALocation);
        Matrix invaderA = parser.getFilledMatrix();
        printMatrix(invaderA);

        final String inputLocation = args[1];
        MatrixParser parserA = new MatrixParser(inputLocation);
        Matrix searchMatrix = parserA.getFilledMatrix();
        printMatrix(searchMatrix);

        processMatrix(invaderA, searchMatrix, 50.0f);
    }

    private static void processMatrix(Matrix invaderA, Matrix searchMatrix, final float requiredPercentage) {

        for (int i = 0; i < searchMatrix.getRows() - invaderA.getRows() + 1; i++) {
            for (int j = 0; j < searchMatrix.getColumns() - invaderA.getColumns() + 1; j++) {

                final List<Point> radarOnlyPoints = new ArrayList<>();

                int exactMatches = 0;
                int invaderOnly = 0;
                int searchOnly = 0;

                for (int k = 0; k < invaderA.getRows(); k++) {
                    for (int p = 0; p < invaderA.getColumns(); p++) {

                        char invaderMatrixChar = invaderA.getElement(k, p);
                        char searchMatrixChar = searchMatrix.getElement(i + k, j + p);

                        if (searchMatrixChar == MATCHING_CHAR && invaderMatrixChar == MATCHING_CHAR) {
                            exactMatches++;
                        } else if (searchMatrixChar == MATCHING_CHAR) {
                            searchOnly++;
                            radarOnlyPoints.add(new Point(k, p));
                        } else if (invaderMatrixChar == MATCHING_CHAR) {
                            invaderOnly++;
                        }
                    }
                }

                System.out.println("invadercount: " + invaderOnly + "exactMatch: " + exactMatches + "Search only: " + searchOnly);
                final int totalInvaders = invaderOnly + exactMatches;
                System.out.println(totalInvaders);
                float percentage = 0;

                if (totalInvaders > 0) {
                    percentage = (exactMatches * 100.0f) / totalInvaders;
                } else if (percentage >= requiredPercentage) {

                }

                if (percentage > 50.0f) {
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("SIPAJ");
                    System.out.println("PE " + percentage);
                    break;
                }

                System.out.println(percentage);
                for(int count = 0; count < radarOnlyPoints.stream().count();count++)
                System.out.println("( x: " + radarOnlyPoints.get(count).getPoint().getPointX() + ", y: " + radarOnlyPoints.get(count).getPoint().getPointY() + ")");
            }
        }
    }

    private static void printMatrix(Matrix invaderA) {
        for (int i = 0; i < invaderA.getRows(); i++) {
            for (int j = 0; j < invaderA.getColumns(); j++) {
                System.out.print(invaderA.getElement(i, j));
            }
            System.out.println(" ");
        }
    }

    /*private boolean isNoise(final Matrix invaderMatrix, final int x, final int y) {

        //Check if point is not located in last row of matrix
        if (x + 1 < invaderMatrix.getRows()) {
            //Check element below
            if (invaderMatrix.getElement(x + 1,y)== MATCHING_CHAR)
                return true;

            //Check element below right
            if (y + 1 < invaderMatrix.getColumns() && invaderMatrix.getElements()[x + 1][y + 1] == MATCHING_CHAR)
                return true;

            //Check element below left
            if (y - 1 >= 0 && invaderMatrix.getElements()[x + 1][y - 1] == MATCHING_CHAR)
                return true;
        }

        //Check if point is not located in first row of matrix
        if (x - 1 >= 0) {
            //Check element above
            if (invaderMatrix.getElements()[x - 1][y] == MATCHING_CHAR)
                return true;

            //Check element above right
            if (y + 1 < invaderMatrix.getColumns() && invaderMatrix.getElements()[x - 1][y + 1] == MATCHING_CHAR)
                return true;

            //Check element above left
            if (y - 1 >= 0 && invaderMatrix.getElements()[x - 1][y - 1] == MATCHING_CHAR)
                return true;
        }

        //Check if point is not located in first column of matrix
        if (y - 1 >= 0) {
            //Check element left
            if (invaderMatrix.getElements()[x][y - 1] == MATCHING_CHAR)
                return true;

            //Check element left bottom
            if (x + 1 < invaderMatrix.getRows() && invaderMatrix.getElements()[x + 1][y - 1] == MATCHING_CHAR)
                return true;

            //Check element left top
            if (x - 1 >= 0 && invaderMatrix.getElements()[x - 1][y - 1] == MATCHING_CHAR)
                return true;
        }

        //Check if point is not located in last column of matrix
        if (y + 1 < invaderMatrix.getColumns()) {
            //Check element right
            if (invaderMatrix.getElements()[x][y + 1] == MATCHING_CHAR)
                return true;

            //Check element right bottom
            if (x + 1 < invaderMatrix.getRows() && invaderMatrix.getElements()[x + 1][y + 1] == MATCHING_CHAR)
                return true;

            //Check element right top
            if (x - 1 >= 0 && invaderMatrix.getElements()[x - 1][y + 1] == MATCHING_CHAR)
                return true;
        }

        return false;
    }*/
}
