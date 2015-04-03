package it.pietraia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fiorenzo on 18/03/15.
 */
@Entity
@Table(name = News.TABLE_NAME)
@XmlRootElement
public class News implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "news";

   private Long id;
   private String nome;
   private String oggetto;
   private Integer data;
   private String testo;
   private Integer tipo;
   private List<Foto> immagini;

   public News()
   {
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getNome()
   {
      return nome;
   }

   public void setNome(String nome)
   {
      this.nome = nome;
   }

   public Integer getTipo()
   {
      return tipo;
   }

   public void setTipo(Integer tipo)
   {
      this.tipo = tipo;
   }

   public String getTesto()
   {
      return testo;
   }

   public void setTesto(String testo)
   {
      this.testo = testo;
   }

   public Integer getData()
   {
      return data;
   }

   public void setData(Integer data)
   {
      this.data = data;
   }

   public String getOggetto()
   {
      return oggetto;
   }

   public void setOggetto(String oggetto)
   {
      this.oggetto = oggetto;
   }

   @Transient
   public List<Foto> getImmagini()
   {
      if (immagini == null)
      {
         immagini = new ArrayList<Foto>();
      }
      return immagini;
   }

   public void setImmagini(List<Foto> immagini)
   {
      this.immagini = immagini;
   }

}
