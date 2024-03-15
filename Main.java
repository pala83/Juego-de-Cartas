import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import JuegoCartas.Atributo;
import JuegoCartas.Carta;
import JuegoCartas.Juego;
import JuegoCartas.JuegoConPocimas;
import JuegoCartas.Jugador;
import JuegoCartas.Pocima;
import JuegoCartas.PocimaCockail;
import JuegoCartas.PocimaSimple;
import JuegoCartas.Efectos.EfectoIgual;
import JuegoCartas.Efectos.EfectoResta;
import JuegoCartas.Efectos.EfectoSelectivo;
import JuegoCartas.Efectos.EfectoSuma;
import JuegoCartas.Estrategias.Obstinado;
import JuegoCartas.Estrategias.Timbero;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> nombres = new ArrayList<>(List.of("Superman","Batman","Spiderman","Wonder Woman","Iron Man","Captain America","Hulk","Thor","Black Widow","Wolverine","Deadpool","The Flash","Aquaman","Green Lantern","Robin Hood","King Arthur","Joan of Arc","Cleopatra","Alexander the Great","Julius Caesar","Leonardo da Vinci","Michelangelo","Galileo Galilei","Isaac Newton","Albert Einstein","Mahatma Gandhi","Nelson Mandela","Martin Luther King Jr.","Winston Churchill","Horacio Guarany","George Washington","Carlos Bala","Joan of Arc","Queen Elizabeth I","Marie Curie","Amelia Earhart","Rosa Parks","Frida Kahlo","Pablo Picasso","Vincent van Gogh","Beethoven","Mozart","William Shakespeare","Gallo Claudio","Hercules","Martin Fierro","Achilles","Perseus","Pinocho","Theseus","Little Red Riding Hood","Cinderella","Snow White","Sleeping Beauty","Pocahontas","Mulan","Los 7 enanos","Aladdin","Tarzan","Aristarco de Samos","Robin Hood","Sherlock Holmes","Dracula","Frankenstein's Monster","Dr. Jekyll and Mr. Hyde","James Bond","Harry Potter","Frodo Baggins","Luke Skywalker","Indiana Jones","James Bond","Lara Croft","Gato con botas","Mirtha Legrand","Don Segundo Sombra","Frodo Baggins","Bilbo Baggins","Gandalf","Legolas","Aragorn","Gimli","Samwise Gamgee","Voldemort","Darth Vader","Yoda","Luke Skywalker","Han Solo","Princess Leia","Chewbacca","R2-D2","C-3PO","Emperor Palpatine","Anakin Skywalker","Captain Jack Sparrow","Elizabeth Swann","Davy Jones","Jafar","Ursula","Maleficent","Benito Mussolini"));
        List<String> atributos = new ArrayList<>(List.of("Altura", "Peso", "Fuerza", "Peleas ganadas", "Velocidad", "Poder total", "Edad", "Agilidad", "Resistencia", "Inteligencia"));
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|------------------------- JUEGO DE CARTAS -------------------------|");
        System.out.println("|-------------------------------------------------------------------|");
        Scanner scan = new Scanner(System.in);
        List<Carta> mazo = generarMazo(nombres, atributos, scan);
        List<Pocima> pocimas = crearPocimas();
        System.out.print("Nombre de jugador 1: ");
        String nj1 = scan.nextLine();
        System.out.print("Nombre de jugador 2: ");
        String nj2 = scan.nextLine();
        Jugador j1 = new Jugador(nj1, new Timbero());
        Jugador j2 = new Jugador(nj2, new Obstinado(mazo.get(0)));
        limipiar();
        System.out.println("|-------------------------------------------------------------------|");
        System.out.println("|------------------------- JUEGO DE CARTAS -------------------------|");
        System.out.println("|-------------------------------------------------------------------|");
        System.out.print("Ingrese la palabra clave 'pocima' si desea jugar con pocimas, en cualqueir otro caso se ejecutara el juego sin ellas: ");
        String clave = scan.nextLine();
        Juego juego;
        if(clave.toLowerCase().equals("pocima"))
            juego = new JuegoConPocimas(j1, j2, pocimas);
        else
            juego = new Juego(j1, j2);
        juego.repartirCartas(mazo);
        juego.jugar(200);
        scan.close();
    }

    public static List<Pocima> crearPocimas(){
        Pocima fortalecedora = new PocimaSimple("Fortalecedora",new EfectoSuma(.2));
        Pocima debilitadora = new PocimaSimple("Debilitadora", new EfectoResta(.2));
        Pocima fortalecedoraPlus = new PocimaSimple("Fortalecedora plus", new EfectoSuma(.5));
        Pocima debilitadoraPlus = new PocimaSimple("Debilitadora plus", new EfectoResta(.5));
        Pocima kriptonita = new PocimaSimple("Kriptonita", new EfectoResta(.25));
        Pocima espinaca = new PocimaSimple("Espinaca de Popeye", new EfectoSuma(1.25));
        Pocima reductorDePlomo = new PocimaSimple("Reductor de Plomo", new EfectoResta(.55));
        Pocima reductorDeMercurio = new PocimaSimple("Reductor de Mercurio", new EfectoResta(.75));
        Pocima quieroValeCuatro = new PocimaSimple("Quiero vale cuatro", new EfectoIgual(4));
        Pocima realEnvido = new PocimaSimple("Real Envido", new EfectoIgual(3));
        Pocima numeroMagico = new PocimaSimple("Numero Satanico", new EfectoIgual(666));
        Pocima numeroSatanico = new PocimaSimple("Numero Mágico", new EfectoIgual(23));
        Pocima selectivaFuerza = new PocimaSimple("Pocima Selectiva Fuerza", new EfectoSelectivo(.35, "Fuerza"));
        Pocima selectivaPeso = new PocimaSimple("Pocima Selectiva Peso", new EfectoSelectivo(.43, "Peso"));
        Pocima selectivaAltura = new PocimaSimple("Pocima Selectiva Altura", new EfectoSelectivo(.44, "Altura"));
        Pocima selectivaPeleasGanadas = new PocimaSimple("Pocima Selectiva Peleas Ganadas", new EfectoSelectivo(.47, "Peleas Ganadas"));
        Pocima selectivaVelocidad = new PocimaSimple("Pocima Selectiva Velocidad", new EfectoSelectivo(.8, "Velocidad"));
        Pocima selectivaPoderTotal = new PocimaSimple("Pocima Selectiva Poder Total", new EfectoSelectivo(.3, "Poder Total"));
        Pocima selectivaEdad = new PocimaSimple("Pocima Selectiva Edad", new EfectoSelectivo(.6, "Edad"));
        Pocima selectivaAgilidad = new PocimaSimple("Pocima Selectiva Agilidad", new EfectoSelectivo(.2, "Agilidad"));
        Pocima selectivaResistencia = new PocimaSimple("Pocima Selectiva Resistencia", new EfectoSelectivo(2, "Resistencia"));
        Pocima selectivaInteligencia = new PocimaSimple("Pocima Selectiva Inteligencia", new EfectoSelectivo(.6, "Inteligencia"));
        PocimaCockail cocktailPrim = new PocimaCockail("Cocktail");
        PocimaCockail cocktailSeg = new PocimaCockail("Cocktail");
        cocktailPrim.agregarPocima(selectivaFuerza);
        cocktailPrim.agregarPocima(fortalecedora);
        cocktailSeg.agregarPocima(quieroValeCuatro);
        cocktailSeg.agregarPocima(cocktailPrim);
        List<Pocima> retorno = new ArrayList<>(List.of(fortalecedora, debilitadora, debilitadoraPlus, espinaca, reductorDeMercurio, realEnvido, numeroSatanico, selectivaAltura, selectivaPeleasGanadas, selectivaVelocidad, selectivaPoderTotal, selectivaEdad, selectivaAgilidad, selectivaResistencia, selectivaInteligencia, fortalecedoraPlus, kriptonita, reductorDePlomo, quieroValeCuatro, numeroMagico, selectivaFuerza, selectivaPeso, cocktailPrim, cocktailSeg));
        return retorno;
    }

    public static List<Carta> crearCartas(List<String> nombres, List<String> atributos){
        List<Carta> retorno = new ArrayList<>();
        Random random = new Random();
        for (String nombre : nombres) {
            Carta carta = new Carta(nombre);
            for (String atributo : atributos) {
                int valor = random.nextInt(1000)+1; // Valor numérico aleatorio entre 1 y 1000
                Atributo atr = new Atributo(atributo, valor);
                carta.addAtributo(atr);
            }
            retorno.add(carta);
        }
        return retorno;
    }
    public static List<Carta> generarMazo(List<String> nombres, List<String> atributos, Scanner scan){
        System.out.print("Ingrese un valor entre 24 y "+ nombres.size() +" para generar las cartas: ");
        int cantNombres = scan.nextInt();
        System.out.print("Ingrese un valor entre 2 y "+ atributos.size() +" para la cantidad de atributos en cada personaje: ");
        int cantAtributos = scan.nextInt();
        scan.nextLine();
        List<String> nombresAleatorios = aleatorizador(new ArrayList<String>(List.copyOf(nombres)), cantNombres);
        List<String> atributosAleatorios = aleatorizador(new ArrayList<String>(List.copyOf(atributos)), cantAtributos);
        return crearCartas(nombresAleatorios, atributosAleatorios);
    }
    public static List<String> aleatorizador(List<String> contenido, int tam){
        List<String> retorno = new ArrayList<>();
        Random rand = new Random();
        for(int i=0; i<tam; i++)
            retorno.add(contenido.remove(rand.nextInt(contenido.size())));
        return retorno;
    }

    public static void limipiar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
