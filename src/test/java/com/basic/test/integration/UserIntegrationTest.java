package com.basic.test.integration;

import com.devops.DevopsApplication;
import com.devops.backend.persistence.domain.backend.Plan;
import com.devops.backend.persistence.domain.backend.Role;
import com.devops.backend.persistence.domain.backend.User;
import com.devops.backend.persistence.domain.backend.UserRole;
import com.devops.backend.persistence.repos.PlanRepository;
import com.devops.backend.persistence.repos.RoleRepository;
import com.devops.backend.persistence.repos.UserRepository;
import com.devops.backend.service.UserService;
import com.devops.enums.PlanEnum;
import com.devops.enums.RolesEnum;
import com.devops.utils.UserUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by XxX on 7/22/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DevopsApplication.class)
public class UserIntegrationTest {

    @Autowired
    private UserService us;

    @Rule public TestName tname = new TestName();

    @Test
    public void testCreateNewUser() throws Exception {



        Set<UserRole> uroles = new HashSet<>();
        User bu = UserUtil.createBasicUser();
        uroles.add(new UserRole(bu,new Role(RolesEnum.BASIC)));

        User u = us.createUser(bu, PlanEnum.BASIC, uroles);
        Assert.assertNotNull(u);
        Assert.assertNotNull(u.getId());

    }

}
