package org.effectiveGenerics.useCheckedCollectionsToEnforceSecurity;

import java.util.List;

public class DeviousSupplier implements OrderSupplier{
    //But a devious supplier may, in fact, supply unauthenticated orders:
    public void addOrders(List<AuthenticatedOrder> orders) {
        List raw = orders;
        Order order = new Order(); // not authenticated
        raw.add(order); // unchecked call
    }
    //Compiling the devious supplier will issue an unchecked warning, but the broker has
    //no way of knowing this.
}
