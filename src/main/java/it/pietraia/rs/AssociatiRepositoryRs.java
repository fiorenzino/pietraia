package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Associato;
import it.pietraia.repository.AssociatiRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.ASSOCIATI_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AssociatiRepositoryRs extends RsRepositoryService<Associato>
{

   private static final long serialVersionUID = 1L;

   @Inject
   AssociatiRepository associatiRepository;

   public AssociatiRepositoryRs()
   {
   }

   @Inject
   public AssociatiRepositoryRs(AssociatiRepository associatiRepository)
   {
      super(associatiRepository);
   }

   @Override
   protected void prePersist(Associato associato) throws Exception
   {

   }

}
