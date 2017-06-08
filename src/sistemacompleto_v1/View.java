package sistemacompleto_v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class View {
    BufferedReader tec;
    private String tecval;
    private int opmenu, opmenu2;
    
    public View(){
        tec = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public int getOpmenu() {
        return opmenu;
    }

    public void setOpmenu(int opmenu) {
        this.opmenu = opmenu;
    }
    
    public int getOpmenu2() {
        return opmenu2;
    }

    public void setOpmenu2(int opmenu2) {
        this.opmenu2 = opmenu2;
    }

    public void menu(){
        System.out.println("--- SISTEMA TAREFAS MVC ---");
        System.out.println(" 1) Cadastrar");
        System.out.println(" 2) Listar");
        System.out.println(" 3) Buscar");
        System.out.println(" 4) Editar");
        System.out.println(" 5) Remover");
        System.out.println(" 0) Sair");
        
        System.out.print("\n Opção > ");
        
        try{
            this.tecval = tec.readLine();
            this.opmenu = Integer.parseInt(tecval);
        }
        catch (IOException erro){
            System.out.println("\n-------- ERRO ------------");
            System.out.println("Erro na entrada de dados");
            System.out.println("----------------------------\n");
        }
        catch ( NumberFormatException erro ){
            System.out.println("\n----------- ERRO -------------");
            System.out.println("Houve erro na conversão, digite apenas caracteres numéricos");
            System.out.println("--------------------------------\n");
        }
    }
    
    public void menuBuscar(){
        System.out.println("\n - Buscar por -");
        System.out.println(" 1) Id");
        System.out.println(" 2) Nome");
        
        System.out.print(" Opção > ");
        
        try{
            this.tecval = tec.readLine();
            this.opmenu2 = Integer.parseInt(tecval);
        }
        catch (IOException erro){
            System.out.println("\n-------- ERRO ------------");
            System.out.println("Erro na entrada de dados");
            System.out.println("----------------------------\n");
        }
        catch ( NumberFormatException erro ){
            System.out.println("\n----------- ERRO -------------");
            System.out.println("Houve erro na conversão, digite apenas caracteres numéricos");
            System.out.println("--------------------------------\n");
        }
    }
    
    public String recolheValor(String str){
        try{
            System.out.print(str);
            this.tecval = tec.readLine();
            return this.tecval;
        }
        catch (IOException erro){
            System.out.println("\n-------- ERRO ------------");
            System.out.println("Erro na entrada de dados");
            System.out.println("----------------------------\n");
        }
        
        return null;
    }
    
    public void listar(ArrayList<Tarefa> lista){
        System.out.println("\n--- Listagem de Tarefas ---");
        
        if(lista.size() == 0){
            System.out.println("Lista Vazia!");
        }
        else{
            for(Tarefa l : lista){
                System.out.println(l.toString());
            }
        }
        System.out.println("--- Fim da Listagem ---\n");
    }
    
    public Tarefa novo(){
        Tarefa t = new Tarefa();
        
        try{
            System.out.print("\nDigite o Nome da Tarefa: ");
            tecval = tec.readLine();
            t.setNome(tecval);
            
            return t;
        }
        catch (IOException erro){
            System.out.println("\n-------- ERRO ------------");
            System.out.println("Erro na entrada de dados");
            System.out.println("----------------------------\n");
        }
        catch ( NumberFormatException erro ){
            System.out.println("\n----------- ERRO -------------");
            System.out.println("Houve erro na conversão, digite apenas caracteres numéricos");
            System.out.println("--------------------------------\n");
        }
        
        return null;
    }

}
