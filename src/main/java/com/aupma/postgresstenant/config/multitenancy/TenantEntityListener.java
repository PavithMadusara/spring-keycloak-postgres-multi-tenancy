package com.aupma.postgresstenant.config.multitenancy;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @author Pavith Madusara
 */
public class TenantEntityListener {

    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof TenantAuditorAware tenantAuditorAware) {
            tenantAuditorAware.setTenantId(TenantContext.getTenantId());
            tenantAuditorAware.setCreatedAt(new Date());
            tenantAuditorAware.setCreatedBy(AuditorContext.getCurrentUser());
        }
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof TenantAuditorAware tenantAuditorAware) {
            tenantAuditorAware.setTenantId(TenantContext.getTenantId());
            tenantAuditorAware.setUpdatedAt(new Date());
            tenantAuditorAware.setUpdatedBy(AuditorContext.getCurrentUser());
        }
    }

    @PreRemove
    public void preRemove(Object entity) {
        if (entity instanceof TenantAuditorAware tenantAuditorAware) {
            tenantAuditorAware.setTenantId(TenantContext.getTenantId());
        }
    }
}
