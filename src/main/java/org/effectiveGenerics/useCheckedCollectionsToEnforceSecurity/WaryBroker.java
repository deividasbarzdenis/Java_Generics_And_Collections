package org.effectiveGenerics.useCheckedCollectionsToEnforceSecurity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaryBroker {
    /**
     * Incompetence can cause just as many problems as deviousness. Any code that issues
     * unchecked warnings when compiled could cause similar problems, perhaps simply
     * because the author made a mistake. In particular, legacy code may raise such problems,
     * as described in the previous section.
     * The correct solution is for the broker to pass a checked list to the supplier:
     * */
    public void connect(OrderSupplier supplier,
                        OrderProcessor processor)
    {
        List<AuthenticatedOrder> orders =
                new ArrayList<AuthenticatedOrder>();
        supplier.addOrders(
                Collections.checkedList(orders, AuthenticatedOrder.class));
        processor.processOrders(orders);
    }
    /**
     * Now a class cast exception will be raised if the supplier attempts to add anything to the
     * list that is not an authenticated order.
     * Checked collections are not the only technique for enforcing security. If the interface
     * that supplies orders returns a list instead of accepting a list, then the broker can use the
     * empty loop technique of the previous section to ensure that lists contain only authorized orders
     * before passing them on. One can also use specialization, as described in the
     * next section, to create a special type of list that can contain only authorized orders.
     * */
}
