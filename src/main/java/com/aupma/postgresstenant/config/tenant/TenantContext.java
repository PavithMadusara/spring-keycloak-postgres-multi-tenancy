package com.aupma.postgresstenant.config.tenant;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Pavith Madusara
 */
@Slf4j
public final class TenantContext {
    public static Integer getTenantId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext != null && securityContext.getAuthentication() != null) {
            Object principal = securityContext.getAuthentication().getPrincipal();
            if (principal instanceof KeycloakPrincipal<?> keycloakPrincipal) {
                Object tenantId = keycloakPrincipal.getKeycloakSecurityContext().getToken().getOtherClaims().get("tenantId");
                if (tenantId instanceof Integer) {
                    return (Integer) tenantId;
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
