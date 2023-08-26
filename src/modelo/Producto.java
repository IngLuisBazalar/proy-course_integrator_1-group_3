package modelo;
import java.io.Serializable;
import java.util.Date;

public class Producto implements Serializable{
    String Fecha;
    String codigoProducto;
    String nomProducto;
    int cantidad;
    String categoria;
    String TipoTransaccion;
    

    public Producto() {
    }

    public Producto(String Fecha, String codigoProducto, String nomProducto, int cantidad, String categoria, String TipoTransaccion) {
        this.Fecha = Fecha;
        this.codigoProducto = codigoProducto;
        this.nomProducto = nomProducto;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.TipoTransaccion = TipoTransaccion;
    }
    
    public Producto(String cp, String np, int can) {
        this.codigoProducto = cp;
        this.nomProducto = np;
        this.cantidad = can;
    }   

   
    Object[] Registro(int num){
        Object[] fila = {num,Fecha,codigoProducto,nomProducto,cantidad,categoria,TipoTransaccion};
        return fila;
    }       
    
    //getter y setter

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getTipoTransaccion() {
        return TipoTransaccion;
    }

    public void setTipoTransaccion(String TipoTransaccion) {
        this.TipoTransaccion = TipoTransaccion;
    }
      

    @Override
    public String toString() {
        return "Producto{" + "Fecha=" + Fecha + ", codigoProducto=" + codigoProducto + ", nomProducto=" + nomProducto + ", cantidad=" + cantidad + ", categoria=" + categoria + '}';
    }
    
}
