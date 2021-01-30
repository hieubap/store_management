package vn.primary.store.dao.model.dashboard;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@Subselect("")
@Immutable
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
        name = "billByDate",
        procedureName = "bill_by_date",
        resultClasses = {DashboardBillEntity.class},
        parameters = {
            @StoredProcedureParameter(
                name = "from_date",
                type = ZonedDateTime.class,
                mode = ParameterMode.IN),
            @StoredProcedureParameter(
                name = "to_date",
                type = ZonedDateTime.class,
                mode = ParameterMode.IN)
        })
})
@Getter
@Setter
@NoArgsConstructor
public class DashboardBillEntity {

  @Id
  private Long id;

  private Integer month;

  private Integer year;

  private Long quantity;
}
