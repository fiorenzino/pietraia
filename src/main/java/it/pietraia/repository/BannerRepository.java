package it.pietraia.repository;

import it.pietraia.model.Banner;
import org.angcms.api.repository.Search;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateless
@LocalBean
public class BannerRepository extends BaseRepository<Banner>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void applyRestrictions(Search<Banner> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias).append(".id = :ID ");
         params.put("ID", search.getObj().getId());
         separator = " and ";
      }

      // nome
      if (search.getObj().getNome() != null && !search.getObj().getNome().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".nome ) like :NOME ");
         params.put("NOME", likeParam(search.getObj().getNome().trim().toUpperCase()));
         separator = " and ";
      }

      // nome
      if (search.getObj().getTipologia() != null && !search.getObj().getTipologia().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".tipologia ) like :TIPOLOGIA ");
         params.put("TIPOLOGIA", likeParam(search.getObj().getTipologia().trim().toUpperCase()));
         separator = " and ";
      }
   }

   @Override
   protected String getDefaultOrderBy()
   {
      return "id desc";
   }

   public List<Banner> getRandom(int num, String tipologia)
   {

      return null;
   }

}