package com.bookstore.bookservice;//package com.bookstore.bookservice;
//
//import com.bookstore.bookservice.dto.BookRequest;
//import com.bookstore.bookservice.repository.BookRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.math.BigDecimal;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
//class BookServiceApplicationTests {
//
//    @Container
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//    @Autowired
//    private BookRepository bookRepository;
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//    }
//
//    @Test
//    void shouldCreateBook() throws Exception {
//        BookRequest bookRequest = getBookRequest();
//        String bookRequestString = objectMapper.writeValueAsString(bookRequest);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/book")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(bookRequestString))
//                .andExpect(status().isCreated());
//
//        Assertions.assertEquals(1, bookRepository.findAll().size());
//    }
//
//    private BookRequest getBookRequest() {
//        return BookRequest.builder()
//                .price(BigDecimal.valueOf(12))
//                .name("Namık Ekin")
//                .description("Bir efsanenin hikayesi")
//                .build();
//    }
//
//}
