package memp.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import memp.EmpApplication;
import memp.domain.UserAdd;
import org.springframework.context.ApplicationContext;

@Entity
@Table(name = "Users_table")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uxid;

    private String tenantId;

    private String useStatus;

    private String id;

    private String pass;

    private String userName;

    private String createdBy;

    private Date createTm;

    private String lastModiBy;

    private Date lastModiTm;

    private String phoneNo;

    private String enterDt;

    private String managerId;

    @Embedded
    private RankId rankId;

    @Embedded
    private DepartmentId departmentId;

    @PostPersist
    public void onPostPersist() {
        UserAdd userAdd = new UserAdd(this);
        userAdd.publishAfterCommit();
    }

    public static UsersRepository repository() {
        UsersRepository usersRepository = applicationContext()
            .getBean(UsersRepository.class);
        return usersRepository;
    }

    public static ApplicationContext applicationContext() {
        return EmpApplication.applicationContext;
    }
}
