/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;


import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Freitas
 */
public class UrnaEletronica{

    /**
     * @param args the command line arguments
     */
        
        protected class ElementoListaEleitores{
        protected Eleitor eleitor;
        protected boolean autorizado_a_votar;
        protected boolean ja_votou;
    }
    
    protected class ElementoListaCandidatos{
        protected Candidato candidato;
        protected int qtd_votos;
    }
    
    private List<ElementoListaEleitores> lista_eleitores;
    private List<ElementoListaCandidatos> lista_candidatos;
    private int qtd_votos_em_branco;
    private int qtd_votos_nulos;
    
    public UrnaEletronica(){
        qtd_votos_em_branco = 0;
        qtd_votos_nulos = 0;
        lista_eleitores = new ArrayList<>();
        lista_candidatos = new ArrayList<>();
    }
    
    public UrnaEletronica(List<ElementoListaEleitores> lista_eleitores, 
            List<ElementoListaCandidatos> lista_candidatos, int qtd_votos_em_branco, 
            int qtd_votos_nulos) {
        this.lista_eleitores = lista_eleitores;
        this.lista_candidatos = lista_candidatos;
        this.qtd_votos_em_branco = qtd_votos_em_branco;
        this.qtd_votos_nulos = qtd_votos_nulos;
    }
    
    public List<ElementoListaEleitores> getLista_eleitores() {
        return lista_eleitores;
    }

    public List<ElementoListaCandidatos> getLista_candidatos() {
        return lista_candidatos;
    }

    public int getQtd_votos_em_branco() {
        return qtd_votos_em_branco;
    }

    public int getQtd_votos_nulos() {
        return qtd_votos_nulos;
    }
    
    public boolean inserirEleitor(Eleitor eleitor){
        ElementoListaEleitores elemento = encontraElementoListaEleitores(eleitor);
        if(elemento == null){ // Não foi encontrado eleitor com o mesmo número de titulo eleitoral.
            elemento = new ElementoListaEleitores();
            elemento.eleitor = eleitor;
            elemento.autorizado_a_votar = false;
            elemento.ja_votou = false;
            lista_eleitores.add(elemento);
            return true;
        } // else
        return false;
    }
    
    public boolean inserirCandidato(Candidato candidato){
        ElementoListaCandidatos elemento = encontraElementoListaCandidatos(candidato);
        if(elemento == null){ // Não foi encontrado candidato com o mesmo número de votação.       
            elemento = new ElementoListaCandidatos();
            elemento.candidato = candidato;
            elemento.qtd_votos = 0;
            lista_candidatos.add(elemento);
            return true;
        } // else
        return false;
    }
    
    public boolean removerEleitor(Eleitor eleitor){
        ElementoListaEleitores elemento = encontraElementoListaEleitores(eleitor);
        if(elemento != null){
            lista_eleitores.remove(elemento);
            return true;
        } // else
        return false;
    }
    
    public boolean removerCandidato(Candidato candidato){
        ElementoListaCandidatos elemento = encontraElementoListaCandidatos(candidato);
        if(elemento != null){
            lista_candidatos.remove(elemento);
            return true;
        } // else
        return false;
    }
    
    private ElementoListaEleitores encontraElementoListaEleitores(Eleitor eleitor){
        ElementoListaEleitores elemento;
        for (ElementoListaEleitores elemento_lista_eleitores : lista_eleitores) {
            elemento = elemento_lista_eleitores;
            if(elemento.eleitor.comparaEleitores(eleitor)){
                return elemento;
            }
        }
        return null;
    }
    
    private ElementoListaEleitores encontraElementoListaEleitores(int num_titulo){
        ElementoListaEleitores elemento;
        for (ElementoListaEleitores elemento_lista_eleitores : lista_eleitores) {
            elemento = elemento_lista_eleitores;
            if(elemento.eleitor.getNum_titulo() == num_titulo){
                return elemento;
            }
        }
        return null;
    }
    
    private ElementoListaCandidatos encontraElementoListaCandidatos(Candidato candidato){
        ElementoListaCandidatos elemento;
        for (ElementoListaCandidatos elemento_lista_candidatos : lista_candidatos) {
            elemento = elemento_lista_candidatos;
            if(elemento.candidato.comparaCandidatos(candidato)){
                return elemento;
            }
        }
        return null;
    }
    
