package com.notifications.genericNotifications.service;

import com.notifications.genericNotifications.Bean.EmailBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import static com.notifications.genericNotifications.Utils.StringConstants.*;

@Service
public class OrderStateUpdateService {

    @Autowired
    NotificationService notificationService;

    @Value("${from.email}")
    private String fromEmail;


    /**
     * Function to send predefined mail to recepient
     * @return String confirmation of state change
     * @throws Exception generic exception
     */
    public String updateStateAndNotifyUser() throws Exception {
        // Business Logic to update or change state to trigger notification

        notificationService.sendMimeMessageEmail
                ("notification@sharklasers.com", STATE_UPDATE_EMAIL_SUBJECT, STATE_UPDATE_EMAIL_GREETINGS + "user name" + STATE_UPDATE_EMAIL_BODY, fromEmail);
        return "Updated state";
    }

    /**
     * Function to send custom email to recepient
      * @param emailBean request body containing custom email body
     * @return String confirmation of state change
     * @throws Exception generic exception
     */
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

}
