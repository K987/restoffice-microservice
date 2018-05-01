package hu.restoffice.transaction.controller.util;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 */
public class ControllerUtils {

    public static URI createPathTo(final String pathToResource, final Long resourceId) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path(pathToResource).buildAndExpand(resourceId).toUri();
    }

    public static URI createPathTo(final Long resourceId) {
        return createPathTo("/{id}", resourceId);
    }
}
