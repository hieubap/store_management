package vn.primary.store.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.primary.store.dao.model.BillFoodEntity;

public interface BillFoodRepository extends JpaRepository<BillFoodEntity,Long> {

}
