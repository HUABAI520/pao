package com.ithe.pao.service;

import com.ithe.pao.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void getSafetyUser() {
    }

    @Test
    void testSearchUsersByTags() {
        List<String> tagNameList = Arrays.asList("java","python");
        List<User> usrList = userService.searchUsersByTags(tagNameList);
        Assert.assertNotNull(usrList);
    }
}