package Shalsh.ChallengeBackend.Controller;

import Shalsh.ChallengeBackend.Model.PedidoCabecera;
import Shalsh.ChallengeBackend.Service.PedidoService;
import Shalsh.ChallengeBackend.Utils.PedidoHelper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping()
    public ResponseEntity add(@RequestBody @NotNull PedidoHelper pedido){
        try{
            PedidoCabecera response = pedidoService.add(pedido);
            if(response != null){
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity getAllByFecha(@RequestParam(name = "fecha") String fecha){
        try{
            List<PedidoCabecera> response;
            response = pedidoService.getAllByFecha(fecha);
            if (response != null){
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
