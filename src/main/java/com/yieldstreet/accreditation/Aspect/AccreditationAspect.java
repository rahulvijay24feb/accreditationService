package com.yieldstreet.accreditation.Aspect;

import com.yieldstreet.accreditation.session.UserData;
import com.yieldstreet.accreditation.session.UserSession;
import com.yieldstreet.accreditation.vo.AccreditationRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccreditationAspect {

  @Autowired private UserSession userSession;

  @Around(
      "execution(public * com.yieldstreet.accreditation.controller.AccreditationController.*(..)) && args(request)")
  public Object onController(ProceedingJoinPoint joinPoint, AccreditationRequest request)
      throws Throwable {
    Object result = null;
    try {
      userSession.setUserData(generateUserData(request));
      result = joinPoint.proceed();
    } catch (Throwable throwable) {
      throw throwable;
    } finally {
      userSession.setUserData(null);
    }
    return result;
  }

  private UserData generateUserData(AccreditationRequest request) {
    return UserData.builder().userId(request.getUserId()).build();
  }
}
