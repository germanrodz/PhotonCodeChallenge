package com.blovvme.photoncodechallenge.view;

import com.blovvme.photoncodechallenge.BasePresenter;
import com.blovvme.photoncodechallenge.BaseView;

import java.util.ArrayList;

/**
 * Created by Blovvme on 1/23/18.
 */

public interface MainActivityContract {
    interface View extends BaseView {
        void matrixOutput(String matrixStatus, int finalCost, ArrayList<Integer> pathwayLocation);
    }

    interface Presenter extends BasePresenter<View> {
        void userMatrixInput(String matrixInput);
    }

}
