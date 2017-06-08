package sistemacompleto_v1;

import java.io.Serializable;

public class Tarefa implements Serializable
  {

    private int id;
    private String nome;
    private static int qtdreg = 0;

    //Construtor sem parâmetros, mas setando qtdreg
    public Tarefa()
      {
        this.qtdreg = 0;
      }

    //Criar gets e sets
    public int getId()
      {
        return id;
      }

    public void setId(int id)
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

    public static int getQtdreg()
      {
        return qtdreg;
      }

    public static void setQtdreg(int qtdreg)
      {
        Tarefa.qtdreg = qtdreg;
      }

    //Override toString
    public String ToString()
      {
        return this.nome;
      }

  }
