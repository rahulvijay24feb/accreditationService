package com.yieldstreet.accreditation.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccreditationResponse {
  @JsonProperty("success")
  private boolean success;

  @JsonProperty("accredited")
  private boolean accredited;
}
