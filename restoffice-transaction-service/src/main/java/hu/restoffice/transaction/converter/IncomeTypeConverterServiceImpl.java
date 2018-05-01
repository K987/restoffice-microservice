package hu.restoffice.transaction.converter;

import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.IncomeTypeStub;
import hu.restoffice.transaction.entity.IncomeType;

/**
 *
 */
@Service
public class IncomeTypeConverterServiceImpl implements IncomeTypeConverterService {

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.IncomeTypeConverterService#from(hu.restoffice.transaction.entity.IncomeType)
     */
    @Override
    public IncomeTypeStub from(final IncomeType incType) {
        return new IncomeTypeStub(incType.getId(), incType.getName(), incType.isProdRelated());
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.IncomeTypeConverterService#to(hu.restoffice.transaction.domain.IncomeTypeStub)
     */
    @Override
    public IncomeType to(final IncomeTypeStub stub) {
        IncomeType type = new IncomeType();
        type.setName(stub.getName());
        type.setProdRelated(stub.isProdRelated());

        return type;
    }

}
