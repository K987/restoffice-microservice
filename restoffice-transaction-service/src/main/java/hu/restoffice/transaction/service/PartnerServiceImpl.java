package hu.restoffice.transaction.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.error.ServiceException;
import hu.restoffice.transaction.error.ServiceException.Type;
import hu.restoffice.transaction.repository.PartnerRepository;

/**
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PartnerServiceImpl implements PartnerService {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private PartnerRepository repo;

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.service.PartnerService#add(hu.restoffice.
     * transaction.entity.Partner)
     */
    @Override
    public Partner add(final Partner partner) throws ServiceException {
        if (repo.findByNameIgnoreCase(partner.getName()).isPresent()) {
            throw new ServiceException(Type.ALREADY_EXISTS, "partner already exists with the same name", partner);
        } else {
            try {
                return repo.saveAndFlush(partner);
            } catch (Exception e) {
                log.error(e.getLocalizedMessage());
                throw new ServiceException(Type.UNKNOWN, "unknown error occured when saving new partner", partner);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.service.PartnerService#update(hu.restoffice.
     * transaction.entity.Partner)
     */
    @Override
    public Partner update(final Long partnerId, final Partner partner) throws ServiceException {
        Partner old = this.findyById(partnerId);
        update(old, partner);
        try {
            return repo.saveAndFlush(old);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new ServiceException(Type.UNKNOWN, "unknown error occured when updating partner", partner);
        }
    }

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
     * hu.restoffice.transaction.service.PartnerService#findyById(java.lang.Long)
     */
    @Override
    public Partner findyById(final Long partnerId) throws ServiceException {
        return repo.findById(partnerId).orElseThrow(() -> new ServiceException(Type.NOT_EXISTS,
                "partner not exists you might want to create it", partnerId));

    }

    /*
     * (non-Javadoc)
     *
     * @see hu.restoffice.transaction.service.PartnerService#delete(hu.restoffice.
     * transaction.entity.Partner)
     */
    @Override
    public Partner delete(final Long partnerId) throws ServiceException {
        Partner toDel = this.findyById(partnerId);
        try {
            repo.deleteById(partnerId);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            throw new ServiceException(Type.UNKNOWN, "error when deleting partner", partnerId);
        }
        return toDel;
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
            return repo.findAll(technical);
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

    /**
     * @param oldPartner
     * @param newPartner
     */
    private void update(final Partner oldPartner, final Partner newPartner) {
        String name = newPartner.getName();
        if (name != null)
            oldPartner.setName(name);
        String account = newPartner.getAccount();
        if (account != null)
            oldPartner.setAccount(account);
        Boolean technical = newPartner.getParnterTechnical();
        if (technical != null) {
            oldPartner.setParnterTechnical(technical);
        }
    }

}
