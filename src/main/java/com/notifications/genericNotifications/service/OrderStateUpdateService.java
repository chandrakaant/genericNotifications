package com.notifications.genericNotifications.service;

import com.notifications.genericNotifications.Bean.EmailBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.notifications.genericNotifications.Utils.StringConstants.*;

@Service
public class OrderStateUpdateService {

    @Autowired
    NotificationService notificationService;

    @Value("${from.email}")
    private String fromEmail;


    public String updateStateAndNotifyUser() throws Exception {
        // Business Logic to update or change state to trigger notification

        /**
         * send email notification with predefined details
         * toAddress must be changed for each user.
         */
        notificationService.sendMimeMessageEmail
                ("notification@sharklasers.com", STATE_UPDATE_EMAIL_SUBJECT, STATE_UPDATE_EMAIL_GREETINGS + "user name" + STATE_UPDATE_EMAIL_BODY, fromEmail);
        return "Updated state";
    }

    public String updateStateAndNotifyUser(EmailBean emailBean) throws Exception {
        // Business Logic to update or change state to trigger notification

        /**
         * send email notification with custom details
         * toAddress must be changed for each user.
         */
        notificationService.sendMimeMessageEmail
                (emailBean.getToEmail(), emailBean.getSubject(), STATE_UPDATE_EMAIL_GREETINGS + "user name " + emailBean.getBody(), fromEmail);
        return "Updated state";
    }

    public String updateStateAndNotifyUserOnSlack() {

        return "Update State";
    }
}
