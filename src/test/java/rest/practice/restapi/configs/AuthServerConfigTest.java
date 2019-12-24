package rest.practice.restapi.configs;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import rest.practice.restapi.accounts.Account;
import rest.practice.restapi.accounts.AccountRole;
import rest.practice.restapi.accounts.AccountService;
import rest.practice.restapi.common.AppProperties;
import rest.practice.restapi.common.BaseControllerTest;
import rest.practice.restapi.common.TestDescription;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthServerConfigTest extends BaseControllerTest {
    @Autowired
    AccountService accountService;

    @Autowired
    AppProperties appProperties;

    @Test
    @TestDescription("인증 토큰 발급 받는 테스트")
    public void getAuthToken() throws Exception {
        // TODO : 조회(미인증, 인증), 수정(미인증, 인증) 테스트 만들기

        String username = "test@email.com";
        String password = "test";
        String clientId = "myApp";
        String clientSecret = "pass";

        this.mockMvc.perform(post("/oauth/token")
                    .with(httpBasic(clientId, clientSecret))
                    .param("username", username)
                    .param("password", password)
                    .param("grant_type", "password")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("access_token").exists())
                ;
    }

}