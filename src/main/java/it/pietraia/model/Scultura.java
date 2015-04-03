package it.pietraia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fiorenzo on 03/04/15.
 */
@Entity
@Table(name = Scultura.TABLE_NAME)
@XmlRootElement
public class Scultura implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "sculture";

   private Long id;
   private String titolo;
   private String data;
   private String misure;
   private String materia;
   private String descrizione;
   private String mp3;
   private List<Foto> immagini;

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

   public String getTitolo()
   {
      return titolo;
   }

   public void setTitolo(String titolo)
   {
      this.titolo = titolo;
   }

   public String getData()
   {
      return data;
   }

   public void setData(String data)
   {
      this.data = data;
   }

   public String getMisure()
   {
      return misure;
   }

   public void setMisure(String misure)
   {
      this.misure = misure;
   }

   public String getMateria()
   {
      return materia;
   }

   public void setMateria(String materia)
   {
      this.materia = materia;
   }

   public String getDescrizione()
   {
      return descrizione;
   }

   public void setDescrizione(String descrizione)
   {
      this.descrizione = descrizione;
   }

   public String getMp3()
   {
      return mp3;
   }

   public void setMp3(String mp3)
   {
      this.mp3 = mp3;
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
