package org.effectiveGenerics.useCheckedCollectionsToEnforceSecurity;

import java.util.List;

public interface OrderSupplier {
    public void addOrders(List<AuthenticatedOrder> orders);
}
