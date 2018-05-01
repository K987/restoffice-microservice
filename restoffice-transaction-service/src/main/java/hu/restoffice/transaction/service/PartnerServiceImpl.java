package hu.restoffice.transaction.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.entity.PartnerContact;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.error.ServiceException.Type;
import hu.restoffice.transaction.repository.PartnerRepository;

/**
 *
 */
@Service
public class PartnerServiceImpl extends AbstractCRUDService<Partner, PartnerRepository> implements PartnerService {


    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.PartnerService#findByName(java.lang.String)
     */
    @Override
    public Partner findByName(final String partnerName) throws ServiceException {
        return repo.findByNameIgnoreCase(partnerName).orElseThrow(() -> new ServiceException(Type.NOT_EXISTS,
                "partner not exists you might want to create it", partnerName));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.PartnerService#findAll(java.lang.Boolean)
     */
    @Override
    public List<Partner> findAll(final Boolean technical) throws ServiceException {
        if (technical == null) {
            return repo.findAll();
        } else {
            return repo.findByTechnical(technical);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.service.PartnerService#deleteUnused()
     */
    @Override
    public List<Partner> deleteUnused() throws ServiceException {
        throw new UnsupportedOperationException("operation not yet implemented");
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.service.PartnerService#serachByName(java.lang.
     * String)
     */
    @Override
    public List<Partner> serachByName(final String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.PartnerService#getContactById(java.lang.
     * Long)
     */
    @Override
    public PartnerContact getContact(final Long partnerId) throws ServiceException {
        return repo.findContactByPartnerId(partnerId)
                .orElseThrow(() -> new ServiceException(Type.NOT_EXISTS, "contact not exists", partnerId));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.PartnerService#updateContact(java.lang.
     * Long, hu.restoffice.transaction.entity.PartnerContact)
     */
    @Override
    public Partner updateContact(final Long id, final PartnerContact contact) throws ServiceException {
        Partner p = this.findById(id);
        p.setContact(contact);
        return saveAndFlush(p);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.PartnerService#deleteContactId(java.lang.
     * Long)
     */
    @Override
    public Partner deleteContact(final Long partnerId) throws ServiceException {
        Partner p = this.findById(partnerId);
        p.setContact(null);
        return saveAndFlush(p);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.AbstractCRUDService#checkExistence(java.
     * lang.Object)
     */
    @Override
    protected boolean checkExistence(final Partner entity) {
        return repo.findByNameIgnoreCase(entity.getName()).isPresent();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.service.AbstractCRUDService#updateFields(java.lang.
     * Object, java.lang.Object)
     */
    @Override
    protected void updateFields(final Partner old, final Partner entity) {
        String name = entity.getName();
        if (name != null)
            old.setName(name);
        String account = entity.getAccount();
        if (account != null)
            old.setAccount(account);
        Boolean technical = entity.isTechnical();
        if (technical != null) {
            old.setTechnical(technical);
        }

    }

}
