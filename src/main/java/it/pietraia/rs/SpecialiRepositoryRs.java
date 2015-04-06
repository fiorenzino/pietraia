package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Speciale;
import it.pietraia.repository.SpecialiRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.SPECIALI_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SpecialiRepositoryRs extends RsRepositoryService<Speciale>
{

   private static final long serialVersionUID = 1L;

   @Inject
   SpecialiRepository specialiRepository;

   public SpecialiRepositoryRs()
   {
   }

   @Inject
   public SpecialiRepositoryRs(SpecialiRepository specialiRepository)
   {
      super(specialiRepository);
   }

   @Override
   protected void prePersist(Speciale speciale) throws Exception
   {

   }

}
