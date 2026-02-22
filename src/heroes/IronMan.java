package heroes;

import java.util.ArrayList;

public class IronMan extends Heroe {
    public IronMan() {
        super("IronMan", new ArrayList<>());

        habilidades.add(new HabilidadBasica("Volar"));
        habilidades.add(new HabilidadBasica("Tecnologia"));
        habilidades.add(new HabilidadBasica("DisparoEnergetico"));
    }
}
