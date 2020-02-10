package com.yieldstreet.accreditation.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** */
@Data
public class Document {
  @JsonProperty("name")
  @NotBlank(message = "name field is blank/missing")
  private String name;

  @JsonProperty("mime_type")
  @NotBlank(message = "mime_type field is blank/missing")
  private String mimeType;

  @JsonProperty("content")
  @NotBlank(message = "content field is blank/missing")
  private String content;
}
