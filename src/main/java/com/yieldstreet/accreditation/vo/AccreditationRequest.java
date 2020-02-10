package com.yieldstreet.accreditation.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** */
@Data
public class AccreditationRequest {

  @JsonProperty("user_id")
  @NotBlank(message ="user_id field is blank/missing")
  private String userId;

  @JsonProperty("payload")
  @NotNull(message ="payload field is missing")
  @Valid
  private Payload payload;
}
