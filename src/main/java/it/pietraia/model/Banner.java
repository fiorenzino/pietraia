package it.pietraia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = Banner.TABLE_NAME)
@XmlRootElement
public class Banner implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "banner";

   private Long id;
   private String nome;
   private String link;
   private String descrizione;
   private String tipologia;
   private String testo;
   private String img;

   public Banner()
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

   public String getLink()
   {
      return link;
   }

   public void setLink(String link)
   {
      this.link = link;
   }

   public String getDescrizione()
   {
      return descrizione;
   }

   public void setDescrizione(String descrizione)
   {
      this.descrizione = descrizione;
   }

   public String getTipologia()
   {
      return tipologia;
   }

   public void setTipologia(String tipologia)
   {
      this.tipologia = tipologia;
   }

   public String getTesto()
   {
      return testo;
   }

   public void setTesto(String testo)
   {
      this.testo = testo;
   }

   public String getImg()
   {
      return img;
   }

   public void setImg(String img)
   {
      this.img = img;
   }

}
