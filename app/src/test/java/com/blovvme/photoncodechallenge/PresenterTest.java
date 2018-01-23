package com.blovvme.photoncodechallenge;

import com.blovvme.photoncodechallenge.view.MainActivity;
import com.blovvme.photoncodechallenge.view.MainActivityContract;
import com.blovvme.photoncodechallenge.view.MainActivityPresenter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Blovvme on 1/23/18.
 */

public class PresenterTest implements MainActivityContract.View {
    private static final String TAG = "PresenterTest";
    private MainActivityContract.Presenter presenter;
    ArrayList<Integer> pathwayLocation = new ArrayList<>();
    ArrayList<Integer> pathwayExpected = new ArrayList<>();

    @Before
    public void setup() {
        presenter = new MainActivityPresenter();
        presenter.attachView(this);
    }

    // Sample 1 NOT WORKING
    @Test
    public void sample1() {
        String sample = "3 4 1 2 8 6\n" +
                "6 1 8 2 7 4\n" +
                "5 9 3 9 9 5\n" +
                "8 4 1 3 2 6\n" +
                "3 7 2 8 6 4";
        pathwayExpected.clear();
        pathwayExpected.add(1);
        pathwayExpected.add(2);
        pathwayExpected.add(3);
        pathwayExpected.add(4);
        pathwayExpected.add(4);
        pathwayExpected.add(5);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayLocation, pathwayExpected);
    }

    @Test
    public void sample2() {
        String sample = "3 4 1 2 8 6\n" +
                "6 1 8 2 7 4\n" +
                "5 9 3 9 9 5\n" +
                "8 4 1 3 2 6\n" +
                "3 7 2 1 2 3";

        pathwayExpected.clear();
        pathwayExpected.add(1);
        pathwayExpected.add(2);
        pathwayExpected.add(1);
        pathwayExpected.add(5);
        pathwayExpected.add(4);
        pathwayExpected.add(5);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample3() {
        String sample = "19 10 19 10 19\n" +
                "21 23 20 19 12\n" +
                "20 12 20 11 10";

        pathwayExpected.clear();
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample4() {
        String sample = "5 8 5 3 5";

        pathwayExpected.clear();
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample5() {
        String sample = "5\n" +
                "8\n" +
                "5\n" +
                "3\n" +
                "5";

        pathwayExpected.clear();
        pathwayExpected.add(4);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample6() {
        String sample = "5 4 H\n" +
                "8 M 7\n" +
                "5 7 5\n";

        pathwayExpected.clear();


        String criteria = "none";
        presenter.userMatrixInput(sample);

        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample7() {
        String sample = null;

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample8() {

        String sample = "69 10 19 10 19\n" +
                "51 23 20 19 12\n" +
                "60 12 20 11 10";

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample9() {

        String sample = "60 3 3 6\n" +
                "6 3 7 9\n" +
                "5 6 8 3";

        pathwayExpected.clear();
        pathwayExpected.add(3);
        pathwayExpected.add(2);
        pathwayExpected.add(1);
        pathwayExpected.add(3);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample10() {

        String sample = "6 3 -5 9\n" +
                "-5 2 4 10\n" +
                "3 -2 6 10\n" +
                "6 -1 -2 10";

        pathwayExpected.clear();
        pathwayExpected.add(2);
        pathwayExpected.add(3);
        pathwayExpected.add(4);
        pathwayExpected.add(1);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample11() {

        String sample = "51 51\n" +
                "0 51\n" +
                "51 51\n" +
                "5 5";
        pathwayExpected.clear();
        pathwayExpected.add(4);
        pathwayExpected.add(4);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample12() {

        String sample = "51 51 51\n" +
                "0 51 51\n" +
                "51 51 51\n" +
                "5 5 51";
        pathwayExpected.clear();
        pathwayExpected.add(4);
        pathwayExpected.add(4);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }

    @Test
    public void sample13() {

        String sample = "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2";
        pathwayExpected.clear();
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);
        pathwayExpected.add(1);

        presenter.userMatrixInput(sample);
        assertEquals("Fail", pathwayExpected, pathwayLocation);
    }




    @Override
    public void showError(String s) {

    }

    @Override
    public void matrixOutput(String matrixStatus, int finalCost, ArrayList<Integer> pathway) {
        pathwayLocation.clear();
        pathwayLocation = pathway;
    }
}
