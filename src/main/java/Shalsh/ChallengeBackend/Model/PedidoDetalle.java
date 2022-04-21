package Shalsh.ChallengeBackend.Model;

import javax.persistence.*;

@Entity
@Table(name="pedidos_detalle")
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private long id_detalle;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name="id_cabecera", foreignKey = @ForeignKey(name= "FK_cabecera",foreignKeyDefinition = "FOREIGN KEY (`id_cabecera`) REFERENCES `pedidos_cabecera` (`id_cabecera`)",value = ConstraintMode.CONSTRAINT))
    private PedidoCabecera pedido;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name="id_producto", referencedColumnName = "id_producto", foreignKey = @ForeignKey(name = "FK_producto", foreignKeyDefinition = "FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`)", value = ConstraintMode.CONSTRAINT)),
            @JoinColumn(name = "nombre", referencedColumnName = "nombre"),
            @JoinColumn(name = "precio_unitario", referencedColumnName = "precio_unitario")
            })
    private Producto producto;

    @Column(name = "cantidad",nullable = false)
    private int cantidad;

    public long getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(long id_detalle) {
        this.id_detalle = id_detalle;
    }

    public PedidoCabecera getPedido() {
        return pedido;
    }

    public void setPedido(PedidoCabecera pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
