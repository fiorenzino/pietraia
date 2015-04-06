package it.pietraia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = Catalogo.TABLE_NAME)
@XmlRootElement
public class Catalogo implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "cataloghi";

   private Long id;
   private String nome;


   public Catalogo()
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

}
