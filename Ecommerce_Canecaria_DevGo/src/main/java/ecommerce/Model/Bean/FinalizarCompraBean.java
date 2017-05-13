package ecommerce.Model.Bean;

import ecommerce.Model.Dao.FinalizarCompraDAO;
import ecommerce.Model.DaoImplementation.FinalizarCompraDAOImpl;
import ecommerce.Model.MetodosAcessores.FinalizarCompra;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Erik
 */
@ManagedBean
@ViewScoped
public class FinalizarCompraBean {

    FinalizarCompra compra = new FinalizarCompra();
    
    FinalizarCompraDAO finalizar = new FinalizarCompraDAOImpl();
    
    private double total;
        
    public FinalizarCompraBean() {

    }
    
     public FinalizarCompra getFinalizarCompra() {
        return compra;
    }

    public void setFinalizarCompra(FinalizarCompra compra) {
        this.compra = compra;
    }
      
    /* Finalizar a compra do usuario */
    public void CadastrarCompra() throws Exception {
                   
          try {
              
            StatusPedido();

            compra.setCodCliente(1);
              
            total = finalizar.ValorTotal(1);
              
              
            compra.setValorTotalCompra(total);
              
             
            finalizar.CadastrarPedido(compra);
            
           System.out.println("DDDDDDDD "+finalizar.UltimoId());
              
        } catch (SQLException erro) {
              
              System.out.println("Erro "+erro);
        }
        compra = new FinalizarCompra();
        
 
    }
    
    
    public void estado(){
        
        System.out.println("A444 "+compra.getCodPagamento());
        System.out.println("A33 "+compra.getCep());
        
    }
    
    public void StatusPedido(){
        
        int status;
        
        if(compra.getCodPagamento() == 1){
            
          compra.setCodStatus(2);
            
        }else{
            
           compra.setCodStatus(3);
            
        } 
        
    }


   

}
