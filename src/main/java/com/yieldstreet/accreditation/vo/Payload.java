package com.yieldstreet.accreditation.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** */
@Data
public class Payload {

  @JsonProperty("accreditation_type")
  @NotBlank(message ="accreditation_type field is blank/missing")
  private String accreditationType;

  @JsonProperty("documents")
  @NotNull(message = "documents field is missing")
  @Valid
  private Document[] documents;
}
