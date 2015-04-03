package it.pietraia.repository;

import it.pietraia.model.Foto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.angcms.api.repository.Search;

@Stateless
@LocalBean
public class FotoRepository extends BaseRepository<Foto>
{

   private static final long serialVersionUID = 1L;

   @Override
   protected void applyRestrictions(Search<Foto> search, String alias,
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
   }

   @Override
   protected String getDefaultOrderBy()
   {
      return "id desc";
   }

   @SuppressWarnings("unchecked")
   public List<Foto> getListByForeignKeys(Collection<Integer> fks, String foreingKeyColumnName)
   {
      if (fks == null || fks.size() == 0)
      {
         return new ArrayList<Foto>();
      }
      try
      {
         return getEm()
                  .createNativeQuery(
                           "select * from " + Foto.TABLE_NAME + " where " + foreingKeyColumnName + " in ( :fks )",
                           Foto.class)
                  .setParameter("fks", fks).getResultList();
      }
      catch (Exception e)
      {
         logger.error(e.getMessage(), e);
         return null;
      }
   }

}