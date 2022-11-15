package com.aupma.postgresstenant.config.multitenancy;

import java.util.Date;

/**
 * @author Pavith Madusara
 */
public interface TenantAuditorAware {

    Integer getTenantId();

    void setTenantId(Integer tenantId);

    void setCreatedAt(Date createdAt);

    void setUpdatedAt(Date updatedAt);

    void setCreatedBy(String createdBy);

    void setUpdatedBy(String updatedBy);

}
