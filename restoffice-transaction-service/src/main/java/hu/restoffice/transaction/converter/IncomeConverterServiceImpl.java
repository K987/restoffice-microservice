package hu.restoffice.transaction.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.IncomeStub;
import hu.restoffice.transaction.entity.AccountingPeriod;
import hu.restoffice.transaction.entity.Income;
import hu.restoffice.transaction.entity.IncomeType;
import hu.restoffice.transaction.entity.Partner;

/**
 *
 */
@Service
public class IncomeConverterServiceImpl implements IncomeConverterService {


    private LocalDate initLocalDate(final Date date) {
        return Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);
    }

    @Override
    public IncomeStub from(final Income income) {

        LocalDate accStart = null;
        LocalDate accEnd = null;

        if (Hibernate.isInitialized(income.getAccPeriod()) && income.getAccPeriod() != null) {
            accStart = initLocalDate(income.getAccPeriod().getStartDate());
            accEnd = initLocalDate(income.getAccPeriod().getEndDate());
        }
        String partnerName = null;
        Long partnerId = null;
        if (Hibernate.isInitialized(income.getParty()) && income.getParty() != null) {
            partnerName = income.getParty().getName();
            partnerId = income.getParty().getId();
        }

        String incTypeName = null;
        Long incTypeId = null;
        if (Hibernate.isInitialized(income.getIncType()) && income.getIncType() != null) {
            incTypeName = income.getIncType().getName();
            incTypeId = income.getIncType().getId();
        }


        return new IncomeStub(income.getId(), income.getDocId(), income.getDocType(), partnerName, partnerId,
                income.getPayMethod(), income.getGrossTotal(), income.getDescription(),
                initLocalDate(income.getRegistered()), initLocalDate(income.getExpiry()),
                initLocalDate(income.getPayed()), accStart, accEnd, incTypeName, incTypeId);
    }

    @Override
    public Income to(final IncomeStub stub) {
        Income income = new Income();
        IncomeType et = new IncomeType();
        et.setName(stub.getIncomeType());
        income.setIncType(et);

        Partner p = new Partner();
        p.setName(stub.getPartnerName());
        income.setParty(p);

        income.setDescription(stub.getDescription());
        income.setDocId(stub.getDocId());
        income.setDocType(stub.getDocType());
        if (stub.getExpiry() != null)
            income.setExpiry(Date.valueOf(stub.getExpiry()));
        income.setGrossTotal(stub.getGrossTotal());
        if (stub.getPayed() != null)
            income.setPayed(Date.valueOf(stub.getPayed()));
        income.setPayMethod(stub.getPayMethod());
        if (stub.getRegistered() != null)
            income.setRegistered(Date.valueOf(stub.getRegistered()));
        income.setDescription(stub.getDescription());
        if (stub.getAccPeriodEnd() != null && stub.getAccPeriodStart() != null) {
            income.setAccPeriod(
                    new AccountingPeriod(Date.valueOf(stub.getAccPeriodStart()), Date.valueOf(stub.getAccPeriodEnd())));
        }

        return income;
    }


}
