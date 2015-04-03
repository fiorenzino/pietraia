package it.pietraia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = Foto.TABLE_NAME)
@XmlRootElement
public class Foto implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "foto";

   public static final String NEWS_FK = "id_news";
   public static final String SCULTURE_FK = "id_scultura";

   private Long id;
   private String nome;
   private String foto;
   private String descrizione;

   private Integer id_scultura;
   private Integer id_news;
   private Integer tipo;
   private String mp3;
   private Integer id_artista;
   private Integer ind;
   private Integer id_art2010;
   private Integer id_art2011;
   private Integer id_art2012;
   private Integer id_art2013;
   private Integer id_art2014;
   private Integer id_art2008;
   private Integer id_art2009;

   public Foto()
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

   public String getFoto()
   {
      return foto;
   }

   public void setFoto(String foto)
   {
      this.foto = foto;
   }

   public String getDescrizione()
   {
      return descrizione;
   }

   public void setDescrizione(String descrizione)
   {
      this.descrizione = descrizione;
   }

   public Integer getId_scultura()
   {
      return id_scultura;
   }

   public void setId_scultura(Integer id_scultura)
   {
      this.id_scultura = id_scultura;
   }

   @Column(name = NEWS_FK)
   public Integer getId_news()
   {
      return id_news;
   }

   public void setId_news(Integer id_news)
   {
      this.id_news = id_news;
   }

   public Integer getTipo()
   {
      return tipo;
   }

   public void setTipo(Integer tipo)
   {
      this.tipo = tipo;
   }

   public String getMp3()
   {
      return mp3;
   }

   public void setMp3(String mp3)
   {
      this.mp3 = mp3;
   }

   public Integer getId_artista()
   {
      return id_artista;
   }

   public void setId_artista(Integer id_artista)
   {
      this.id_artista = id_artista;
   }

   public Integer getInd()
   {
      return ind;
   }

   public void setInd(Integer ind)
   {
      this.ind = ind;
   }

   public Integer getId_art2010()
   {
      return id_art2010;
   }

   public void setId_art2010(Integer id_art2010)
   {
      this.id_art2010 = id_art2010;
   }

   public Integer getId_art2011()
   {
      return id_art2011;
   }

   public void setId_art2011(Integer id_art2011)
   {
      this.id_art2011 = id_art2011;
   }

   public Integer getId_art2012()
   {
      return id_art2012;
   }

   public void setId_art2012(Integer id_art2012)
   {
      this.id_art2012 = id_art2012;
   }

   public Integer getId_art2013()
   {
      return id_art2013;
   }

   public void setId_art2013(Integer id_art2013)
   {
      this.id_art2013 = id_art2013;
   }

   public Integer getId_art2014()
   {
      return id_art2014;
   }

   public void setId_art2014(Integer id_art2014)
   {
      this.id_art2014 = id_art2014;
   }

   public Integer getId_art2008()
   {
      return id_art2008;
   }

   public void setId_art2008(Integer id_art2008)
   {
      this.id_art2008 = id_art2008;
   }

   public Integer getId_art2009()
   {
      return id_art2009;
   }

   public void setId_art2009(Integer id_art2009)
   {
      this.id_art2009 = id_art2009;
   }
}
