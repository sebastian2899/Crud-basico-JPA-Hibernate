package domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto implements Serializable{
    
    private final static long SerialVersionUID =1L;
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProducto;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "precio")
    private double precio;

    public Producto() {
    }

    public Producto(Long idProducto, String nombre, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
}
