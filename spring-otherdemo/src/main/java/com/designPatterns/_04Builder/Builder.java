package com.designPatterns._04Builder;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    private List<Sender> list = new ArrayList<>();

    public List<Sender> produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
        return list;
    }

    public List<Sender> produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
        return list;
    }

}
