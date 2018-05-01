package hu.restoffice.transaction.service;

import java.math.BigDecimal;
import java.sql.Date;

import hu.restoffice.transaction.domain.DocumentType;
import hu.restoffice.transaction.domain.PaymentMethod;
import hu.restoffice.transaction.entity.AccountingPeriod;
import hu.restoffice.transaction.entity.Income;
import hu.restoffice.transaction.entity.IncomeType;
import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.repository.IncomeRepository;

/**
 *
 */
public class IncomeService extends AbstractCRUDService<Income, IncomeRepository> {


    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.AbstractCRUDService#checkExistence(java.
     * lang.Object)
     */
    @Override
    protected boolean checkExistence(final Income entity) {
        return repo.findByDocIdIgnoreCase(entity.getDocId()).isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.AbstractCRUDService#updateFields(java.lang.
     * Object, java.lang.Object)
     */
    @Override
    protected void updateFields(final Income old, final Income entity) {
        AccountingPeriod ap = entity.getAccPeriod();
        if (ap != null) {
            old.setAccPeriod(ap);
        }
        String desc = entity.getDescription();
        if (desc != null) {
            old.setDescription(desc);;
        }
        String docId = entity.getDocId();
        if (docId != null && docId.trim().length() > 0) {
            old.setDocId(docId);
        }
        DocumentType dt = entity.getDocType();
        if (dt != null) {
            old.setDocType(dt);
        }
        Date exp = entity.getExpiry();
        if (exp != null) {
            old.setExpiry(exp);
        }
        BigDecimal gt = entity.getGrossTotal();
        if (gt != null) {
            old.setGrossTotal(gt);
        }
        IncomeType it = entity.getIncType();
        if (it != null) {
            old.setIncType(it);
        }
        Partner p = entity.getParty();
        if (p != null) {
            old.setParty(p);
        }
        Date pyd = entity.getPayed();
        if (pyd != null) {
            old.setPayed(pyd);
        }
        PaymentMethod pm = entity.getPayMethod();
        if (pm != null) {
            old.setPayMethod(pm);
        }
        Date r = entity.getRegistered();
        if (r != null) {
            old.setRegistered(r);
        }
    }
}
