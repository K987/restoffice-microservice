package hu.restoffice.transaction.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hu.restoffice.transaction.converter.ExpenseConverterService;
import hu.restoffice.transaction.domain.ExpenseStub;
import hu.restoffice.transaction.entity.Expense;

/**
 *
 */
public class TestController extends AbstractRestController<ExpenseStub> {

    @Autowired
    private ExpenseConverterService converter;

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#from(java.lang.
     * Object)
     */
    @Override
    protected ExpenseStub from(final Object object) {

        return converter.from(((Expense) object));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#findAllEntity()
     */
    @Override
    protected List<Object> findAllEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#to(java.lang.
     * Object)
     */
    @Override
    protected Object to(final ExpenseStub stub) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#delete(java.lang.
     * Long)
     */
    @Override
    protected Object delete(final Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#findById(java.
     * lang.Long)
     */
    @Override
    protected Object findById(final Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#update(java.lang.
     * Long, java.lang.Object)
     */
    @Override
    protected Object update(final Long id, final Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#create(java.lang.
     * Object)
     */
    @Override
    protected Object create(final Object o) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hu.restoffice.transaction.controller.AbstractRestController#createSourceUri(
     * java.lang.Object)
     */
    @Override
    protected URI createSourceUri(final Object o) {
        // TODO Auto-generated method stub
        return null;
    }

}
