package com.aupma.postgresstenant.config.multitenancy;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Pavith Madusara
 */
@Slf4j
public final class AuditorContext {

    public static String getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext != null && securityContext.getAuthentication() != null) {
            Object principal = securityContext.getAuthentication().getPrincipal();
            if (principal instanceof KeycloakPrincipal<?> keycloakPrincipal) {
                String userId = keycloakPrincipal.getKeycloakSecurityContext().getToken().getId();
                if (userId != null) {
                    return userId;
                } else {
                    log.error("TenantId is not an Integer");
                    throw new RuntimeException("TenantId is not an Integer or null");
                }
            } else {
                log.warn("Principal is not KeycloakPrincipal");
                throw new RuntimeException("Principal is not KeycloakPrincipal");
            }
        } else {
            log.warn("Security Context is null");
            throw new RuntimeException("Security Context is null");
        }
    }

}
