package com.yieldstreet.accreditation.service;

import com.yieldstreet.accreditation.common.AccreditationUtil;
import com.yieldstreet.accreditation.vo.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.yieldstreet.accreditation.common.AccreditationConstants.*;

@Service
public class AccreditationServiceImpl implements AccreditationService {

  @Autowired AccreditationUtil accreditationUtil;

  @Override
  public boolean isUserAccreditationComplete(Payload payload) {
    Boolean result = null;
    switch (payload.getAccreditationType()) {
      case BY_INCOME:
        result =
            (AccreditationUtil.calculateUserNetWorth(payload.getDocuments()) >= MILLION)
                ? SUCCESS
                : FAILURE;
        break;
      default:
        result = false;
    }
    return result;
  }
}
