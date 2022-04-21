package Shalsh.ChallengeBackend.Service;

import Shalsh.ChallengeBackend.Model.Producto;
import Shalsh.ChallengeBackend.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductosRepository productosRepository;

    public List<Producto> getAll(){
        return productosRepository.findAll();
    }

    public Producto insert(Producto producto){
        try{
            return productosRepository.save(producto);
        } catch (Exception e){
            return null;
        }
    }

    public boolean delete(String id){
        try{
            Producto producto = this.getOne(id);
            if(producto != null) {
                productosRepository.delete(producto);
                return true;
            } else {
                return false;
            }
        }catch (Exception e) {
            return false;
        }

    }

    public Producto getOne(String id){
        try {
            Producto producto = productosRepository.getOne(id);
            if (producto != null){
                return producto;
            }
            return null;
        } catch (Exception e){
            return null;
        }
    }
}
