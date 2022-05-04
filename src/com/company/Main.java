package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final char MATCHING_CHAR = 'o';

    public static void main(String[] args) throws Exception {

        System.out.println("Enter wanted search percentage: ");

        Scanner scanner = new Scanner(System.in);
        float requiredPercentage = 50.0f;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            if (line.equals("Q") || (line.equals("q"))) {
                scanner.close();
                System.err.println("Starting program with default percentage of 50 % ");
                break;
            }

            try {
                requiredPercentage = Float.parseFloat(line);
                break;
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number or Q to exit.");
            }
        }

        final String invaderALocation = args[0];
        MatrixParser parser = new MatrixParser(invaderALocation);
        Matrix invaderA = parser.getFilledMatrix();
        printMatrix(invaderA);

        final String inputLocation = args[1];
        //final String inputLocation = "/Users/nikoladamjanovic/IdeaProjects/sinvader/matrix_files/invaderTest";
        MatrixParser parserA = new MatrixParser(inputLocation);
        Matrix searchMatrix = parserA.getFilledMatrix();
        printMatrix(searchMatrix);

        processMatrix(invaderA, searchMatrix, requiredPercentage);
    }

    private static void processMatrix(Matrix invaderA, Matrix searchMatrix, final float requiredPercentage) {

        for (int i = 0; i < searchMatrix.getRows() - invaderA.getRows() + 1; i++) {
            for (int j = 0; j < searchMatrix.getColumns() - invaderA.getColumns() + 1; j++) {

                final List<Point> radarOnlyPoints = new ArrayList<>();

                int exactMatches = 0;
                int invaderOnly = 0;
                int searchOnly = 0;
                Result result;

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

                final int totalInvaders = invaderOnly + exactMatches;
                float percentage = 0;

                if (totalInvaders > 0) {
                    percentage = (exactMatches * 100.0f) / totalInvaders;
                }
                if (percentage > requiredPercentage) {
                    int noise = 0;
                    int junk = 0;
                    for (int count = 0; count < radarOnlyPoints.stream().count(); count++) {
                        if (isNoise(invaderA, radarOnlyPoints.get(count).getPointX(), radarOnlyPoints.get(count).getPointY())) {
                            noise++;
                        } else {
                            junk++;
                        }
                    }
                    result = new Result(String.format(" row: [%2d, %2d], column: [%2d, %2d]", i, i + invaderA.getColumns() - 1, j, j + invaderA.getRows() - 1), percentage, i, i + invaderA.getRows() - 1, j, j + invaderA.getColumns() - 1, noise, junk);
                    System.out.println(result.printResult());
                    break;
                }

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

    private static boolean isNoise(final Matrix invaderMatrix, final int x, final int y) {

        //Check if point is not located in last row of matrix
        if (x + 1 < invaderMatrix.getRows()) {
            //Check element below
            if (invaderMatrix.getElement(x + 1, y) == MATCHING_CHAR)
                return true;

            //Check element below right
            if (y + 1 < invaderMatrix.getColumns() && invaderMatrix.getElement(x + 1, y + 1) == MATCHING_CHAR)
                return true;

            //Check element below left
            if (y - 1 >= 0 && invaderMatrix.getElement(x + 1, y - 1) == MATCHING_CHAR)
                return true;
        }

        //Check if point is not located in first row of matrix
        if (x - 1 >= 0) {
            //Check element above
            if (invaderMatrix.getElement(x - 1, y) == MATCHING_CHAR)
                return true;

            //Check element above right
            if (y + 1 < invaderMatrix.getColumns() && invaderMatrix.getElement(x - 1, y + 1) == MATCHING_CHAR)
                return true;

            //Check element above left
            if (y - 1 >= 0 && invaderMatrix.getElement(x - 1, y - 1) == MATCHING_CHAR)
                return true;
        }

        //Check if point is not located in first column of matrix
        if (y - 1 >= 0) {
            //Check element left
            if (invaderMatrix.getElement(x, y - 1) == MATCHING_CHAR)
                return true;

            //Check element left bottom
            if (x + 1 < invaderMatrix.getRows() && invaderMatrix.getElement(x + 1, y - 1) == MATCHING_CHAR)
                return true;

            //Check element left top
            if (x - 1 >= 0 && invaderMatrix.getElement(x - 1, y - 1) == MATCHING_CHAR)
                return true;
        }

        //Check if point is not located in last column of matrix
        if (y + 1 < invaderMatrix.getColumns()) {
            //Check element right
            if (invaderMatrix.getElement(x, y + 1) == MATCHING_CHAR)
                return true;

            //Check element right bottom
            if (x + 1 < invaderMatrix.getRows() && invaderMatrix.getElement(x + 1, y + 1) == MATCHING_CHAR)
                return true;

            //Check element right top
            return x - 1 >= 0 && invaderMatrix.getElement(x - 1, y + 1) == MATCHING_CHAR;
        }

        return false;
    }
}
