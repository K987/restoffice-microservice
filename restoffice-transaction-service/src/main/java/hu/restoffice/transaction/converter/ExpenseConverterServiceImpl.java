package hu.restoffice.transaction.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.ExpenseStub;
import hu.restoffice.transaction.entity.AccountingPeriod;
import hu.restoffice.transaction.entity.CostCenter;
import hu.restoffice.transaction.entity.Expense;
import hu.restoffice.transaction.entity.ExpenseType;
import hu.restoffice.transaction.entity.Partner;

/**
 *
 */
@Service
public class ExpenseConverterServiceImpl implements ExpenseConverterService {

    private LocalDate initLocalDate(final Date date) {
        return Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.IncomeConverterService#from(hu.restoffice.transaction.entity.Income)
     */
    @Override
    public ExpenseStub from(final Expense expense) {

        LocalDate accStart = null;
        LocalDate accEnd = null;

        if (Hibernate.isInitialized(expense.getAccPeriod()) && expense.getAccPeriod() != null) {
            accStart = initLocalDate(expense.getAccPeriod().getStartDate());
            accEnd = initLocalDate(expense.getAccPeriod().getEndDate());
        }
        String partnerName = null;
        Long partnerId = null;
        if (Hibernate.isInitialized(expense.getParty()) && expense.getParty() != null) {
            partnerName = expense.getParty().getName();
            partnerId = expense.getParty().getId();
        }

        String expTypeName = null;
        Long expTypeId = null;
        if (Hibernate.isInitialized(expense.getExpType()) && expense.getExpType() != null) {
            expTypeName = expense.getExpType().getName();
            expTypeId = expense.getExpType().getId();
        }

        String ccName = null;
        Long ccId = null;
        if (Hibernate.isInitialized(expense.getCostCenter()) && expense.getCostCenter() != null) {
            ccName = expense.getCostCenter().getName();
            ccId = expense.getCostCenter().getId();
        }

        return new ExpenseStub(expense.getId(), expense.getDocId(), expense.getDocType(), partnerName, partnerId,
                expense.getPayMethod(), expense.getGrossTotal(), expense.getDescription(),
                initLocalDate(expense.getRegistered()), initLocalDate(expense.getExpiry()),
                initLocalDate(expense.getPayed()), accStart, accEnd, expTypeName, expTypeId, ccName, ccId);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.IncomeConverterService#to(hu.restoffice.transaction.domain.IncomeStub)
     */
    @Override
    public Expense to(final ExpenseStub stub) {
        Expense expense = new Expense();
        ExpenseType et = new ExpenseType();
        et.setName(stub.getExpenseType());
        expense.setExpType(et);

        CostCenter cc = new CostCenter();
        cc.setName(stub.getCostCenter());
        expense.setCostCenter(cc);

        Partner p = new Partner();
        p.setName(stub.getPartnerName());
        expense.setParty(p);

        expense.setDescription(stub.getDescription());
        expense.setDocId(stub.getDocId());
        expense.setDocType(stub.getDocType());
        if (stub.getExpiry() != null)
            expense.setExpiry(Date.valueOf(stub.getExpiry()));
        expense.setGrossTotal(stub.getGrossTotal());
        if (stub.getPayed() != null)
            expense.setPayed(Date.valueOf(stub.getPayed()));
        expense.setPayMethod(stub.getPayMethod());
        if (stub.getRegistered() != null)
            expense.setRegistered(Date.valueOf(stub.getRegistered()));
        expense.setDescription(stub.getDescription());
        if (stub.getAccPeriodEnd() != null && stub.getAccPeriodStart() != null) {
            expense.setAccPeriod(
                    new AccountingPeriod(Date.valueOf(stub.getAccPeriodStart()), Date.valueOf(stub.getAccPeriodEnd())));
        }

        return expense;

    }



}
