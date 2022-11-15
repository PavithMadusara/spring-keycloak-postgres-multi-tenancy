package com.aupma.postgresstenant.entity;

import com.aupma.postgresstenant.config.multitenancy.TenantAuditorAware;
import com.aupma.postgresstenant.config.multitenancy.TenantEntityListener;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Pavith Madusara
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners({TenantEntityListener.class})
public abstract class BaseEntity implements TenantAuditorAware {
    @Column
    private Integer tenantId;

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;

    @LastModifiedBy
    protected String updatedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;

}
