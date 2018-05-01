package hu.restoffice.transaction.converter;

import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.ExpenseTypeStub;
import hu.restoffice.transaction.entity.ExpenseType;

/**
 *
 */
@Service
public class ExpenseTypeConverterServiceImpl implements ExpenseTypeConverterService {

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.ConverterServiceDefault#from(java.lang.Object)
     */
    @Override
    public ExpenseTypeStub from(final ExpenseType entity) {
        return new ExpenseTypeStub(entity.getId(), entity.getName(), entity.isProdRelated());
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.converter.ConverterServiceDefault#to(java.lang.Object)
     */
    @Override
    public ExpenseType to(final ExpenseTypeStub stub) {
        ExpenseType e = new ExpenseType();
        e.setName(stub.getName());
        e.setProdRelated(stub.getProdRelated());
        return e;
    }

}
