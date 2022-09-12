package com.demo.cropdeal.authentication.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

// testing the methods in AccountServiceImpl.class
@SelectClasses({SignInTest.class, SignUpTest.class})
@Suite
@SuiteDisplayName("Test AccountService methods")
class AccountServiceImplTest {

}