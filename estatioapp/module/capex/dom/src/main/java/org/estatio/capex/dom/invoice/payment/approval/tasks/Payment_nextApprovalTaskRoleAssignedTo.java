package org.estatio.capex.dom.invoice.payment.approval.tasks;

import org.apache.isis.applib.annotation.Mixin;

import org.estatio.capex.dom.invoice.payment.Payment;
import org.estatio.capex.dom.invoice.payment.approval.PaymentApprovalState;
import org.estatio.capex.dom.invoice.payment.approval.PaymentApprovalStateTransition;
import org.estatio.capex.dom.invoice.payment.approval.PaymentApprovalStateTransitionType;
import org.estatio.capex.dom.task.DomainObject_nextTaskRoleAssignedToAbstract;

@Mixin(method="prop")
public class Payment_nextApprovalTaskRoleAssignedTo
        extends DomainObject_nextTaskRoleAssignedToAbstract<
                    Payment,
                    PaymentApprovalStateTransition,
                    PaymentApprovalStateTransitionType,
                    PaymentApprovalState> {

    public Payment_nextApprovalTaskRoleAssignedTo(final Payment payment) {
        super(payment, PaymentApprovalStateTransition.class);
    }

    public boolean hideProp() {
        return super.hideProp();
    }

}
