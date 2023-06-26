package ifce;

import net.jini.space.JavaSpace;
import net.jini.core.lease.Lease;

import java.util.*;

public class Helpers {

    public static List<TuplaUsuario> listaUsuario(JavaSpace space) throws Exception {
        return listaUsuario(space, "");
    }

    public static List<TuplaUsuario> listaUsuario(JavaSpace space, String amb) throws Exception {
        List<TuplaUsuario> listaUser = new ArrayList<TuplaUsuario>();
        TuplaUsuario template = new TuplaUsuario();
        TuplaUsuario user;

        if (amb != "") {
            template.amb = amb;
        }

        do {
            user = (TuplaUsuario) space.take(template, null, JavaSpace.NO_WAIT);

            if (user != null) {
                listaUser.add(user);
            }
        } while (user != null);

        for (int i = listaUser.size() - 1; i >= 0; i--) {
            user = listaUser.get(i);
            space.write(user, null, Lease.FOREVER);

            if (amb == null && user.amb != null) {
                listaUser.remove(user);
            }
        }

        return listaUser;
    }

    public static TuplaUsuario encontraUsuario(JavaSpace space, String nomeUsuario) throws Exception {
        TuplaUsuario template = new TuplaUsuario();
        template.nome = nomeUsuario;
        return (TuplaUsuario) space.read(template, null, JavaSpace.NO_WAIT);

    }
    
     public static List<TuplaPalavra> listaPalavras(JavaSpace space) throws Exception {
        return listaPalavras(space, "");
    }
     
     public static List<TuplaPalavra> listaPalavras(JavaSpace space, String amb) throws Exception {
        List<TuplaPalavra> listaPalavras = new ArrayList<TuplaPalavra>();
        TuplaPalavra template = new TuplaPalavra();
        TuplaPalavra nome;

        do {
            nome = (TuplaPalavra) space.take(template, null, JavaSpace.NO_WAIT);

            if (nome != null) {
                listaPalavras.add(nome);
            }
        } while (nome != null);

        for (int i = listaPalavras.size() - 1; i >= 0; i--) {
            nome = listaPalavras.get(i);
            space.write(nome, null, Lease.FOREVER);
        }

        return listaPalavras;
    }

}
