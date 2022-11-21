package com.github.ganlong.commons.uitl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Author KnockingFarmers
 * @Date 2022/11/21 17:06
 * @PackageName:com.github.ganlong.commons.uitl
 * @ClassName: EmailUtil
 * @Description: 邮箱工具类
 * @Version 1.0
 */
@Slf4j
public class EmailUtil {

    private static JavaMailSender javaMailSender=new JavaMailSenderImpl();

    public static boolean sendEmail(String email,String subject,String text){
        SimpleMailMessage sm = new SimpleMailMessage();
        //设置邮件主题
        sm.setSubject(subject);
        sm.setText(text);

        //发给谁
        sm.setTo(email);

        //发送者
        sm.setFrom("BSC-MES系统");

        try {
            javaMailSender.send(sm);
        }catch (RuntimeException e){
            log.error("发送失败");
            return false;
        }

        return true;
    }


}
