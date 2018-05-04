package hu.restoffice.transaction.converter;

import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.CostCenterStub;
import hu.restoffice.transaction.entity.CostCenter;

/**
 *
 */
@Service
public class CostCenterConverterServiceImpl implements CostCenterConverterService {

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.converter.ConverterServiceDefault#from(java.lang.
     * Object)
     */
    @Override
    public CostCenterStub from(final CostCenter entity) {
        return new CostCenterStub(entity.getId(), entity.isDefault(), entity.getName());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.converter.ConverterServiceDefault#to(java.lang.
     * Object)
     */
    @Override
    public CostCenter to(final CostCenterStub stub) {
        CostCenter costCenter = new CostCenter();
        costCenter.setDefault(stub.getDefaultCostCenter());
        costCenter.setName(stub.getName());

        return costCenter;

    }

}
