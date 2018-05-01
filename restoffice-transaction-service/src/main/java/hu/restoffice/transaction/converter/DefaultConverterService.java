package hu.restoffice.transaction.converter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public interface DefaultConverterService<E, S> {

    S from(E entity);

    E to(S stub);

    default List<S> from(final List<E> entity) {
        List<S> stubs = new ArrayList<>();
        entity.forEach(e -> stubs.add(from(e)));
        return stubs;
    }

    default List<E> to(final List<S> stubs) {
        List<E> enitites = new ArrayList<>();
        stubs.forEach(e -> enitites.add(to(e)));
        return enitites;
    }

}
