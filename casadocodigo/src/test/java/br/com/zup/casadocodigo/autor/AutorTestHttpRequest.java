package br.com.zup.casadocodigo.autor;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AutorTestHttpRequest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("teste cadastro autor")
    public void cadastrarAutor() throws Exception {
        URI uri = new URI("/autor/cadastrar");
        StringBuilder json = new StringBuilder();
        json.append("{ ");
        json.append("\"email\"" + ":" + "\"admin@live.com\",");
        json.append("\"nome\"" + ":" + "\"Hill, Napoleon\",");
        json.append("\"descricao\"" + ":" + "\"paraiso novo autor\"");
        json.append("} ");
//        String json = "{\"email\":\"admin@email.com\",\"nome\":\"asdasdas\",\"descricao\":\"aasdasdasd\"}";
//        String json = "{\"email\":\"invalido@email.com\",\"senha\":\"123456\"}";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

}


