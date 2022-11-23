package com.aupma.postgresstenant.entity;

import com.aupma.postgresstenant.config.tenant.TenantEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Pavith Madusara
 */
@Getter
@Setter
@Entity
public class Item extends TenantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String description;
}
