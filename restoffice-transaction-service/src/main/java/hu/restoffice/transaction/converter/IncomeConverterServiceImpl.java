package hu.restoffice.transaction.converter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.IncomeStub;
import hu.restoffice.transaction.domain.IncomeTypeStub;
import hu.restoffice.transaction.domain.PartnerStub;
import hu.restoffice.transaction.entity.AccountingPeriod;
import hu.restoffice.transaction.entity.Income;
import hu.restoffice.transaction.entity.IncomeType;
import hu.restoffice.transaction.entity.Partner;

/**
 *
 */
@Service
public class IncomeConverterServiceImpl implements IncomeConverterService {

    @Autowired
    private PartnerConverterService partnerConverter;

    @Autowired
    private IncomeTypeConverterService incomeTypeConverter;

    private LocalDate initLocalDate(final Date date) {
        return Optional.ofNullable(date).map(Date::toLocalDate).orElse(null);
    }

    @Override
    public IncomeStub from(final Income income) {

        LocalDate accStart = initLocalDate(Optional.of(income.getAccPeriod().getStartDate()).orElse(null));
        LocalDate accEnd = initLocalDate(Optional.of(income.getAccPeriod().getEndDate()).orElse(null));

        return new IncomeStub(income.getId(), income.getDocId(), from(income.getParty()), income.getPayMethod(),
                from(income.getIncType()), initLocalDate(income.getRegistered()), initLocalDate(income.getPayed()),
                income.getGrossTotal(), initLocalDate(income.getExpiry()), income.getDocType(), income.getDescription(),
                accStart, accEnd);
    }

    @Override
    public Income to(final IncomeStub stub) {
        Income income = new Income();
        income.setDocId(stub.getDocId());
        income.setParty(to(stub.getPartner()));
        income.setPayMethod(stub.getPaymentMethod());
        income.setIncType(to(stub.getIncomeType()));
        income.setRegistered(Date.valueOf(stub.getRegistered()));
        income.setPayed(Date.valueOf(stub.getPayed()));
        income.setGrossTotal(stub.getGrossTotal());
        income.setExpiry(Date.valueOf(stub.getExpiry()));
        income.setDocType(stub.getDocType());
        income.setDescription(stub.getDescription());
        if (stub.getAccPeriodEnd() != null && stub.getAccPeriodStart() != null) {
            income.setAccPeriod(
                    new AccountingPeriod(Date.valueOf(stub.getAccPeriodStart()), Date.valueOf(stub.getAccPeriodEnd())));
        }

        return income;

    }

    /**
     * @param incType
     * @return
     */
    private IncomeType to(final IncomeTypeStub incType) {
        if (incType != null)
            return incomeTypeConverter.to(incType);
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

    /**
     * @param incType
     * @return
     */
    private IncomeTypeStub from(final IncomeType incType) {
        if (incType != null)
            return incomeTypeConverter.from(incType);
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
