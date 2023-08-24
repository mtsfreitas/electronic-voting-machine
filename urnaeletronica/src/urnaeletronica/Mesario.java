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
public class Mesario {
    
    private String zona_eleitoral;
    private UrnaEletronica urna_eletronica;
    
    public Mesario(){
      
        this.urna_eletronica = new UrnaEletronica();
    }    
    
    public Mesario(String zona_eleitoral){
        this.zona_eleitoral = zona_eleitoral;        
    }
    
    public Mesario(String zona_eleitoral, UrnaEletronica urna_eletronica){
        this.zona_eleitoral = zona_eleitoral;
        this.urna_eletronica = urna_eletronica;
    }
    
    public String getZona_eleitoral() {
        return zona_eleitoral;
    }

    public void setZona_eleitoral(String zona_eleitoral) {
        this.zona_eleitoral = zona_eleitoral;
    }

    public UrnaEletronica getUrna_eletronica() {
        return urna_eletronica;
    }
    
    public void inicializarUrna(){
        this.urna_eletronica = new UrnaEletronica();
    }
    
    public void autorizarEleitor(Eleitor eleitor){
        this.urna_eletronica.autorizarEleitor(eleitor);
    }
    
    public void gerarRelatorioUrna(){
        System.out.println("--- Informações do Mesário ---\n");
        System.out.println("- Zona eleitoral: " + this.zona_eleitoral + "\n\n//----------//----------//----------//");
        this.urna_eletronica.gerarRelatorio();
    }
    
}
