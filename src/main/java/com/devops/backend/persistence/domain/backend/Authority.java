package com.devops.backend.persistence.domain.backend;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by XxX on 7/22/2017.
 */
public class Authority implements GrantedAuthority{

    private final String auth;

    public Authority(String auth){
        this.auth = auth;
    }

    @Override
    public String getAuthority() {
        return auth;
    }

}
