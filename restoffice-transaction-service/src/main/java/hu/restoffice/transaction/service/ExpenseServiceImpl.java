package hu.restoffice.transaction.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.DocumentType;
import hu.restoffice.transaction.domain.PaymentMethod;
import hu.restoffice.transaction.entity.AccountingPeriod;
import hu.restoffice.transaction.entity.Expense;
import hu.restoffice.transaction.entity.ExpenseType;
import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.error.ServiceException.Type;
import hu.restoffice.transaction.repository.ExpenseRepository;

/**
 *
 */
@Service
public class ExpenseServiceImpl extends AbstractCRUDService<Expense, ExpenseRepository> implements ExpenseService {

    @Autowired
    private ExpenseTypeService expenseTypeService;

    @Autowired
    private PartnerService partnerService;

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#add(hu.restoffice.transaction.entity.Expense)
     */
    @Override
    public Expense add(final Expense entity) throws ServiceException {

        setRelations(entity);
        return super.add(entity);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#searchByExample(hu.restoffice.transaction.entity.Expense)
     */
    @Override
    public List<Expense> searchByExample(final Expense expense) throws ServiceException {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
        Example<Expense> e = Example.of(expense, matcher);
        return repo.findAll(e);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#findyByDocId(java.lang.String)
     */
    @Override
    public Expense findyByDocId(final String docId) throws ServiceException {
        return repo.findByDocIdIgnoreCase(docId)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, "requested docId not exists", docId));
    }

    /* (non-Javadoc)
     * @see hu.restoffice.transaction.service.ExpenseSerivce#update(java.lang.Long, hu.restoffice.transaction.entity.Expense)
     */
    @Override
    public Expense update(final Long id, final Expense entity) throws ServiceException {
        setRelations(entity);
        return super.update(id, entity);
    }

    private void setRelations(final Expense entity) throws ServiceException {
        ExpenseType incType = expenseTypeService.findByName(entity.getExpType().getName());
        Partner partner = partnerService.findByName(entity.getParty().getName());
        entity.setExpType(incType);
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
    protected boolean checkExistence(final Expense entity) {
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
    protected void updateFields(final Expense old, final Expense entity) {
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
        ExpenseType et = entity.getExpType();
        if (et != null) {
            old.setExpType(et);
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
