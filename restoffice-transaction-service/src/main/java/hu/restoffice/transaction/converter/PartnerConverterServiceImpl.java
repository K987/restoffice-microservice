package hu.restoffice.transaction.converter;

import java.util.Optional;

import org.springframework.stereotype.Service;

import hu.restoffice.transaction.domain.PartnerStub;
import hu.restoffice.transaction.entity.Partner;
import hu.restoffice.transaction.entity.PartnerContact;

/**
 *
 */
@Service
public class PartnerConverterServiceImpl implements PartnerConverterService {

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.converter.ConverterServiceDefault#from(java.lang.
     * Object)
     */
    @Override
    public PartnerStub from(final Partner entity) {
        Optional<PartnerContact> contact = Optional.ofNullable(entity.getContact());
        String contactName = contact.map(PartnerContact::getName).orElse(null);
        String contactPhone = contact.map(PartnerContact::getPhone).orElse(null);
        String contactEmail = contact.map(PartnerContact::getEmail).orElse(null);
        return new PartnerStub(entity.getId(), entity.getName(), entity.getAccount(), contactName, contactPhone,
                contactEmail, entity.isTechnical());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.converter.ConverterServiceDefault#to(java.lang.
     * Object)
     */
    @Override
    public Partner to(final PartnerStub stub) {
        Partner partner = new Partner();
        partner.setName(stub.getName());
        partner.setAccount(stub.getAccount());
        partner.setTechnical(stub.getTechnical());
        if (stub.getContactEmail() != null || stub.getContactPhone() != null || stub.getContactName() != null) {
            partner.setContact(
                    new PartnerContact(stub.getContactName(), stub.getContactEmail(), stub.getContactPhone()));
        }
        return partner;
    }

}
