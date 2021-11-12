/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author gonza
 */
public class Participacion implements Comparable<Participacion> {

    private int cantidadParticipantes;
    private Jugador jugador;
    private ArrayList<Carta> cartasJugador = new ArrayList();
    private Apuesta apuesta = new Apuesta();
    private Figura figura = null;
    private boolean noApuesta = false;

    public Participacion(Jugador jugador) {
        this.jugador = jugador;
        //this.setFigura();
    }

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public ArrayList<Carta> getCartasJugador() {
        return cartasJugador;
    }

    public void setCartasJugador(Carta carta) {
        this.cartasJugador.add(carta);
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }

    public Figura getFigura() {
        return this.figura;
    }

    public void setFigura() {
        int contadornum = 0;
        int contadorpalo = 0;
        for (int i = 0; i < cartasJugador.size(); i++) {
            for (int j = i + 1; j < cartasJugador.size(); j++) {
                if (cartasJugador.get(i).getNumero() == cartasJugador.get(j).getNumero()) {
                    contadornum++;
                }
                if (cartasJugador.get(i).getPalo() == cartasJugador.get(j).getPalo()) {
                    contadorpalo++;
                }
            }
        }
        if (contadorpalo == 4) {
            this.figura = new Color();
        }
        if (contadornum == 1) {
            this.figura = new Par();
        } else if (contadornum == 2) {
            this.figura = new Pierna();
        } else {
            this.figura = null;
        }
    }

    public void apostar(double monto) {
        apuesta.setMonto(monto);
        setSaldoJugador(getSaldoJugador() - monto);
    }

    public double getSaldoJugador() {
        return this.jugador.getSaldo();
    }

    public void setSaldoJugador(double saldo) {
        this.jugador.setSaldo(saldo);
    }

    @Override
    public int compareTo(Participacion o) {
        if (this.figura == null && o.getFigura() == null) {
            if(this.compararCartas(o)==1){
                return 1;
            }else if(this.compararCartas(o)==-1){
                return -1;
            }
        } else {
            if (this.cartasSinFigura(o) == 1 || this.figura.compareTo(o.getFigura()) == 1) {
                return 1;
            } else if (this.cartasSinFigura(o) == -1 || this.figura.compareTo(o.getFigura()) == -1) {
                return -1;
            } else {
                if (this.figura instanceof Par && o.getFigura() instanceof Par) {
                    if (this.resolverPar(o) == 1) {
                        return 1;
                    } else if (this.resolverPar(o) == -1) {
                        return -1;
                    }
                }else if (this.figura instanceof Pierna && o.getFigura() instanceof Pierna) {
                    if (this.resolverPierna(o) == 1) {
                        return 1;
                    } else if (this.resolverPierna(o) == -1) {
                        return -1;
                    }
                }else if (this.figura instanceof Color && o.getFigura() instanceof Color) {
                    if (this.cartasJugador.get(0).getPalo().compareTo(o.getCartasJugador().get(0).getPalo()) == 1) {
                        return 1;
                    } else if (this.cartasJugador.get(0).getPalo().compareTo(o.getCartasJugador().get(0).getPalo()) == -1) {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }

    private int compararCartas(Participacion o) {
        int aux1 = 0;
        int aux2 = 0;
        for (Carta c : this.cartasJugador) {
            if (c.getNumero() > aux1) {
                aux1 = c.getNumero();
            }
        }
        for (Carta c : o.getCartasJugador()) {
            if (c.getNumero() > aux2) {
                aux2 = c.getNumero();
            }
        }
        if (aux1 > aux2) {
            return 1;
        } else {
            return -1;
        }
    }

    private int cartasSinFigura(Participacion o) {
        if (this.figura != null && o.getFigura() == null) {
            return 1;
        } else if (this.figura == null && o.getFigura() != null) {
            return -1;
        } else {
            if (this.compararCartas(o) == 1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private int resolverPierna(Participacion o) {
        int contador = 0;
        int aux1 = 0;
        int aux2 = 0;
        for (int i = 0; i < this.cartasJugador.size(); i++) {
            for (int j = i + 1; j < this.cartasJugador.size(); j++) {
                if (this.cartasJugador.get(i).getNumero() == this.cartasJugador.get(j).getNumero()) {
                    contador++;
                    if (contador == 3) {
                        aux1 = this.cartasJugador.get(i).getNumero();
                        contador = 0;
                    }
                }
            }
        }
        for (int i = 0; i < o.cartasJugador.size(); i++) {
            for (int j = i + 1; j < o.cartasJugador.size(); j++) {
                if (o.cartasJugador.get(i).getNumero() == o.cartasJugador.get(j).getNumero()) {
                    contador++;
                    if (contador == 3) {
                        aux2 = this.cartasJugador.get(i).getNumero();
                        contador = 0;
                    }
                }
            }
        }
        if (aux1 > aux2) {
            return 1;
        } else {
            return -1;
        }
    }

    private int resolverPar(Participacion o) {
        int aux1 = 0;
        int aux2 = 0;
        int auxmayor1 = 0;
        int auxmayor2 = 0;
        for (int i = 0; i < this.cartasJugador.size(); i++) {
            for (int j = i + 1; j < this.cartasJugador.size(); j++) {
                if (this.cartasJugador.get(i).getNumero() == this.cartasJugador.get(j).getNumero() && this.cartasJugador.get(i).getNumero() > aux1) {
                    aux1 = this.cartasJugador.get(i).getNumero();
                }
            }
        }
        for (int i = 0; i < o.cartasJugador.size(); i++) {
            for (int j = i + 1; j < this.cartasJugador.size(); j++) {
                if (o.cartasJugador.get(i).getNumero() == o.cartasJugador.get(j).getNumero() && o.cartasJugador.get(i).getNumero() > aux1) {
                    aux2 = o.cartasJugador.get(i).getNumero();
                }
            }
        }
        if (aux1 > aux2) {
            return 1;
        } else if (aux1 < aux2) {
            return -1;
        } else {
            for (Carta c : this.cartasJugador) {
                if (c.getNumero() != aux1 && c.getNumero() > auxmayor1) {
                    auxmayor1 = c.getNumero();
                }
            }
            for (Carta c : o.cartasJugador) {
                if (c.getNumero() != aux1 && c.getNumero() > auxmayor2) {
                    auxmayor2 = c.getNumero();
                }
            }
            if (auxmayor1 > auxmayor2) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public boolean getNoApuesta() {
        return noApuesta;
    }

    public void setNoApuesta(boolean noApuesta) {
        this.noApuesta = noApuesta;
    }

}
