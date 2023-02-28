package ru.rrenat358.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstBean {

    @Autowired
    private SecondBean secondBean;

    public void setSecondBean(SecondBean secondBean) {
        this.secondBean = secondBean;
    }
}
