package sistemacompleto_v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Persiste
  {

    public static void save(String caminho, Object obj)
      {
        try
          {
            FileOutputStream out = new FileOutputStream(caminho);
            ObjectOutputStream s = new ObjectOutputStream(out);

            s.writeObject(obj);
            s.close();
          } catch (FileNotFoundException e)
          {
            System.out.println("Arquivo de dados ainda não foi criado.");
          } catch (IOException e)
          {
            System.out.println("Problemas ao gravar no arquivo: " + e.toString());
          }
      }

    public static Object load(String caminho)
      {
        try
          {
            FileInputStream out = new FileInputStream(caminho);
            ObjectInputStream s = new ObjectInputStream(out);

            Object obj = s.readObject();
            s.close();

            return obj;
          } catch (FileNotFoundException e)
          {
            System.out.println("Problemas ao abrir o arquivo.");
          } catch (IOException e)
          {
            System.out.println("Problemas ao gravar no arquivo.");
          } catch (ClassNotFoundException e)
          {
            System.out.println("Problemas na conversão da classe.");
          }

        return null;
      }
  }
