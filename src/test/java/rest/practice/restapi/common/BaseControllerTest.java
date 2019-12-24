package rest.practice.restapi.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
@ActiveProfiles("test")
@Ignore // 테스트시 동작하지 않도록함.
//@WebMvcTest // MockMVC 빈을 자동 설정해준다. 웹관련 빈만 등록해주며 슬라이스 테스트를 가능케 한다. 테스트 작성이 불편하므로 SpringBootTest, AutoConfigureMockMvc를 사용
public class BaseControllerTest {
    @Autowired
    protected MockMvc mockMvc;    // DispathcerServlet가 요청하는 처리 과정을 확인할수 있기 때문에 컨트롤러 테스트용으로 자주 쓰임.

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ModelMapper modelMapper;
}
