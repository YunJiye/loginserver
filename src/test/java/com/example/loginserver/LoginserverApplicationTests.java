package com.example.loginserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.loginserver.configuration.JpaAuditingConfiguration;
import com.example.loginserver.domain.userinfo.UserInfo;
import com.example.loginserver.domain.userinfo.UserInfoRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
@Import(JpaAuditingConfiguration.class)
class LoginserverApplicationTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testGet() throws Exception {
        String id = "testId";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/test/get")
                .param("id", id))
                .andExpect(status().isOk())
                .andExpect(content().string("id is " + id))
                .andReturn();
	}

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    public void testJpaAuditing() throws Exception{
        // given
        UserInfo userInfo = new UserInfo("testUser", "password");

        // when
        userInfo = userInfoRepository.save(userInfo);   // save user

        // then
        assertNotNull(userInfo.getUniqueid()); // id should be generated
        assertNotNull(userInfo.getCreatedDate()); // createdAt should be set
        assertNotNull(userInfo.getModifiedDate()); // updatedAt should be set

        // Remember the initial modifiedDate
        LocalDateTime initialModifiedDate = userInfo.getModifiedDate();

        // update user info
        LocalDateTime createdAt = userInfo.getCreatedDate();
        userInfo.setUserpwd("newPassword");
        userInfo = userInfoRepository.save(userInfo);

        // createdAt should not change
        assertNotNull(userInfo.getCreatedDate());
        assertNotNull(userInfo.getModifiedDate());
        assert createdAt.equals(userInfo.getCreatedDate()); // createdAt should not change
        assertNotEquals(initialModifiedDate, userInfo.getModifiedDate());
    }
}
