package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Biografia;
import it.pietraia.repository.BiografieRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.BIOGRAFIE_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BiografieRepositoryRs extends RsRepositoryService<Biografia>
{

   private static final long serialVersionUID = 1L;

   @Inject
   BiografieRepository biografieRepository;

   public BiografieRepositoryRs()
   {
   }

   @Inject
   public BiografieRepositoryRs(BiografieRepository biografieRepository)
   {
      super(biografieRepository);
   }

   @Override
   protected void prePersist(Biografia biografia) throws Exception
   {

   }

}
