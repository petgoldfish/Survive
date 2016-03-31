package com.oobe.survive;

import com.orm.SugarRecord;

public class node {

    int rindex;
    int lindex;
    int next;
    String msg;
    String leftBtnmsg;
    String rightBtnmsg;
    Boolean btn;

    public node() {

    }

    public node(String msg, int lindex, int rindex, int next, Boolean btn, String leftBtnmsg, String rightBtnmsg){
        this.rindex = rindex;
        this.lindex = lindex;
        this.btn = btn;
        this.msg = msg;
        this.leftBtnmsg = leftBtnmsg;
        this.rightBtnmsg = rightBtnmsg;
        this.next = next;
    }
}
