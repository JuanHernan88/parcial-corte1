package heroes;

import java.util.List;

import interfaces.IHabilidad;

public class IronMan extends Heroe {

    public IronMan() {
        super("IronMan", crearHabilidades());
    }

    private static List<IHabilidad> crearHabilidades() {
        return List.of(
            new HabilidadBasica("Volar"),
            new HabilidadBasica("Tecnologia"),
            new HabilidadBasica("DisparoEnergetico")
        );
    }
}
