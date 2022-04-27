package com.company;

public class Matrix  {

    private int mRows;

    private int mColumns;

    private char[][] mMatrix;

    public Matrix(int x, int y){
        mMatrix = new char[x][y];
        mRows = x;
        mColumns = y;
    }

    public void fillMatrix(String[] inputString) {
        int k = 0;
        for (int i = 0; i < mRows; i++) {
            for (int j = 0; j < mColumns; j++) {
                if(k == inputString[0].length())
                    k = 0;
                mMatrix[i][j] = inputString[i].charAt(k);
                k++;
            }
        }
    }

    public char[][] getM_matrix(){
        return mMatrix;
    }

    public int getRows(){
        return mRows;
    }

    public int getColumns(){
        return mColumns;
    }

    public void setRows(int value){
        mRows = value;
    }

    public void setColumns(int value){
        mColumns = value;
    }

    public void setElement(int i, int j, char value){
        mMatrix[i][j] = value;
    }
    public char getElement(int i, int j) {
        return mMatrix[i][j];
    }
}
