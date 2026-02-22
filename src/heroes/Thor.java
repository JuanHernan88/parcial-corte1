package heroes;

import java.util.ArrayList;

public class Thor extends Heroe {

    public Thor() {
        super("Thor", new ArrayList<>());

        habilidades.add(new HabilidadBasica("ControlDeTrueno"));
        habilidades.add(new HabilidadBasica("Volar"));
    }
}