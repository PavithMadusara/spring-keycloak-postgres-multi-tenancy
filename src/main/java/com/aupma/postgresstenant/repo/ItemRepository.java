package com.aupma.postgresstenant.repo;

import com.aupma.postgresstenant.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pavith Madusara
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
