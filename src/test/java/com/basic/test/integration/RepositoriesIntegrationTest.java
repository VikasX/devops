package com.basic.test.integration;

import com.devops.DevopsApplication;
import com.devops.backend.persistence.domain.backend.Plan;
import com.devops.backend.persistence.domain.backend.Role;
import com.devops.backend.persistence.domain.backend.User;
import com.devops.backend.persistence.domain.backend.UserRole;
import com.devops.backend.persistence.repos.PlanRepository;
import com.devops.backend.persistence.repos.RoleRepository;
import com.devops.backend.persistence.repos.UserRepository;
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
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by XxX on 7/22/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DevopsApplication.class)
public class RepositoriesIntegrationTest {

    @Autowired
    private RoleRepository rr;

    @Autowired
    private UserRepository ur;

    @Autowired
    private PlanRepository pr;


    @Rule public TestName tname = new TestName();

   // private static final int BASIC_PLAN_ID = 1;

    @Before
    public void init() {
        Assert.assertNotNull(rr);
        Assert.assertNotNull(pr);
        Assert.assertNotNull(ur);
    }

    @Test
    public void testCreatedNewPlan() throws Exception {
        Plan bp = createPlan(PlanEnum.BASIC);
        pr.save(bp);

        Plan retrievep = pr.findOne(PlanEnum.BASIC.getId());
        Assert.assertNotNull(retrievep);
    }

    @Test
    public void testCreatedNewRole() throws Exception {
        Role urole = createRole(RolesEnum.BASIC);
        rr.save(urole);

        Role retriever = rr.findOne(RolesEnum.BASIC.getId());
        Assert.assertNotNull(retriever);
    }

    @Test
    public void testCreateNewUser() throws Exception {

        /*
        Plan bp = createPlan(PlanEnum.BASIC);
        pr.save(bp);

        User bu = UserUtil.createBasicUser();
        bu.setPlan(bp);

        Role basicRole = createRole(RolesEnum.BASIC);
        Set<UserRole> uroles = new HashSet<>();

        UserRole userR = new UserRole(bu,basicRole);
      //  userR.setUser(bu);
      //  userR.setRole(basicRole);

        uroles.add(userR);

        bu.getUserRoles().addAll(uroles);

        for (UserRole ur: uroles){
            rr.save(ur.getRole());
        }
*/


        User bu = createUser();

        User newUser = ur.findOne(bu.getId());

        Assert.assertNotNull(newUser);
        Assert.assertTrue(newUser.getId()!=0);

        Assert.assertNotNull(newUser.getPlan());
        Assert.assertNotNull(newUser.getPlan().getId());

        Set<UserRole> newUroles = newUser.getUserRoles();
        for(UserRole r: newUroles){
            Assert.assertNotNull(r.getRole());
            Assert.assertNotNull(r.getRole().getId());
        }


    }

    @Test
    public void testDeleteUser() throws Exception {



        User bu = createUser();
        ur.delete(bu.getId());
    }





    private Plan createPlan(PlanEnum e) {
        return new Plan(e);
    }




    private Role createRole(RolesEnum e) {

       /* Role r =new Role();
        r.setId(BASIC_ROLE_ID);
        r.setName("Role_USER");
        return r; */

       return new Role(e);
    }

    private User createUser() {
        Plan bp = createPlan(PlanEnum.BASIC);
        pr.save(bp);

        User bu = UserUtil.createBasicUser();
        bu.setPlan(bp);

        Role basicr = createRole(RolesEnum.BASIC);
        rr.save(basicr);

        Set<UserRole> uroles = new HashSet<>();

        UserRole userR = new UserRole(bu,basicr);


        uroles.add(userR);

        bu.getUserRoles().addAll(uroles);

        bu = ur.save(bu);

        return bu;


    }


}
