package com.demo.cropdeal.authentication;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@SelectPackages({"com.demo.cropdeal.authentication.service", "com.demo.cropdeal.authentication.model",
	"com.demo.cropdeal.authentication.controller"})
@Suite
@SpringBootTest
class AuthenticationApplicationTests {


}
