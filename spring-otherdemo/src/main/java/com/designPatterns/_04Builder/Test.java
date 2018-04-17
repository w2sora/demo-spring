package com.designPatterns._04Builder;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Builder builder = new Builder();

        List<Sender> list = new ArrayList<>();
        list = builder.produceMailSender(10);

        for (Sender aList : list) {
            aList.send();
        }
    }
}
