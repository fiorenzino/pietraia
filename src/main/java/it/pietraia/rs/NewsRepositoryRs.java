package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.News;
import it.pietraia.repository.NewsRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.NEWS_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NewsRepositoryRs extends RsRepositoryService<News>
{

   private static final long serialVersionUID = 1L;

   @Inject
   NewsRepository newsRepository;

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

}
