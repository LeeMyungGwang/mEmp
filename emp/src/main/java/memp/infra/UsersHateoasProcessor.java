package memp.infra;

import memp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class UsersHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Users>> {

    @Override
    public EntityModel<Users> process(EntityModel<Users> model) {
        return model;
    }
}
