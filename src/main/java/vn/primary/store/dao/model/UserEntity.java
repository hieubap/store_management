package vn.primary.store.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.primary.common.dao.model.BaseEntity;

import javax.persistence.*;
import vn.primary.store.enums.RoleEnum;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String name;
    private Integer age;
    private RoleEnum role;

    @Column(name = "phone_number")
    private String phoneNumber;
}
