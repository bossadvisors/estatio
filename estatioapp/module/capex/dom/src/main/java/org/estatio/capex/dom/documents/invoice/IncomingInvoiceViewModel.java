/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.capex.dom.documents.invoice;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.joda.time.LocalDate;

import org.apache.isis.applib.annotation.DomainObject;

import org.incode.module.document.dom.impl.docs.Document;

import org.estatio.capex.dom.documents.HasBuyer;
import org.estatio.capex.dom.documents.HasDocumentAbstract;
import org.estatio.capex.dom.documents.HasSeller;
import org.estatio.dom.charge.Charge;
import org.estatio.dom.invoice.PaymentMethod;
import org.estatio.dom.party.Organisation;
import org.estatio.dom.tax.Tax;

import lombok.Getter;
import lombok.Setter;

@DomainObject(
        // WORKAROUND: using fqcn as objectType because Isis' invalidation of cache in prototyping mode causing NPEs in some situations
        objectType = "org.estatio.capex.dom.documents.invoice.IncomingInvoiceViewModel"
)
@XmlRootElement(name = "categorizeIncomingInvoice")
@XmlType(
        propOrder = {
                "document",
                "invoiceNumber",
                "buyer",
                "seller",
                "invoiceDate",
                "dueDate",
                "paymentMethod",
                "description",
                "charge",
                "effectiveStartDate",
                "effectiveEndDate",
                "quantity",
                "netAmount",
                "vatAmount",
                "tax",
                "grossAmount"
        }
)
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter
public class IncomingInvoiceViewModel extends HasDocumentAbstract implements HasBuyer, HasSeller {

    public IncomingInvoiceViewModel() {}
    public IncomingInvoiceViewModel(final Document document) {
        super(document);
    }

    private String invoiceNumber;

    private Organisation buyer;

    private Organisation seller;

    private LocalDate invoiceDate;

    private LocalDate dueDate;

    private PaymentMethod paymentMethod;

    private String description;

    private Charge charge;

    private LocalDate effectiveStartDate;

    private LocalDate effectiveEndDate;

    private Integer quantity;

    private BigDecimal netAmount;

    private BigDecimal vatAmount;

    private Tax tax;

    private BigDecimal grossAmount;

}