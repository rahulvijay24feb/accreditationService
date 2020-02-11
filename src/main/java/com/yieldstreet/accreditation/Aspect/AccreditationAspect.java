package com.yieldstreet.accreditation.Aspect;

import com.yieldstreet.accreditation.session.UserData;
import com.yieldstreet.accreditation.session.UserSession;
import com.yieldstreet.accreditation.vo.AccreditationRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/** */
@Aspect
@Component
@Slf4j
public class AccreditationAspect {

  @Autowired private UserSession userSession;
  /**
   * A cross cutting method over Accreditation controller.
   *
   * @param joinPoint
   * @param request
   * @return
   * @throws Throwable
   */
  @Around(
      "execution(public * com.yieldstreet.accreditation.controller.AccreditationController.*(..)) && args(request)")
  public Object onController(ProceedingJoinPoint joinPoint, AccreditationRequest request)
      throws Throwable {
    Object result = null;
    StopWatch watch = new StopWatch();
    try {
      watch.start();
      userSession.setUserData(generateUserData(request));
      result = joinPoint.proceed();
    } catch (Throwable throwable) {
      throw throwable;
    } finally {
      userSession.setUserData(null);
      watch.stop();
      log.debug(
          "Method :{} Timetaken:{}",
          joinPoint.getSignature().getName(),
          watch.getTotalTimeMillis());
    }
    return result;
  }

  private UserData generateUserData(AccreditationRequest request) {
    return UserData.builder().userId(request.getUserId()).build();
  }
}
