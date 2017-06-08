package sistemacompleto_v1;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Tarefa> list;
    private Tarefa tarefa;
    private View view;
    private Model model;
    
    public Controller(){
        this.view = new View();
        this.model = new Model();
    }
    
    public void inicio(){
        do{
            this.view.menu();

            if(this.view.getOpmenu() == 1){
                this.inserir();
            }
            else if(this.view.getOpmenu() == 2){
                this.listarTodos();
            }
            else if(this.view.getOpmenu() == 3){
                this.buscar();
            }
            else if(this.view.getOpmenu() == 4){
                this.editar();
            }
            else if(this.view.getOpmenu() == 5){
                this.deletar();
            }
            else if(this.view.getOpmenu() == 0){
                System.out.println("\nSaindo do Programa...\n");
            }
            else{
                System.out.println("\nOpção Inválida.\n");
            }
        }while(this.view.getOpmenu() != 0);
    }
    
    private void listarTodos(){
        list = this.model.buscarTodos();
        this.view.listar(list);
    }
    
    private void inserir(){
        tarefa = this.view.novo();
                
        if(tarefa != null){
            this.model.inserir(tarefa);
            System.out.println("Registro inserido com sucesso!");
        }
        else
            System.out.println("Erro ao inserir registro.");

        System.out.println("");
    }
    
    private void buscar(){
        String str;
        int i;
        this.view.menuBuscar();

        if(this.view.getOpmenu2() == 1){
            str = this.view.recolheValor("Id a ser Pesquisado: ");

            try{
                i = Integer.parseInt(str);
                tarefa = this.model.buscarPorId(i);
                
                if(tarefa != null){
                    System.out.println("\n"+tarefa.toString()+"\n");
                }
                else{
                    System.out.println("\nTarefa não encontrada.\n");
                }
            }
            catch ( NumberFormatException erro ){
                System.out.println("\n----------- ERRO -------------");
                System.out.println("Houve erro na conversão, digite apenas caracteres numéricos");
                System.out.println("--------------------------------\n");
            }
        }
        else if(this.view.getOpmenu2() == 2){
            str = this.view.recolheValor("Nome a ser Pesquisado: ");
            list = this.model.buscarPorNome(str);
            this.view.listar(list);
        }
        else{
            System.out.println("Opção Inválida.");
        }
    }
    
    private void editar(){
        String str;
        int i;

        str = this.view.recolheValor("Id a ser Pesquisado: ");

        try{
            i = Integer.parseInt(str);
            tarefa = this.model.buscarPorId(i);
            
            if(tarefa != null){
                str = this.view.recolheValor("Novo Nome da Tarefa: ");
                tarefa.setNome(str);
                this.model.editar(tarefa);
                System.out.println("Registro editado com sucesso!");
            }
            else{
                System.out.println("Tarefa não encontrada.");
            }
            System.out.println("");
        }
        catch ( NumberFormatException erro ){
            System.out.println("\n----------- ERRO -------------");
            System.out.println("Houve erro na conversão, digite apenas caracteres numéricos");
            System.out.println("--------------------------------\n");
        }
    }
    
    private void deletar(){
        String str;
        int i;

        str = this.view.recolheValor("Id a ser Pesquisado: ");

        try{
            i = Integer.parseInt(str);
            tarefa = this.model.buscarPorId(i);
            
            if(tarefa != null){
                this.model.remover(tarefa);
                System.out.println("Registro removido com sucesso!");
            }
            else{
                System.out.println("Tarefa não encontrada.");
            }
            System.out.println("");
        }
        catch ( NumberFormatException erro ){
            System.out.println("\n----------- ERRO -------------");
            System.out.println("Houve erro na conversão, digite apenas caracteres numéricos");
            System.out.println("--------------------------------\n");
        }
    }
}
