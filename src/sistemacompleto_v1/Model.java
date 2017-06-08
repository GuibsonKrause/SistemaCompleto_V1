package sistemacompleto_v1;

import java.util.ArrayList;

public class Model
  {

    ArrayList<Tarefa> list;

    public Model()
      {
        this.list = (ArrayList<Tarefa>) Persiste.load("dados");

        if (this.list == null)
          {
            this.list = new ArrayList<Tarefa>();
          } else
          {
            Tarefa.setQtdreg(this.list.get(this.list.size() - 1).getId());
          }
      }

    public void inserir(Tarefa p)
      {
        //Adicionar p na lista e persistir a lista
        this.list.add(p);
      }

    public ArrayList<Tarefa> buscarTodos()
      {
        return this.list;
      }

    public Tarefa buscarPorId(int val)
      {
        //Percorrer a lista buscando um elemento 
        // que possua id igual ao do parâmetro val
        // Se encontrar retorne o objeto da lista, caso contrário
        // retorno null
        for (int i = 0; i < this.list.size(); i++)
          {
            if (this.list.get(i).equals(val))
              {
                return list.get(i);
              }            
          }
        return null;
      }

    public ArrayList<Tarefa> buscarPorNome(String val)
      {
        ArrayList<Tarefa> laux = new ArrayList<>();

        for (Tarefa p : this.list)
          {
            if (p.getNome().indexOf(val) >= 0)
              {
                //adiciona o elemento à laux
                laux.add(p);
              }
          }

        return laux;
      }

    public void editar(Tarefa t)
      {
        for (int i = 0; i < this.list.size(); i++)
          {
            if (this.list.get(i).getId() == t.getId())
              {
                //alterar o elemento encontrado por t
                this.list.set(i, t);
              }
          }
        Persiste.save("dados", this.list);
      }

    public void remover(Tarefa t)
      {
        for (int i = 0; i < this.list.size(); i++)
          {
            if (this.list.get(i).getId() == t.getId())
              {
                //remover o elemento encontrado
                this.list.remove(i);
              }
          }
        Persiste.save("dados", this.list);
      }
  }