/*
    public static List<Carta> prueba(List<String> nombres, List<String> atributos) throws IOException {
        List<String> objetosJson = new ArrayList<>();
        List<Carta> retorno = new ArrayList<>();
        Random random = new Random();

        for (String nombre : nombres) {
            Carta carta = new Carta(nombre);
            StringBuilder objetoJson = new StringBuilder();
            objetoJson.append("{\n");
            objetoJson.append("\t\"nombre\": \"").append(nombre).append("\",\n");
            objetoJson.append("\t\"atributos\": {\n");

            for (String atributo : atributos) {
                int valor = random.nextInt(1000)+1; // Valor numérico aleatorio entre 1 y 1000
                objetoJson.append("\t\t\"").append(atributo).append("\": ").append(valor);
                if (atributos.indexOf(atributo) < atributos.size() - 1) {
                    objetoJson.append(",");
                }
                objetoJson.append("\n");
                Atributo atr = new Atributo(atributo, valor);
                carta.addAtributo(atr);
            }
            objetoJson.append("  }\n}");
            objetosJson.add(objetoJson.toString());
            retorno.add(carta);
        }

        StringBuilder contenidoJson = new StringBuilder();
        contenidoJson.append("[\n");
        for (String objeto : objetosJson) {
            contenidoJson.append(objeto);
            if (objetosJson.indexOf(objeto) < objetosJson.size() - 1) {
                contenidoJson.append(",");
            }
            contenidoJson.append("\n");
        }
        contenidoJson.append("]");
        Path archivoJsonPath = Paths.get("datos.json");
        Files.writeString(archivoJsonPath, contenidoJson.toString(), StandardCharsets.UTF_8);
        return retorno;
    }
*/
}




