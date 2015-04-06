package it.pietraia.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = Associato.TABLE_NAME)
@XmlRootElement
public class Associato implements Serializable
{

   private static final long serialVersionUID = 1L;
   public static final String TABLE_NAME = "associati";

   private Long id;
   private String nome;


   public Associato()
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
