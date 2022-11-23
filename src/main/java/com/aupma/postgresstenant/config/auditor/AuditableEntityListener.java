package com.aupma.postgresstenant.config.auditor;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * @author Pavith Madusara
 */
public class AuditableEntityListener {

    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof AuditorAware auditorAware) {
            auditorAware.setCreatedAt(new Date());
            auditorAware.setCreatedBy(AuditorContext.getCurrentUser());
        }
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof AuditorAware auditorAware) {
            auditorAware.setUpdatedAt(new Date());
            auditorAware.setUpdatedBy(AuditorContext.getCurrentUser());
        }
    }

    @PreRemove
    public void preRemove(Object entity) {
        if (entity instanceof AuditorAware auditorAware) {
            // set deletedAt is handled by @SqlDelete annotation
            auditorAware.setDeletedBy(AuditorContext.getCurrentUser());
        }
    }
}
