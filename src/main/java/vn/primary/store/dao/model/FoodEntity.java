package vn.primary.store.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.primary.common.dao.model.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "food")
public class FoodEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long price;
}
