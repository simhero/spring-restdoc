package com.example.springrestdoc.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberControllerTest {

    @Rule
    public JUnitRestDocumentation jUnitRestDocumentation = new JUnitRestDocumentation();
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private RestDocumentationResultHandler restDocumentationResultHandler;


    @Before
    public void setUp() {
        this.restDocumentationResultHandler = document(
                "{class-name}/{method-name}",
                preprocessResponse(prettyPrint())
        );
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .apply(documentationConfiguration(this.jUnitRestDocumentation))
                .alwaysDo(restDocumentationResultHandler)
                .build();
    }

    @Test
    public void testGetMember() throws Exception {
            mockMvc.perform(get("/members/{id}", 1L)
                    .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(restDocumentationResultHandler.document(
                            // (1)
                            pathParameters(
                                    parameterWithName("id").description("Member's id")
                            )
//                            ,
                            // (2)
//                            responseFields(
//                                    fieldWithPath("email.value").description("The Member's email address"),
//                                    fieldWithPath("address.city").description("The Member's address city"),
//                                    fieldWithPath("address.street").description("The Member's address street"),
//                                    fieldWithPath("address.zipCode").description("The Member's address zipCode")
//                            )
                    ))
//                    .andExpect(jsonPath("$.email.value", is(notNullValue())))
//                    .andExpect(jsonPath("$.address.city", is(notNullValue())))
//                    .andExpect(jsonPath("$.address.street", is(notNullValue())))
//                    .andExpect(jsonPath("$.address.zipCode", is(notNullValue())))
            ;

    }
}