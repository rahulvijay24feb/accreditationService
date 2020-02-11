package com.yieldstreet.accreditation.service;

import com.yieldstreet.accreditation.vo.Payload;

/** */
public interface AccreditationService {
  /**
   * This method accepts previous two years tax returns and returns true if user is accredited.
   *
   * @param payload
   * @return
   */
  boolean isUserAccreditationComplete(Payload payload);
}
