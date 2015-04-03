package it.pietraia.rs;

import it.pietraia.management.AppConstants;
import it.pietraia.model.Banner;
import it.pietraia.repository.BannerRepository;
import org.angcms.api.service.RsRepositoryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(AppConstants.BANNERS_PATH)
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BannerRepositoryRs extends RsRepositoryService<Banner>
{

   private static final long serialVersionUID = 1L;

   @Inject
   BannerRepository bannerRepository;

   public BannerRepositoryRs()
   {
   }

   @Inject
   public BannerRepositoryRs(BannerRepository bannerRepository)
   {
      super(bannerRepository);
   }

   @Override
   protected void prePersist(Banner banner) throws Exception
   {

   }

}
