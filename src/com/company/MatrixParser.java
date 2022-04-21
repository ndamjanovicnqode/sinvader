package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;

// Java Class to illustrate
// reading from text file
// as string in Java

public class MatrixParser {
    private Matrix m_matrix;
    private String file;
    private char[][] m_charArray;
    private int rowCount;
    private int columnCount;
    String[] split;
    public MatrixParser(String fileName) throws Exception {
        file = fileName;
        split = readFileAsString();
        System.out.println(split[0] + "\n" + split[1]+"\n" + split[2]);

        fillMatrix(split);

    }
    private String[] readFileAsString()throws Exception
    {
        String data = new String(Files.readAllBytes(Paths.get(file)));
        String[] split = data.split("\\n");
        this.rowCount = (int)Arrays.stream(split).count();
        this.columnCount = split[0].length();
        m_charArray = new char[rowCount][columnCount];
        System.out.println("rowCount" + rowCount + "columnCount" + columnCount);
        return split;
    }
    public void fillMatrix(String[] inputString) {
        int k = 0;
        //int n = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if(k == inputString[0].length())
                    k = 0;
                System.out.println("i: " + i + " j: " + j + " k: " + k);
                m_charArray[i][j] = inputString[i].charAt(k);
                k++;

            }
        }
    }

    public void printMatrix(){
        for (int i = 0; i < m_charArray.length; i++) {
            for (int j = 0; j < m_charArray[i].length; j++) {
                System.out.print(m_charArray[i][j]);
            }
            System.out.println(" ");
        }
    }
}
