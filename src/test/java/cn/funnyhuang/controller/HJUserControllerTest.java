package cn.funnyhuang.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.junit.Assert.*;


public class HJUserControllerTest {
    HJUserController userController;
    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        userController = new HJUserController();
        mockMvc = standaloneSetup(userController).build();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createUser() throws Exception {

        MultiValueMap valueMap = new LinkedMultiValueMap();
        valueMap.add("nickName","王大治");
        valueMap.add("passWord","123456");
        ResultActions actions = mockMvc.perform(get("/user/createUser")
                                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                                .params(valueMap));
        MvcResult result = actions.andReturn();
        String string = result.getResponse().getContentAsString();
        System.out.println("客户端获取到的信息" + string);
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void selectUserList() {
    }
}