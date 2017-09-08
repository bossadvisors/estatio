package org.estatio.capex.dom.invoice.approval.triggers;

import javax.inject.Inject;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Mixin;
import org.apache.isis.applib.annotation.SemanticsOf;

import org.estatio.capex.dom.invoice.IncomingInvoice;
import org.estatio.capex.dom.invoice.viewmodel.IncomingDocAsInvoiceViewModel;

/**
 * This mixin cannot (easily) be inlined because it inherits functionality from its superclass, and in any case
 * this follows a common pattern applicable for all domain objects that have an associated state transition machine.
 */
@Mixin(method = "act")
public class IncomingDocAsInvoiceViewModel_previous extends IncomingInvoice_previous {

    private final IncomingDocAsInvoiceViewModel viewModel;

    public IncomingDocAsInvoiceViewModel_previous(final IncomingDocAsInvoiceViewModel viewModel) {
        super(viewModel.getDomainObject());
        this.viewModel = viewModel;
    }

    public static class ActionDomainEvent
            extends IncomingInvoice_triggerAbstract.ActionDomainEvent<IncomingDocAsInvoiceViewModel_previous> {}

    @Action(
            domainEvent = ActionDomainEvent.class,
            semantics = SemanticsOf.SAFE
    )
    public Object act() {
        return super.act();
    }

    @Override
    protected Object objectToReturn(final IncomingInvoice incomingInvoice) {
        return switchViewService.switchViewIfPossible(incomingInvoice);
    }


    @Inject
    SwitchViewService switchViewService;

}
