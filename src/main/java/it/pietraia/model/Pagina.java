package it.pietraia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = Pagina.TABLE_NAME)
@XmlRootElement
public class Pagina implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "pagine";

   private Long id;
   private String noid;
   private String titolo;
   private String codice;

   public Pagina()
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

   public String getNoid()
   {
      return noid;
   }

   public void setNoid(String noid)
   {
      this.noid = noid;
   }

   public String getTitolo()
   {
      return titolo;
   }

   public void setTitolo(String titolo)
   {
      this.titolo = titolo;
   }

   public String getCodice()
   {
      return codice;
   }

   public void setCodice(String codice)
   {
      this.codice = codice;
   }

}
