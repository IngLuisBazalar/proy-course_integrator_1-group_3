package modelo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ColeccionProducto implements Serializable{
    ArrayList<Producto> lista;
    
    public ColeccionProducto(){
        lista = new ArrayList();
    }
    
    public void AgregarProducto(Producto prod){
        lista.add(prod);
      
    }
    
    public void ActualizarTabla(JTable tabla, String Encabezado[]){
        //limpiamos tabla
        DefaultTableModel mt = new DefaultTableModel(null,Encabezado);
        tabla.setModel(mt);
        //actualizamos los registros en la tabla
        for (int i = 0; i < lista.size(); i++){
            mt.addRow(lista.get(i).Registro(i+1));
        }
    }
    
    public void ActualizarTablaStock (JTable tabla, String Encabezado[]){
        //limpiamos tabla
        DefaultTableModel mt = new DefaultTableModel(null,Encabezado);
        tabla.setModel(mt);      
        ArrayList<Producto> listaStock  = new ArrayList();
        int cantidad = 0;
              
        for (Producto producto : lista) {
            Producto productoEncontrado = null;
            //Buscamos el producto en la lista Stock
            productoEncontrado = consultarCodigoProducto(producto.getCodigoProducto(), listaStock);
            //SI no se encuentra, lo agregamos a la lista stock
            if(productoEncontrado == null){
                listaStock.add(producto);
            }
            //Sino obtenemos la cantidad de ese producto y lo actualizamos, 
            // pero antes eliminamos el producto existente para volverlo a agregar con la cantidad actualizada
            else{
                //Obtenemos la cantidad
                cantidad = productoEncontrado.cantidad + producto.getCantidad();
                //eliminamos el producto con el stock antiguo
                listaStock.remove(productoEncontrado);
                //actualizamos el stock del producto
                productoEncontrado.setCantidad(cantidad);
                //agregamos denuevo a la lista stock
                listaStock.add(productoEncontrado);
            }
            
        }
        for (int i = 0; i < listaStock.size(); i++){
            mt.addRow(listaStock.get(i).Registro(i+1));
        }
    }
    
    public int VerificaStock (String codigo){
        
        Producto p = BuscarCodigo(codigo);
        if (p == null){
            return 999999999;
        }else{
            return p.getCantidad();
        }
        
    }
    
    public void GuardarArchivoBinario(){
        try {
            //1. definimos el nombre del archivo
            FileOutputStream fos = new FileOutputStream("Productos.bin");
            //2. establecemos el objeto para el flujo
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lista); //escribe toda la colección en el archivo binario
            oos.close(); //cerramos flujo
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se puede guardar en archivo binario.." + e);
        }
    }
    
    //método que recupera la información del archivo binario a la colección
    public void RecuperarDataDeBinario(){
        try {
            FileInputStream fis = new FileInputStream("Productos.bin");
            ObjectInputStream in = new ObjectInputStream(fis);
            lista = (ArrayList<Producto>) in.readObject();
            in.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se puede recuperar datos del archivo binario.." + e);
        }
    }
    
    public void RecuperarDataDeBinarioEspe(){
        try {
            FileInputStream fis = new FileInputStream("Productos.bin");
            ObjectInputStream in = new ObjectInputStream(fis);
            lista = (ArrayList<Producto>) in.readObject();
            in.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se puede recuperar datos del archivo binario.." + e);
        }
    }
    
    public Producto BuscarCodigo(String codigo){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).codigoProducto.equals(codigo)) {
                return lista.get(i);
            }
        }
        return null;
    }
    
    public Producto BuscarFecha(String codigo){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).Fecha.equals(codigo)) {
                return lista.get(i);
            }
        }
        return null;
    }
    
    public Producto BuscarCategoria(String codigo){
        for (int i = 0; i < lista.size(); i++){
            if (lista.get(i).categoria.equals(codigo)) {
                return lista.get(i);
            }
        }
        return null;
    }

    private Producto consultarCodigoProducto(String codigoProducto, ArrayList<Producto> listaStcok) {
        for (Producto producto : listaStcok) {
            if(producto.codigoProducto.equalsIgnoreCase(codigoProducto))
                return producto;
        }
        return null;
    }

    private Producto getProductoListaStock(String codigoProducto, ArrayList<Producto> listaStcok) {
        for (Producto producto : listaStcok) {
            if(producto.codigoProducto.equalsIgnoreCase(codigoProducto))
                return producto;
        }
        return null;
    }

    public void ActualizarTablaStock() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}