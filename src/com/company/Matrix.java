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
}
