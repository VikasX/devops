package com.devops.backend.service;

import com.devops.backend.persistence.domain.backend.User;
import com.devops.backend.persistence.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by XxX on 7/22/2017.
 */
@Service
public class UserSecurityService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

    @Autowired
    private UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User u = ur.findByUsername(s);

        if(null == u){
            LOG.warn("Username {} not found", s);
            throw new UsernameNotFoundException("USername " + s + "not found");
        }

        return u;
    }
}
