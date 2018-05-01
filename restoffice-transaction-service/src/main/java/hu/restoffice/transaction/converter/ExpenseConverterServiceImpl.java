package hu.restoffice.transaction.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.ExpenseStub;
import hu.restoffice.transaction.domain.ExpenseTypeStub;
import hu.restoffice.transaction.domain.PartnerStub;
import hu.restoffice.transaction.entity.AccountingPeriod;
import hu.restoffice.transaction.entity.Expense;
import hu.restoffice.transaction.entity.ExpenseType;
import hu.restoffice.transaction.entity.Partner;

/**
 *
 */
@Service
public class ExpenseConverterServiceImpl implements ExpenseConverterService {

    @Autowired
    private PartnerConverterService partnerConverter;

    @Autowired
    private ExpenseTypeConverterService expenseTypeConverter;

    private LocalDate initLocalDate(final Date date) {
        return Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.IncomeConverterService#from(hu.restoffice.transaction.entity.Income)
     */
    @Override
    public ExpenseStub from(final Expense expense) {

        LocalDate accStart = initLocalDate(Optional.of(expense.getAccPeriod().getStartDate()).orElse(null));
        LocalDate accEnd = initLocalDate(Optional.of(expense.getAccPeriod().getEndDate()).orElse(null));

        return new ExpenseStub(expense.getId(), expense.getDocId(), from(expense.getParty()), expense.getPayMethod(),
                from(expense.getExpType()), initLocalDate(expense.getRegistered()), initLocalDate(expense.getPayed()),
                expense.getGrossTotal(), initLocalDate(expense.getExpiry()), expense.getDocType(),
                expense.getDescription(),
                accStart, accEnd);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.IncomeConverterService#to(hu.restoffice.transaction.domain.IncomeStub)
     */
    @Override
    public Expense to(final ExpenseStub stub) {
        Expense expense = new Expense();
        expense.setDocId(stub.getDocId());
        expense.setParty(to(stub.getPartner()));
        expense.setPayMethod(stub.getPaymentMethod());
        expense.setExpType(to(stub.getExpenseType()));
        expense.setRegistered(Date.valueOf(stub.getRegistered()));
        expense.setPayed(Date.valueOf(stub.getPayed()));
        expense.setGrossTotal(stub.getGrossTotal());
        expense.setExpiry(Date.valueOf(stub.getExpiry()));
        expense.setDocType(stub.getDocType());
        expense.setDescription(stub.getDescription());
        if (stub.getAccPeriodEnd() != null && stub.getAccPeriodStart() != null) {
            expense.setAccPeriod(
                    new AccountingPeriod(Date.valueOf(stub.getAccPeriodStart()), Date.valueOf(stub.getAccPeriodEnd())));
        }

        return expense;

    }

    private ExpenseType to(final ExpenseTypeStub expType) {
        if (expType != null)
            return expenseTypeConverter.to(expType);
        else
            return null;

    }

    /**
     * @param partner
     * @return
     */
    private Partner to(final PartnerStub partner) {
        if (partner != null)
            return partnerConverter.to(partner);
        else
            return null;

    }

    private ExpenseTypeStub from(final ExpenseType expType) {
        if (expType != null)
            return expenseTypeConverter.from(expType);
        else
            return null;
    }

    /**
     * @param party
     * @return
     */
    private PartnerStub from(final Partner party) {
        if (party != null)
            return partnerConverter.from(party);
        else
            return null;
    }

}
