package principal;

import datos.ProductoDao;
import domain.Producto;
import java.util.List;
import javax.swing.JOptionPane;


public class Principal {
    public static void main(String [] args){
        ProductoDao productoDao = new ProductoDao();
        Producto producto;
        
        int opcion =0;
        Long idProducto;
        String menu = "\tMENU PRODUCTOS"
                + "\n1. Registrar producto."
                + "\n2. Consultar Producto"
                + "\n3. Consultar lista de productos."
                + "\n4. Actualizar producto."
                + "\n5. Eliminar producto."
                + "\n6. Salir.";
        
        while(opcion!=6){
            opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch(opcion){
                
                case 1:
                    producto = new Producto();
                    producto.setIdProducto(null);
                    producto.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del producto a registrar: "));
                    producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Precio del producto: ")));
                    System.out.println(productoDao.registrarProducto(producto));
                    break;
                    
                case 2:
                    idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto que desea consultar"));
                    producto = new Producto();
                    
                    producto = productoDao.consultarProducto(idProducto);
                    if (producto!=null) {
                        System.out.println(producto);
                    }else{
                        System.out.println("No existe el producto");
                    }
                    break;
                    
                case 3:
                    
                    List<Producto>productos = productoDao.consultarListaProductos();
                    
                    for(Producto prod: productos){
                        System.out.println(prod);
                    }
                    
                    break;
                    
                case 4:
                    idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto que actualizara: "));
                    producto = new Producto();
                    producto = productoDao.consultarProducto(idProducto);
                    if (producto!=null) {
                        producto.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del producto: "));
                        producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Precio: ")));
                        System.out.println(productoDao.actualizarProducto(producto));
                    }else{
                        System.out.println("No existe el producto.");
                    }
                    break;
                    
                case 5:
                    idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto que eliminara: "));
                    producto = new Producto();
                    producto = productoDao.consultarProducto(idProducto);
                    
                    if (producto!=null) {
                        System.out.println(productoDao.eliminarProducto(producto));
                    }else{
                        System.out.println("No existe el producto.");
                    }
                    break;
                    
                case 6:
                    productoDao.close();
                    break;
                    
                default:
                     opcion=Integer.parseInt(JOptionPane.showInputDialog(menu));
                    break;
                
            }
        }
        
    }
    
}
