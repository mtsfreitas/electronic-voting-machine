/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica;

/**
 *
 * @author Freitas
 */
public class Eleitor {
    
    private String nome;
    private int num_titulo;
    
    public Eleitor(){
        
    }
    
    public Eleitor(String nome, int num_titulo){
        this.nome = nome;
        this.num_titulo = num_titulo;
        
    }
    
    public Eleitor(String nome, int num_titulo, boolean autorizado_a_votar){
        this.nome = nome;
        this.num_titulo = num_titulo;
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNum_titulo() {
        return num_titulo;
    }

    public void setNum_titulo(int num_titulo) {
        this.num_titulo = num_titulo;
    }
    
    //Compara dois eleitores para ver se o eleitor é o mesmo que eleitor_2.
   
    public boolean comparaEleitores(Eleitor eleitor_2){        
        return (this.num_titulo == eleitor_2.num_titulo);
    }
    
    //Utilizado apenas para quando o voto é Branco ou Nulo.
     
    public boolean votar(UrnaEletronica urna, Voto tipo_voto){
        return urna.receberVoto(this, tipo_voto);
    }
    
    //Utilizado apenas para quando o voto é para um candidato.
    
    public boolean votar(UrnaEletronica urna, int num_candidato){
        return urna.receberVoto(this, num_candidato);
    }
    
}
