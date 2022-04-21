package Shalsh.ChallengeBackend.Service;

import Shalsh.ChallengeBackend.Model.PedidoCabecera;
import Shalsh.ChallengeBackend.Model.PedidoDetalle;
import Shalsh.ChallengeBackend.Repository.CabeceraRepository;
import Shalsh.ChallengeBackend.Repository.DetalleRepository;
import Shalsh.ChallengeBackend.Repository.ProductosRepository;
import Shalsh.ChallengeBackend.Utils.DetalleHelper;
import Shalsh.ChallengeBackend.Utils.PedidoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Service

public class PedidoService {

    public static final int CANT_DESCUENTO = 3;
    public static final double VAL_DESCUENTO = 0.7;
    public static final String PENDIENTE = "Pendiente";
    public static final String COMPLETA = "Completa";

    @Autowired
    CabeceraRepository cabeceraRepository;
    @Autowired
    DetalleRepository detalleRepository;
    @Autowired
    ProductosRepository productosRepository;

    public PedidoCabecera add(PedidoHelper request){
        try{
            PedidoCabecera pedido = format(request);
            return cabeceraRepository.save(pedido);
        } catch (Exception e){
            return null;
        }
    }

    /*Recibe una Request de pedidos y la transforma en cabecera y detalle*/
    private PedidoCabecera format(PedidoHelper request){
        List<DetalleHelper> detalle_req = request.getDetalle();
        PedidoCabecera pedido = new PedidoCabecera();
        List<PedidoDetalle> detalle = format(detalle_req, pedido);

        pedido.setEmail(request.getEmail());
        pedido.setDireccion(request.getDireccion());
        pedido.setTelefono(request.getTelefono());
        pedido.setHorario(request.getHorario());
        pedido.setDetalle(detalle);

        pedido.setFecha_alta(LocalDate.now());
        pedido.setEstado(PENDIENTE);
        int cant = 0; double total = 0;
        for(PedidoDetalle p:detalle){
            cant += p.getCantidad();
            total += p.getCantidad() * p.getPrecio_unitario();
        }
        boolean descuento = (cant >= CANT_DESCUENTO);
        pedido.setDescuento(descuento);
        if (descuento)
            total *= VAL_DESCUENTO;
        pedido.setMonto_total(total);
        return pedido;
    }

    /*Recibe el detalle de la request y lo convierte a una lista de detalles de pedido*/
    private List<PedidoDetalle> format(List<DetalleHelper> request, PedidoCabecera pedido){
        List<PedidoDetalle> detalle = new ArrayList<>();
        for(DetalleHelper r:request){
            PedidoDetalle det = new PedidoDetalle();
            det.setPedido(pedido);
            det.setCantidad(r.getCantidad());
            det.setProducto(productosRepository.getOne(r.getProducto()));
            det.setPrecio_unitario(det.getProducto().getPrecio_unitario());
            det.setNombre_producto(det.getProducto().getNombre());
            detalle.add(det);
        }
        return detalle;
    }


}
