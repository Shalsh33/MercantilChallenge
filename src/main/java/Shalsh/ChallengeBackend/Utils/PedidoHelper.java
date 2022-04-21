package Shalsh.ChallengeBackend.Utils;

import java.util.List;

public class PedidoHelper {

    private String direccion;
    private String email;
    private String telefono;
    private String horario;
    private List<DetalleHelper> detalle;

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getHorario() {
        return horario;
    }

    public List<DetalleHelper> getDetalle() {
        return detalle;
    }
}
