package com.devops.backend.service;

import com.devops.backend.persistence.domain.backend.Plan;
import com.devops.backend.persistence.domain.backend.User;
import com.devops.backend.persistence.domain.backend.UserRole;
import com.devops.backend.persistence.repos.PlanRepository;
import com.devops.backend.persistence.repos.RoleRepository;
import com.devops.backend.persistence.repos.UserRepository;
import com.devops.enums.PlanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


/**
 * Created by XxX on 7/22/2017.
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private RoleRepository rr;

    @Autowired
    private PlanRepository pr;

    @Autowired
    private UserRepository ur;

    @Transactional
    public User createUser(User u, PlanEnum pe, Set<UserRole> uroles){

        Plan p = new Plan(pe);

        if(!pr.exists(pe.getId())){
            p = pr.save(p);
        }
        u.setPlan(p);

        for(UserRole ur : uroles){
            rr.save(ur.getRole());
        }

        u.getUserRoles().addAll(uroles);

        u = ur.save(u);

        return u;
    }
}
