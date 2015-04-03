package it.pietraia.repository;

import it.pietraia.model.News;
import org.angcms.api.repository.Search;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Map;

@Stateless
@LocalBean
public class NewsRepository extends BaseRepository<News>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void applyRestrictions(Search<News> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias).append(".id = :ID ");
         params.put("ID", search.getObj().getId());
         separator = " and ";
      }
      //nome
      if (search.getObj().getNome() != null && !search.getObj().getNome().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".nome ) like :NOME ");
         params.put("NOME", likeParam(search.getObj().getNome().trim().toUpperCase()));
         separator = " and ";
      }

      //titolo
      if (search.getObj().getOggetto() != null && !search.getObj().getOggetto().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".oggetto ) like :OGGETTO ");
         params.put("OGGETTO", likeParam(search.getObj().getOggetto().trim().toUpperCase()));
         separator = " and ";
      }
      //tipo
      if (search.getObj().getTipo() != null && search.getObj().getTipo() > 0)
      {
         sb.append(separator).append(alias).append(".tipo = :TIPO ");
         params.put("TIPO", search.getObj().getTipo());
         separator = " and ";
      }
   }

   @Override
   protected String getDefaultOrderBy()
   {
      return "data desc";
   }

}