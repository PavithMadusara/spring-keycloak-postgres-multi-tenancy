package com.aupma.postgresstenant.config.auditor;

import java.util.Date;

/**
 * @author Pavith Madusara
 */
public interface AuditorAware {

    void setCreatedAt(Date createdAt);

    void setUpdatedAt(Date updatedAt);

    void setCreatedBy(String createdBy);

    void setUpdatedBy(String updatedBy);

    void setDeletedBy(String deletedBy);

}
