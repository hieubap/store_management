package vn.primary.store.dao.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.primary.common.dao.model.BaseEntity;
import vn.primary.store.enums.OrderStatusEnum;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "bill_status")
  private OrderStatusEnum status;

  @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private List<BillFoodEntity> listFoods;

  private Long total;

  @OneToOne
  @JoinColumn(name = "id_user")
  private UserEntity userEntity;

}
