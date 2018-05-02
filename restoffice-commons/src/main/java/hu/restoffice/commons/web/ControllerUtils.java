package hu.restoffice.commons.web;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 */
public class ControllerUtils {

    // public static URI createPathTo(final String pathToResource, final Long
    // resourceId) {
    // }

    public static URI createPathTo(final Long resourceId) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resourceId).toUri();
        // return createPathTo("/{id}", resourceId);
    }
}
