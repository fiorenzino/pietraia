package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Catalogo;
import it.pietraia.repository.CataloghiRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.CATALOGHI_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CataloghiRepositoryRs extends RsRepositoryService<Catalogo>
{

   private static final long serialVersionUID = 1L;

   @Inject
   CataloghiRepository cataloghiRepository;

   public CataloghiRepositoryRs()
   {
   }

   @Inject
   public CataloghiRepositoryRs(CataloghiRepository cataloghiRepository)
   {
      super(cataloghiRepository);
   }

   @Override
   protected void prePersist(Catalogo catalogo) throws Exception
   {

   }

}
