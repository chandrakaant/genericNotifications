package com.notifications.genericNotifications.service;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {


    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendMimeMessageEmail(@NotNull String toAddress, @NotNull String subject, @NotNull String body, @NotNull String fromAddress) throws Exception {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(toAddress);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);
            mimeMessageHelper.setFrom(fromAddress);
            mailSender.send(mimeMessage);
            System.out.println("Mail sent to: " + toAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
