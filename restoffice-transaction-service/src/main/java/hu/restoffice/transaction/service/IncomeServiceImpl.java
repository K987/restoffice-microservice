package hu.restoffice.transaction.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.error.ServiceException.Type;
import hu.restoffice.commons.service.AbstractCRUDService;
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
@Service
public class IncomeServiceImpl extends AbstractCRUDService<Income, IncomeRepository> implements IncomeService {

    @Autowired
    private IncomeTypeService incomeTypeService;

    @Autowired
    private PartnerService partnerService;

    @Override
    public Income add(final Income entity) throws ServiceException {

        setRelations(entity);
        return super.add(entity);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.IncomeService#searchByExample(hu.restoffice.transaction.entity.Income)
     */
    @Override
    public List<Income> searchByExample(final Income income) throws ServiceException{
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
        Example<Income> e = Example.of(income, matcher);
        return repo.findAll(e);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.IncomeService#findyByDocId(java.lang.String)
     */
    @Override
    public Income findyByDocId(final String docId) throws ServiceException {
        return repo.findByDocIdIgnoreCase(docId)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, "requested docId not exists", docId));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.AbstractCRUDService#update(java.lang.Long,
     * java.lang.Object)
     */
    @Override
    public Income update(final Long id, final Income entity) throws ServiceException {
        setRelations(entity);
        return super.update(id, entity);
    }

    private void setRelations(final Income entity) throws ServiceException {
        IncomeType incType = incomeTypeService.findByName(entity.getIncType().getName());
        Partner partner = partnerService.findByName(entity.getParty().getName());
        entity.setIncType(incType);
        entity.setParty(partner);
    }
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
            old.setDescription(desc);
            ;
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * hu.restoffice.commons.service.AbstractCRUDService#isDeletable(java.lang.Long)
     */
    @Override
    protected boolean isDeletable(final Long id) throws ServiceException {
        return false;
    }

}
