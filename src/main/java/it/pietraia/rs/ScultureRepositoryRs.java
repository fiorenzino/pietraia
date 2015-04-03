package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Foto;
import it.pietraia.model.Scultura;
import it.pietraia.repository.FotoRepository;
import it.pietraia.repository.ScultureRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path(AppConstants.SCULTURE_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ScultureRepositoryRs extends RsRepositoryService<Scultura>
{

   private static final long serialVersionUID = 1L;

   @Inject
   ScultureRepository scultureRepository;

   @Inject
   FotoRepository fotoRepository;

   public ScultureRepositoryRs()
   {
   }

   @Inject
   public ScultureRepositoryRs(ScultureRepository scultureRepository)
   {
      super(scultureRepository);
   }

   @Override
   protected void prePersist(Scultura scultura) throws Exception
   {

   }

   @Override
   protected void postFetch(Scultura t)
   {
      if (t == null)
      {
         return;
      }
      t.setImmagini(fotoRepository.getListByForeignKeys(Arrays.asList(t.getId().intValue()), Foto.SCULTURE_FK));
   }

   @Override
   protected void postList(List<Scultura> list)
   {
      if (list == null || list.size() == 0)
      {
         return;
      }
      Map<Integer, Scultura> map = new HashMap<Integer, Scultura>();
      for (Scultura n : list)
      {
         map.put(n.getId().intValue(), n);
      }
      for (Foto f : fotoRepository.getListByForeignKeys(map.keySet(), Foto.SCULTURE_FK))
      {
         map.get(f.getId_news()).getImmagini().add(f);
      }
   }
}
