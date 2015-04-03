package it.pietraia.repository;

import it.pietraia.model.Pagina;
import org.angcms.api.repository.Search;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Map;

@Stateless
@LocalBean
public class PagineRepository extends BaseRepository<Pagina>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void applyRestrictions(Search<Pagina> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {
      //id
      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias).append(".id = :ID ");
         params.put("ID", search.getObj().getId());
         separator = " and ";
      }
      //noid
      if (search.getObj().getNoid() != null)
      {
         sb.append(separator).append(alias).append(".id = :NOID ");
         params.put("NOID", search.getObj().getNoid());
         separator = " and ";
      }
      //titolo
      if (search.getObj().getTitolo() != null && !search.getObj().getTitolo().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".titolo ) like :TITOLO ");
         params.put("TITOLO", likeParam(search.getObj().getTitolo().trim().toUpperCase()));
         separator = " and ";
      }
   }

   @Override
   protected String getDefaultOrderBy()
   {
      return "id desc";
   }

}