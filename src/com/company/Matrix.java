package com.company;

public class Matrix  {

    private int m_rows;

    private int m_columns;

    private char[][] m_matrix;

    public Matrix(int x, int y){
        m_matrix = new char[x][y];
        m_rows = x;
        m_columns = y;
    }

    public void fillMatrix(String[] inputString) {
        int k = 0;
        for (int i = 0; i < m_rows; i++) {
            for (int j = 0; j < m_columns; j++) {
                if(k == inputString[0].length())
                    k = 0;
                m_matrix[i][j] = inputString[i].charAt(k);
                k++;
            }
        }
    }

    public char[][] getM_matrix(){
        return m_matrix;
    }

    public int getRows(){
        return m_rows;
    }

    public int getColumns(){
        return m_columns;
    }

    public void setRows(int value){
        m_rows = value;
    }

    public void setColumns(int value){
        m_columns = value;
    }

    public void setElement(int i, int j, char value){
        m_matrix[i][j] = value;
    }
    public char getElement(int i, int j) {
        return m_matrix[i][j];
    }
}
