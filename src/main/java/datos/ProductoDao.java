package datos;

import domain.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProductoDao {
    
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    
    public String registrarProducto(Producto producto){
        entityManager.getTransaction().begin();
        entityManager.persist(producto);
        entityManager.getTransaction().commit();
        
        return "Producto registrado.";
    }
    
    public Producto consultarProducto(Long idProducto){
        
        Producto producto = entityManager.find(Producto.class,idProducto);
        if (producto!=null) {
            return producto;
        }else{
            return null;
        }
    }
    
    public List<Producto>consultarListaProductos(){
        List<Producto>productos = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT p FROM Producto p");
        productos=query.getResultList();
        
        return productos;
    }
    
    public String actualizarProducto(Producto producto){
        entityManager.getTransaction().begin();
        entityManager.merge(producto);
        entityManager.getTransaction().commit();
        
        return "Producto actualizado.";
    }
    
    public String eliminarProducto(Producto producto){
        entityManager.getTransaction().begin();;
        entityManager.remove(entityManager.merge(producto));
        entityManager.getTransaction().commit();
        
        return "Producto eliminado.";
    }
    
    public void close(){
        JPAUtil.shutDown();
    }
}
