package com.devops;

import com.devops.backend.service.SmtpEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devops.backend.persistence.domain.backend.Role;
import com.devops.backend.persistence.domain.backend.User;
import com.devops.backend.persistence.domain.backend.UserRole;
import com.devops.backend.service.UserService;
import com.devops.enums.PlanEnum;

import com.devops.enums.RolesEnum;
import com.devops.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DevopsApplication implements CommandLineRunner{

private static final Logger LOG = LoggerFactory.getLogger(DevopsApplication.class);

	@Autowired
	private UserService us;

	public static void main(String[] args)
	{
		SpringApplication.run(DevopsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {



		User u = UserUtil.createBasicUser();
		Set<UserRole> urole = new HashSet<>();
		urole.add(new UserRole(u,new Role(RolesEnum.PRO)));
		LOG.debug("Creating User {}", u.getUsername());
		us.createUser(u, PlanEnum.PRO,urole);
		LOG.info("User {} created", u.getUsername());
	}
}
