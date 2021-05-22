package com.notifications.genericNotifications.controller;

import com.notifications.genericNotifications.Bean.EmailBean;
import com.notifications.genericNotifications.service.OrderStateUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusUpdateController {

    @Autowired
    private OrderStateUpdateService orderStateUpdateService;

    /**
     * A json response can be added here
     * @return
     */
    @PutMapping("/update-status")
    public String updateState() {
        try {
            orderStateUpdateService.updateStateAndNotifyUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updated";
    }

    @PutMapping("/notify-user")
    public String notifyUser(@RequestBody EmailBean emailBean) {
        try {
            orderStateUpdateService.updateStateAndNotifyUser(emailBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "updated";
    }
}
