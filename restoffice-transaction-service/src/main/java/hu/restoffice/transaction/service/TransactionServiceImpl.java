package hu.restoffice.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.restoffice.transaction.properties.ServiceProperties;

/**
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private ServiceProperties properties;

    /**
     * @return
     */
    @Override
    public String getMessage(final String ez, final String az) {
        return properties.getMassage();
    }
}
