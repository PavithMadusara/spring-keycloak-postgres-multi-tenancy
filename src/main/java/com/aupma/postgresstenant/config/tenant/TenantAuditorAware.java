package com.aupma.postgresstenant.config.tenant;


import com.aupma.postgresstenant.config.auditor.AuditorAware;

/**
 * @author Pavith Madusara
 */
public interface TenantAuditorAware extends AuditorAware {

    void setTenantId(Integer tenantId);

}
