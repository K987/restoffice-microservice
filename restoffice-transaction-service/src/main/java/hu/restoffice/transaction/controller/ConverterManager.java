package hu.restoffice.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.transaction.converter.CostCenterConverterServiceImpl;
import hu.restoffice.transaction.domain.CostCenterStub;

/**
 *
 */
@Service
public class ConverterManager {

    @Autowired
    private CostCenterConverterServiceImpl costCenterConverter;

    /**
     * @param body
     * @return
     */
    public <S> Object convert(final Object body) {
        return costCenterConverter.to((CostCenterStub) body);
    }

}
