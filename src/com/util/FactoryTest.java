package com.util;

import com.StaticFactory.SendFactory;
import com.StaticFactory.Sender;

public class FactoryTest {
    public static void main(String[] args) {
        Sender sender = new SendFactory().produceMail();
                sender.Send();
    }

}
