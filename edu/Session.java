package edu;

import java.io.Serializable;

public class Session implements Serializable {
    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    private int times;

    Session() {
        this.times = 0;
    }


}
