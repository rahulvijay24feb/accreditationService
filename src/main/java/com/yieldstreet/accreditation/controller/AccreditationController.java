package com.yieldstreet.accreditation.controller;

import com.yieldstreet.accreditation.service.AccreditationService;
import com.yieldstreet.accreditation.vo.AccreditationRequest;
import com.yieldstreet.accreditation.vo.AccreditationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.logging.Logger;

import static com.yieldstreet.accreditation.common.AccreditationConstants.SUCCESS;

/** */
@RestController
public class AccreditationController extends AccreditationControllerBase{

  private static final Logger log = Logger.getLogger("AccreditationController");

  @Autowired AccreditationService accreditationService;

  /**
   * @param request
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, path="/user/accreditation")
  public AccreditationResponse validateAccreditation(@Valid @RequestBody AccreditationRequest request) {
    return AccreditationResponse.builder()
        .accredited(accreditationService.isUserAccreditationComplete(request.getPayload()))
        .success(SUCCESS)
        .build();
  }
}
