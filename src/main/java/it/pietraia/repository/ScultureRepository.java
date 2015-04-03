package it.pietraia.repository;

import it.pietraia.model.Scultura;
import org.angcms.api.repository.Search;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Map;

@Stateless
@LocalBean
public class ScultureRepository extends BaseRepository<Scultura>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void applyRestrictions(Search<Scultura> search, String alias,
            String separator, StringBuffer sb, Map<String, Object> params)
   {

      if (search.getObj().getId() != null)
      {
         sb.append(separator).append(alias).append(".id = :ID ");
         params.put("ID", search.getObj().getId());
         separator = " and ";
      }
      // nome
      if (search.getObj().getTitolo() != null && !search.getObj().getTitolo().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".titolo ) like :TITOLO ");
         params.put("TITOLO", likeParam(search.getObj().getTitolo().trim().toUpperCase()));
         separator = " and ";
      }
      // materia
      if (search.getObj().getMateria() != null && !search.getObj().getMateria().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".materia ) like :MATERIA ");
         params.put("MATERIA", likeParam(search.getObj().getMateria().trim().toUpperCase()));
         separator = " and ";
      }
      // descrizione
      if (search.getObj().getDescrizione() != null && !search.getObj().getDescrizione().isEmpty())
      {
         sb.append(separator).append(" upper ( ").append(alias).append(".descrizione ) like :DESCRIZIONE ");
         params.put("DESCRIZIONE", likeParam(search.getObj().getDescrizione().trim().toUpperCase()));
         separator = " and ";
      }
      // tattile
      if (search.getObj().getMp3() != null && search.getObj().getMp3().trim().length() > 0)
      {
         sb.append(separator).append(alias).append(".mp3 is not null ");
         separator = " and ";
      }
   }

   @Override
   protected String getDefaultOrderBy()
   {
      return "titolo asc";
   }

}