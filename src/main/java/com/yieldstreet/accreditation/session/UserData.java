package com.yieldstreet.accreditation.session;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;
// import org.springframework.data.annotation.Id;

/** */
@Data
@Builder
public class UserData implements Serializable {
  // @Id
  private String userId;
  private Map<String, Serializable> userMap;
}
