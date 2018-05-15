package hu.restoffice.dailyclose.converter;

import org.hibernate.Hibernate;

import hu.restoffice.dailyclose.domain.ShiftDailyCloseStub;
import hu.restoffice.dailyclose.entity.ShiftDailyClose;

/**
 *
 */
public class ShiftDailyCloseConverterImpl implements ShiftDailyCloseConverter {

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#from(java.lang.Object)
     */
    @Override
    public ShiftDailyCloseStub from(final ShiftDailyClose entity) {

        Long dailyCloseId = getDailyCloseId(entity);

        return new ShiftDailyCloseStub(entity.getId(), entity.getEmployeeId(), entity.getEmployeeName(),
                entity.getCashTotal(), entity.getCardTotal(), entity.getPosTotal(), dailyCloseId);
    }

    /**
     * @param entity
     * @return
     */
    private Long getDailyCloseId(final ShiftDailyClose entity) {
        if (Hibernate.isInitialized(entity.getDailyClose()) && entity.getDailyClose() != null) {
            return entity.getDailyClose().getId();
        } else {
            return null;
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.service.DefaultConverterService#to(java.lang.Object)
     */
    @Override
    public ShiftDailyClose to(final ShiftDailyCloseStub stub) {
        ShiftDailyClose sdc = new ShiftDailyClose();
        sdc.setCardTotal(stub.getCardTotal());
        sdc.setCashTotal(stub.getCashTotal());
        sdc.setPosTotal(stub.getPosTotal());
        sdc.setEmployeeId(sdc.getEmployeeId());
        sdc.setEmployeeName(stub.getEmployeeName());
        return sdc;
    }

}
