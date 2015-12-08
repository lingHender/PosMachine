package com.thoughtworks.pos.compute;

import com.thoughtworks.pos.domain.BillItem;
import java.util.List;

/**
 * Created by lilingfang on 15/12/6.
 */
public interface PromotionStrategy {
      double promotionStrategy(List<BillItem> billItems);
}
