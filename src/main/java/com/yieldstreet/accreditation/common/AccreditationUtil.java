package com.yieldstreet.accreditation.common;

import com.yieldstreet.accreditation.vo.Document;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.yieldstreet.accreditation.common.AccreditationConstants.TEN;
import static com.yieldstreet.accreditation.common.AccreditationConstants.UPPERBOUND;

/** */
@Component
public class AccreditationUtil {

  /**
   * Calculates network from given documents.
   * @param documents
   * @return
   */
  public static Integer calculateUserNetWorth(Document[] documents) {
    Random random = new Random();
    return random.nextInt(TEN) + UPPERBOUND;
  }
}
