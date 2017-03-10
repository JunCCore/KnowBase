package com.StaticFactory;


/**
 * 
 * @author root Java 设计模式之 静态工厂
 */
public class SendFactory {
    // 静态方法1
    public static Sender produceMail() {
        return new MailSender();
    }
    // 静态方法二
    public static Sender prodrceSms() {
        return new SmsSender();
    }
}
