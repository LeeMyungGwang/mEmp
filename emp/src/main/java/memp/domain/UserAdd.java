package memp.domain;

import java.util.*;
import lombok.*;
import memp.domain.*;
import memp.infra.AbstractEvent;

@Data
@ToString
public class UserAdd extends AbstractEvent {

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

    public UserAdd(Users aggregate) {
        super(aggregate);
    }

    public UserAdd() {
        super();
    }
}
