package com.blovvme.photoncodechallenge.view;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Blovvme on 1/23/18.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    private static final String TAG = "Presenter";
    MainActivityContract.View view;
    ArrayList<Integer> pathwayLocation = new ArrayList<>();
    int columnCounter = 0;

    @Override
    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    public int getInitialMinValueLocationFirstRow(int[][] cost) {

        int minValue = cost[0][0];
        int initialMinValueLocation = 0;
        for (int i = 0; i < cost.length; i++) {
            if (cost[i][0] < minValue) {
                initialMinValueLocation = i;
                minValue = cost[i][0];
            }
        }
        pathwayLocation.add(initialMinValueLocation + 1);
        return initialMinValueLocation;
    }

    private void findPath(int[][] cost, int currentRow, int currentColumn, int currentLowestCost) {
        int upCost = 0, upRightCost = 0, rightCost = 0, downRightCost = 0, downCost = 0;
        String criteriaStatus = "TES";
        int testingLowestCost = currentLowestCost;
        int testingLowestRow = currentRow;
        int testingLowestColumn = currentColumn;

        int testingRow = 0, testingColumn = 0;

        if (cost[0].length > 1) {
            //up right
            try {
                testingRow = currentRow - 1;
                testingColumn = currentColumn + 1;
                upRightCost = cost[currentRow - 1][currentColumn + 1];
                testingLowestCost = cost[currentRow - 1][currentColumn + 1];
            } catch (Exception e) {
                testingRow = (cost.length - 1);
                upRightCost = cost[testingRow][testingColumn];
                testingLowestCost = cost[testingRow][testingColumn];
            }
            testingLowestCost = cost[testingRow][testingColumn];
            testingLowestRow = testingRow;
            testingLowestColumn = testingColumn;

            //right
            try {
                testingRow = currentRow;
                testingColumn = currentColumn + 1;
                rightCost = cost[testingRow][testingColumn];
            } catch (Exception e) {
            }
            if (testingLowestCost > cost[testingRow][testingColumn]) {
                testingLowestCost = cost[testingRow][testingColumn];
                testingLowestRow = testingRow;
                testingLowestColumn = testingColumn;
            }
            //down right{
            try {
                testingRow = currentRow + 1;
                testingColumn = currentColumn + 1;
                downRightCost = cost[testingRow][testingColumn];
            } catch (Exception e) {
                testingRow = 0;
                testingColumn = currentColumn + 1;
                downRightCost = cost[testingRow][testingColumn];
            }

            if (testingLowestCost > cost[testingRow][testingColumn]) {
                testingLowestCost = cost[testingRow][testingColumn];
                testingLowestRow = testingRow;
                testingLowestColumn = testingColumn;
            }
            cost[testingLowestRow][testingLowestColumn] = testingLowestCost + currentLowestCost;
            pathwayLocation.add(testingLowestRow + 1);
        }

        columnCounter++;
        if (columnCounter < cost[0].length - 1) {

            if (cost[0][testingLowestColumn] > 50) {
                criteriaStatus = "NO";
                view.matrixOutput(criteriaStatus, cost[testingLowestRow][testingLowestColumn], pathwayLocation);
            } else
                findPath(cost, testingLowestRow, testingLowestColumn, cost[testingLowestRow][testingLowestColumn]);
        } else {
//Criteria part 2
            if (cost[testingLowestRow][testingLowestColumn] < 50)
                criteriaStatus = "NO";
            view.matrixOutput(criteriaStatus, cost[testingLowestRow][testingLowestColumn], pathwayLocation);
        }
    }

    public void setupForPath(int[][] matrixInput) {
        pathwayLocation.clear();
        this.columnCounter = 0;
        int initialRow = getInitialMinValueLocationFirstRow(matrixInput);
        findPath(matrixInput, initialRow, 0, matrixInput[initialRow][0]);
    }

    //criteria
    public boolean checkValidInput(String matrixInput) {
        boolean inputStatus = false;

        if (matrixInput != null) {
            matrixInput = matrixInput.replace("\n", "").replace("\r", "");
            matrixInput = matrixInput.replaceAll("\\s+", "");
            inputStatus = matrixInput.matches("^[-?0-9]+$");
        }
        Log.d(TAG, "checkValidInput: " + inputStatus);

        return inputStatus;
    }

    @Override
    public void userMatrixInput(String matrixInput) {
        if (checkValidInput(matrixInput) == true) {
            String[] rowInput = matrixInput.split("\n");
            String[] columnInput = new String[0];

            for (int i = 0; i < rowInput.length; i++) {
                columnInput = rowInput[i].split(" ");
            }

            int[][] test = new int[rowInput.length][columnInput.length];
            Log.d(TAG, "char: " + rowInput.length + "     " + columnInput.length);

            for (int i = 0; i < rowInput.length; i++) {
                columnInput = rowInput[i].split(" ");
                for (int j = 0; j < columnInput.length; j++) {
                    test[i][j] = Integer.valueOf(columnInput[j]);
                }
            }
            //---Solve
            setupForPath(test);
        } else
            view.showError("Invalid matrix");
    }
}
