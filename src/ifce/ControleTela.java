 /* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifce;

import java.rmi.RemoteException;
import net.jini.space.JavaSpace;
import net.jini.core.lease.Lease;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;

/**
 *
 * @author walmi
 */
public class ControleTela {

    private JavaSpace space;
    Icon excluirAmbiente;

    public ControleTela() {
        try {
            System.out.println("Procurando pelo servico JavaSpace...");
            Lookup finder = new Lookup(JavaSpace.class);
            this.space = (JavaSpace) finder.getService();
            if (space == null) {
                System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
                System.exit(-1);
            }
            System.out.println("O servico JavaSpace foi encontrado.");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public String criarUsuario() {
        String finalName;
        try {
            TuplaUsuario usuario = new TuplaUsuario();
            int userIndex = 0;

            while (true) {
                userIndex += 1;
                String userName = "user" + userIndex;
                usuario.nome = userName;
                TuplaUsuario tempUser = (TuplaUsuario) space.read(usuario, null, JavaSpace.NO_WAIT);

                if (tempUser == null) {
                    space.write(usuario, null, Lease.FOREVER);
                    System.out.println("\r\nUsuario registrado como: " + usuario.nome);
                    finalName = userName;
                    break;
                }
            }
            return finalName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String listarUsuario(String ambNome) {
        String nomesUsuarios = "";
        String nomesUsuariosNull = ". Não existe nenhum usuário no ambiente";
        try {
            List<TuplaUsuario> listaUser = Helpers.listaUsuario(space, ambNome);
            for (int i = 0; i < listaUser.size(); i++) {
                nomesUsuarios += listaUser.get(i).nome;
                if (i < listaUser.size() - 1) {
                    nomesUsuarios += ", ";
                }
            }
            System.out.println(nomesUsuarios);
            nomesUsuarios = ". Esses são os dispositivos que estão no ambiente: " + nomesUsuarios;

            if (listaUser.size() == 0) {
                nomesUsuarios = nomesUsuariosNull;
            }

            listaUser.clear();
        } catch (Exception ex) {
            Logger.getLogger(ControleTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomesUsuarios;
    }

    //Mesma função de listar usuarios porem retornando array no layout (user1, user2)   
    public String listarUsuarioBatePapo(String nomeUsuario) {
        String nomesUsuarios = "";
        try {
            TuplaUsuario user = Helpers.encontraUsuario(space, nomeUsuario);
            String ambNome = user.amb;

            List<TuplaUsuario> listaUser = Helpers.listaUsuario(space, ambNome);
            for (int i = 0; i < listaUser.size(); i++) {
                nomesUsuarios += listaUser.get(i).nome;
                if (i < listaUser.size() - 1) {
                    nomesUsuarios += ", ";
                }
            }
            listaUser.clear();
        } catch (Exception ex) {
            Logger.getLogger(ControleTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomesUsuarios;
    }



    public void excluirUsuario(String oldNome) {
        try {
            TuplaUsuario oldUser = new TuplaUsuario();
            oldUser.nome = oldNome;
            space.take(oldUser, null, JavaSpace.NO_WAIT);
            System.out.println("\r\nUsuario " + oldUser + " destruido");

        } catch (UnusableEntryException | TransactionException | InterruptedException | RemoteException ex) {
            Logger.getLogger(ControleTela.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void enviarMensagem(String nomeTo, String usuario, String ambAtual, String mensagemBP) {
        String palavra = "";
        try {
            TuplaMensagem novaMsg = new TuplaMensagem();
            novaMsg.time = System.currentTimeMillis();
            novaMsg.from = usuario;
            novaMsg.to = nomeTo;
            novaMsg.amb = ambAtual;
            novaMsg.msg = mensagemBP;

            space.write(novaMsg, null, Lease.FOREVER);
            System.out.println("\r\nMensagem enviada a " + nomeTo);
              
            
        } catch (TransactionException | RemoteException ex) {
            Logger.getLogger(ControleTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String receberMensagem(String usuario, String ambAtual) {
        String mensagem = "";
        try {
            TuplaMensagem msgTemplate = new TuplaMensagem();
            msgTemplate.to = usuario;
            msgTemplate.amb = ambAtual;

            TuplaMensagem novaMsg = (TuplaMensagem) space.take(msgTemplate, null, JavaSpace.NO_WAIT);

            if (novaMsg == null) {
                System.out.println("\r\nNao ha novas mensagens");
            } else {
                System.out.println();

                while (novaMsg != null) {
                    mensagem = novaMsg.from + ": " + novaMsg.msg + "\n";
                    novaMsg = (TuplaMensagem) space.take(msgTemplate, null, JavaSpace.NO_WAIT);
                    
                }
            }
        } catch (RemoteException | UnusableEntryException | TransactionException | InterruptedException ex) {
            Logger.getLogger(ControleTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mensagem;
    }
    
        public void cadatrarPalavra(String nome) {
        try {
            TuplaPalavra novaPalavra = new TuplaPalavra();
            novaPalavra.nome = nome;
    
            space.write(novaPalavra, null, Lease.FOREVER);
            System.out.println("\r\nNova palavra cadastrada: " + nome);
        } catch (TransactionException | RemoteException ex) {
            Logger.getLogger(ControleTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
