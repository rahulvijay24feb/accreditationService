package com.yieldstreet.accreditation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class AccreditationServiceApplicationTests {
  private static String validAccreditationRequest =
      "{\n"
          + "  \"user_id\": \"g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V\",\n"
          + "  \"payload\": {\n"
          + "    \"accreditation_type\": \"BY_INCOME\",\n"
          + "    \"documents\": [{\n"
          + "        \"name\": \"2018.pdf\",\n"
          + "        \"mime_type\": \"application/pdf\",\n"
          + "        \"content\": \"ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==\"\n"
          + "      },{\n"
          + "        \"name\": \"2019.jpg\",\n"
          + "        \"mime_type\": \"image/jpeg\",\n"
          + "        \"content\": \"91cy1wcm9taXNlICJeMi4wLjUiCiAgICB0b3Bvc29ydCAiXjIuMC4yIgo=\"\n"
          + "      }\n"
          + "    ]\n"
          + "  }\n"
          + "}\n";
  private static String invalidAccreditationRequest =
      "{\n"
          + "  \"user_id\": \"g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V\",\n"
          + "  \"payload\": {\n"
          + "    \"accreditation_type\": \"BY_INCOME\",\n"
          + "    \"documents\": [{\n"
          + "        \"name\": \"2018.pdf\",\n"
          + "        \"content\": \"ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==\"\n"
          + "      },{\n"
          + "        \"name\": \"2019.jpg\",\n"
          + "        \"mime_type\": \"image/jpeg\"\n"
          + "      }\n"
          + "    ]\n"
          + "  }\n"
          + "}\n";
  @Autowired private MockMvc mvc;

  @Test
  void validAccreditationRequest() throws Exception {

    this.mvc
        .perform(
            MockMvcRequestBuilders.post("/user/accreditation")
                .content(validAccreditationRequest)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  void invalidAccreditationRequest() throws Exception {
    this.mvc
        .perform(
            MockMvcRequestBuilders.post("/user/accreditation")
                .content(invalidAccreditationRequest)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(
            MockMvcResultMatchers.content()
                .string(
                    "{\"payload.documents[0].mimeType\":\"mime_type field is blank/missing\",\"payload.documents[1].content\":\"content field is blank/missing\"}"));
  }
}
