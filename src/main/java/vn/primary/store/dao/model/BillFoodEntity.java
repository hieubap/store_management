package vn.primary.store.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "bill_food")
@Entity
public class BillFoodEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long bill_id;
  private Long food_id;

  @OneToOne
  @JoinColumn(name = "food_id", updatable = false, insertable = false)
  private FoodEntity foodEntity;

  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  @JoinColumn(name = "bill_id", insertable = false, updatable = false)
  private BillEntity bill;

  private Long number;
}
