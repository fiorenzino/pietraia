package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Pagina;
import it.pietraia.repository.PagineRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.PAGINE_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PagineRepositoryRs extends RsRepositoryService<Pagina>
{

   private static final long serialVersionUID = 1L;

   @Inject
   PagineRepository pagineRepository;

   public PagineRepositoryRs()
   {
   }

   @Inject
   public PagineRepositoryRs(PagineRepository pagineRepository)
   {
      super(pagineRepository);
   }

   @Override
   protected void prePersist(Pagina pagina) throws Exception
   {

   }

}
