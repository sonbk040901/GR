package com.gr.bksafe;

import com.gr.bksafe.dao.CarDAO;
import com.gr.bksafe.dao.UserDAO;
import com.gr.bksafe.entity.Car;
import com.gr.bksafe.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
//@DataJpaTest
class BkSafeBeApplicationTests {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CarDAO carDAO;

    @Test
    void contextLoads() {
        var user = new User();
        user.setFullName("Son Le");
        userDAO.save(user);
        var car = new Car();
        car.setOwnerId(user.getId());
        carDAO.save(car);
        carDAO.findById(car.getId()).ifPresent(c -> {
            Assert.isTrue(c.getOwnerId().equals(user.getId()), "Owner id must be equal");
        });
//        Assert.isTrue(carDAO.count() == 1, "User count must be 1");
    }

}
