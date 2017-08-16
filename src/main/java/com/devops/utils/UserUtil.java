package com.devops.utils;

import com.devops.backend.persistence.domain.backend.User;

/**
 * Created by XxX on 7/22/2017.
 */
public class UserUtil {

    private UserUtil(){ throw new AssertionError("Non instantiable");}

    public static User createBasicUser() {

        User u = new User();
        u.setUsername("user");
        u.setPassword("password");
        u.setEmail("xxx@xxx.com");
        u.setFirstName("first");
        u.setLastName("last");
        u.setPhoneNumber("1234123412");
        u.setCountry("india");
        u.setEnabled(true);
        u.setDescription("description");
        u.setProfileImageUrl("https://blabla.images.com/basicuser");

        return u;
    }
}
