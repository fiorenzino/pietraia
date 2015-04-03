package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Foto;
import it.pietraia.repository.FotoRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.FOTO_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FotoRepositoryRs extends RsRepositoryService<Foto>
{

   private static final long serialVersionUID = 1L;

   @Inject
   FotoRepository fotoRepository;

   public FotoRepositoryRs()
   {
   }

   @Inject
   public FotoRepositoryRs(FotoRepository fotoRepository)
   {
      super(fotoRepository);
   }

   @Override
   protected void prePersist(Foto foto) throws Exception
   {

   }

}