    private ElementoListaCandidatos encontraElementoListaCandidatos(int numero_votacao){
        ElementoListaCandidatos elemento;
        for (ElementoListaCandidatos elemento_lista_candidatos : lista_candidatos) {
            elemento = elemento_lista_candidatos;
            if(elemento.candidato.getNumero_votacao() == numero_votacao){
                return elemento;
            }
        }
        return null;
    }
    
    //Autoriza um eleitor a votar nesta urna eletrônica.
    public boolean autorizarEleitor(Eleitor eleitor){
        ElementoListaEleitores elemento = encontraElementoListaEleitores(eleitor);
        if(elemento != null){
            if(elemento.ja_votou)
                elemento.autorizado_a_votar = false;
            else
                elemento.autorizado_a_votar = true;   
            
            return elemento.autorizado_a_votar;
        } // else
        return false;
    }
    
   //Utilizado apenas para quando o voto é Branco ou Nulo.  
    public boolean receberVoto(Eleitor eleitor, Voto tipo_voto){
        ElementoListaEleitores elemento_lista_eleitores;
        if(autorizarEleitor(eleitor)){
            elemento_lista_eleitores = encontraElementoListaEleitores(eleitor);
            switch(tipo_voto){
                case BRANCO:
                    qtd_votos_em_branco++;
                    elemento_lista_eleitores.ja_votou = true;
                    break;
                case NULO:
                    qtd_votos_nulos++;
                    elemento_lista_eleitores.ja_votou = true;
                    break;
                default:
                    return false;
            }
            return true;
        } // else
        return false;
    }
    
    //Utilizado apenas para quando o voto é para um Candidato.     
     
    public boolean receberVoto(Eleitor eleitor, int numero_candidato){
        ElementoListaCandidatos elemento_lista_candidatos;
        ElementoListaEleitores elemento_lista_eleitores;
        if(autorizarEleitor(eleitor)){
            elemento_lista_eleitores = encontraElementoListaEleitores(eleitor);
            elemento_lista_candidatos = encontraElementoListaCandidatos(numero_candidato);
            if(elemento_lista_candidatos != null){
                elemento_lista_candidatos.qtd_votos++;
                elemento_lista_eleitores.ja_votou = true;
                return true;
            }            
        } // else        
        return false;
    }
    
    public void gerarRelatorio(){     
        System.out.println("--- Eleitores Não Autorizados ---\n");
        for(ElementoListaEleitores elemento_lista_eleitores : lista_eleitores){
            if(!elemento_lista_eleitores.autorizado_a_votar){
                System.out.println("- Nome: " + elemento_lista_eleitores.eleitor.getNome());
                System.out.println("- Título de eleitor: " + 
                        elemento_lista_eleitores.eleitor.getNum_titulo() + "\n");
            }            
        }
        System.out.println("\n//----------//----------//----------//\n--- Eleitores Autorizados ---\n");
        for(ElementoListaEleitores elemento_lista_eleitores : lista_eleitores){
            if(elemento_lista_eleitores.autorizado_a_votar){
                System.out.println("- Nome: " + elemento_lista_eleitores.eleitor.getNome());
                System.out.println("- Título de eleitor: " + 
                        elemento_lista_eleitores.eleitor.getNum_titulo() + "\n");
            }            
        }
        System.out.println("\n//----------//----------//----------//\n--- Candidatos ---\n");
        for(ElementoListaCandidatos elemento_lista_candidatos : lista_candidatos){
            System.out.println("- Nome: " + elemento_lista_candidatos.candidato.getNome());
            System.out.println("- Partido: " + elemento_lista_candidatos.candidato.getPartido());
            System.out.println("- Número: " + 
                    elemento_lista_candidatos.candidato.getNumero_votacao());
            System.out.println("- Quantidade de votos: " + 
                    elemento_lista_candidatos.qtd_votos + "\n");
        }
        System.out.println("- Votos em Branco: " + qtd_votos_em_branco);
        System.out.println("- Votos nulos: " + qtd_votos_nulos);        
    }
    
}
    

