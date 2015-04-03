package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Foto;
import it.pietraia.model.News;
import it.pietraia.repository.FotoRepository;
import it.pietraia.repository.NewsRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.angcms.api.service.RsRepositoryService;

@Path(AppConstants.NEWS_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NewsRepositoryRs extends RsRepositoryService<News>
{

   private static final long serialVersionUID = 1L;

   @Inject
   NewsRepository newsRepository;

   @Inject
   FotoRepository fotoRepository;

   public NewsRepositoryRs()
   {
   }

   @Inject
   public NewsRepositoryRs(NewsRepository newsRepository)
   {
      super(newsRepository);
   }

   @Override
   protected void prePersist(News news) throws Exception
   {

   }

   @Override
   protected void postFetch(News t)
   {
      if (t == null)
      {
         return;
      }
      t.setImmagini(fotoRepository.getListByForeignKeys(Arrays.asList(t.getId().intValue()), Foto.NEWS_FK));
   }

   @Override
   protected void postList(List<News> list)
   {
      if (list == null || list.size() == 0)
      {
         return;
      }
      Map<Integer, News> map = new HashMap<Integer, News>();
      for (News n : list)
      {
         map.put(n.getId().intValue(), n);
      }
      for (Foto f : fotoRepository.getListByForeignKeys(map.keySet(), Foto.NEWS_FK))
      {
         map.get(f.getId_news()).getImmagini().add(f);
      }
   }
}
