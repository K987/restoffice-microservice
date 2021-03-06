package hu.restoffice.cashregister.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.cashregister.entity.Register;
import hu.restoffice.cashregister.entity.RegisterClose;
import hu.restoffice.cashregister.repository.RegisterCloseRepository;
import hu.restoffice.commons.error.ServiceException;
import hu.restoffice.commons.service.AbstractCRUDService;

/**
 *
 */
@Service
public class RegisterCloseServiceImpl extends AbstractCRUDService<RegisterClose, RegisterCloseRepository>
implements RegisterCloseService {

    @Autowired
    private RegisterService service;
    /* (non-Javadoc)
     * @see hu.restoffice.commons.AbstractCRUDService#add(java.lang.Object)
     */
    @Override
    public RegisterClose add(final RegisterClose entity) throws ServiceException {
        Register r = service.findByRegistrationNo(entity.getRegister().getRegistrationNo());
        entity.setRegister(r);
        return super.add(entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.AbstractCRUDService#update(java.lang.Long,
     * java.lang.Object)
     */
    @Override
    public RegisterClose update(final Long id, final RegisterClose entity) throws ServiceException {
        Register r = service.findByRegistrationNo(entity.getRegister().getRegistrationNo());
        entity.setRegister(r);
        return super.update(id, entity);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.commons.AbstractCRUDService#checkExistence(java.lang.Object)
     */
    @Override
    protected boolean checkExistence(final RegisterClose entity) throws ServiceException {
        return repo
                .findByCloseNoAndRegister_RegistrationNo(entity.getCloseNo(), entity.getRegister().getRegistrationNo())
                .isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.commons.AbstractCRUDService#updateFields(java.lang.Object,
     * java.lang.Object)
     */
    @Override
    protected void updateFields(final RegisterClose old, final RegisterClose entity) {
        Date d = entity.getCloseDate();
        if (d != null)
            old.setCloseDate(d);
        Long n = entity.getCloseNo();
        if (n != null)
            old.setCloseNo(n);
        BigDecimal a = entity.getClosingAmount();
        if (a != null)
            old.setClosingAmount(a);
        Register r = entity.getRegister();
        if (r != null)
            old.setRegister(r);
    }

    /* (non-Javadoc)
     * @see hu.restoffice.commons.service.AbstractCRUDService#isDeletable(java.lang.Object)
     */
    @Override
    protected boolean isDeletable(final Long id) throws ServiceException {
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.service.RegisterCloseService#getClosesByDate(java.
     * time.LocalDate)
     */
    @Override
    public List<RegisterClose> getClosesByDate(final LocalDate day) throws ServiceException {
        return repo.findByCloseDate(Date.valueOf(day));
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.cashregister.service.RegisterCloseService#getLastCloses()
     */
    @Override
    public List<RegisterClose> getLastCloses() throws ServiceException {
        return repo.findLastCloses();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.cashregister.service.RegisterCloseService#getClosesBetweenDate(
     * java.time.LocalDate, java.time.LocalDate)
     */
    @Override
    public List<RegisterClose> getClosesBetweenDate(final LocalDate form, final LocalDate to) throws ServiceException {
        return repo.findByCloseDateBetween(Date.valueOf(form), Date.valueOf(to));
    }

}
