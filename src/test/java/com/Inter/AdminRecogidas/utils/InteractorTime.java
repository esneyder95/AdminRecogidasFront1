package com.Inter.AdminRecogidas.utils;

import net.serenitybdd.core.pages.PageObject;


public class InteractorTime extends PageObject {

    public void esperaMilis(Integer milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
