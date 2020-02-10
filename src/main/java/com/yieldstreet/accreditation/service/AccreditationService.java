package com.yieldstreet.accreditation.service;

import com.yieldstreet.accreditation.vo.Payload;

/** */
public interface AccreditationService {
  boolean isUserAccreditationComplete(Payload payload);
}
