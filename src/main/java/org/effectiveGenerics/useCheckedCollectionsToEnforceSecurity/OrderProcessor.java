package org.effectiveGenerics.useCheckedCollectionsToEnforceSecurity;

import java.util.List;

public interface OrderProcessor {
    public void processOrders(List<? extends Order> orders);
}
