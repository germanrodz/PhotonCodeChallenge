package com.blovvme.photoncodechallenge;

/**
 * Created by Blovvme on 1/23/18.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void detachView();
}
