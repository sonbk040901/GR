package com.gr.bksafe;

import com.gr.bksafe.dao.CarDAO;
import com.gr.bksafe.dao.UserDAO;
import com.gr.bksafe.entity.Car;
import com.gr.bksafe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BkSafeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BkSafeApplication.class, args);
    }

}
