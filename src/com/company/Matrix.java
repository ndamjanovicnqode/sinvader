package com.company;

public class Matrix {

    private int mRows;

    private int mColumns;

    private final char[][] mMatrix;

    public Matrix(int rows, int columns) {
        mMatrix = new char[rows][columns];
        mRows = rows;
        mColumns = columns;
    }

    public char[][] getM_matrix() {
        return mMatrix;
    }

    public int getRows() {
        return mRows;
    }

    public int getColumns() {
        return mColumns;
    }

    public void setRows(int value) {
        mRows = value;
    }

    public void setColumns(int value) {
        mColumns = value;
    }

    public void setElement(int i, int j, char value) {
        mMatrix[i][j] = value;
    }

    public char getElement(int i, int j) {
        return mMatrix[i][j];
    }
}
