package com.company;

import java.nio.file.*;
import java.util.Arrays;

public class MatrixParser {

    private String fileName;
    private Matrix mMatrix;
    private int rowCount;
    private int columnCount;
    private String[] split;

    public MatrixParser(String fileName) throws Exception {
        this.fileName = fileName;
        split = readFileAsString();
        fillMatrix(split);
    }

    private String[] readFileAsString() throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(this.fileName)));
        String[] split = data.split("\\n");
        this.rowCount = (int) Arrays.stream(split).count();
        this.columnCount = split[0].length();
        mMatrix = new Matrix(rowCount, columnCount);
        return split;
    }

    public void fillMatrix(String[] inputString) {
        int k = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (k == inputString[0].length())
                    k = 0;
                mMatrix.setElement(i, j, inputString[i].charAt(k));
                k++;
            }
        }
    }

    public Matrix getFilledMatrix() {
        return mMatrix;
    }

    public void printMatrix() {
        for (int i = 0; i < mMatrix.getRows(); i++) {
            for (int j = 0; j < mMatrix.getColumns(); j++) {
                System.out.print(mMatrix.getElement(i, j));
            }
            System.out.println(" ");
        }
    }
}
