package com.basic;

import com.devops.DevopsApplication;
import com.devops.web.i18n.I18NService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= DevopsApplication.class)
@WebAppConfiguration

public class DevopsApplicationTests {

	@Autowired
	private I18NService i18NService;

	@Test
	public void testMsg() throws Exception{
		String expected = "Bootstrap starter template";
		String mID = "index.main.callout";
		String actual = i18NService.getMsg(mID);
		Assert.assertEquals("Doesnt Match", expected,actual);
	}

}
