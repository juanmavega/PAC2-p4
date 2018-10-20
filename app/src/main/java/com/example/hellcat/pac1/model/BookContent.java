package com.example.hellcat.pac1.model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creamos la clase BookContent para los procedimientos de creación
 * de la lista de BookItem y su Map
 */
public class BookContent {

    /**
     * Creación de ITEMS como objeto que podrá ser accedido por el resto de clases como variable constante.
     * Es la lista de BookItems usada en el recyclerview
     */
    public static final List<BookItem> ITEMS = new ArrayList<BookItem>();

    /**
     * Como lo anterior, pero en Map se añade una key para fácil localización de un item determinado por su valor de key
     */
    public static final Map<String, BookItem> ITEM_MAP = new HashMap<String, BookItem>();

//cargamos los valores para tener datos por defecto

    static {
        /*
         * solucionado el tema de la fecha usando calendario. Se crea una instancia de calendario, ya que se trata de
         * una interfaz. Metemos año, mes y día y finalmente hacemos un getTime que nos da la Date correspondiente.
         */
        addItem(new BookItem(1, "El mundo invertido", "Christopher Priest", creaDate(2018, 10, 2), "La ciudad avanza por medio de raíles, surcando una tierra devastada llena de tribus hostiles. Los raíles deben ir colocándose delante de ella al tiempo que se progresa y ser retirados cuidadosamente tras su estela. Los ríos y las montañas suponen un obstáculo casi insalvable para el ingenio de los técnicos de la ciudad. Pero si se detiene su movimiento, la ciudad va cayendo en el campo gravitacional destructor que ha transformado la vida en la Tierra. La única alternativa a la muerte es el avance. Helward Mann, un miembro de la élite de la ciudad, sabe mejor que nadie que su existencia pende de un hilo: está a punto de descubrir que el mundo exterior es infinitamente más extraño que su propio entorno, que tan bien cree conocer.", "imagen1"));
        addItem(new BookItem(2, "El Hobbit", "J.R.R. Tolkien", creaDate(2017, 12, 2), "Bilbo Baggins lleva una vida sencilla con sus compañeros hobbits en la comarca, hasta que el mago Gandalf llega y lo convence de unirse a un grupo de enanos para recuperar el reino de Erebor. El viaje lleva a Bilbo en un camino a través de tierras peligrosas llenas de orcos, goblins y otras amenazas, además de su encuentro con Gollum y un sencillo anillo de oro que está unido al destino de la Tierra Media de una forma que Bilbo no puede imaginarse.", "imagen2"));
        addItem(new BookItem(3, "El tercer brazo", "Larry niven & Jerry Pournelle", creaDate(2005, 6, 30), "Hace un cuarto de siglo, una expedición descubrió el sistema de la Paja y la humanidad tuvo su primer contacto con otra especie inteligente, cuya expansión por la galaxia resultaría letal para los hombres. En aquel entonces, éstos fueron capaces de contener a los alienígenas encerrándolos en su lugar de origen. Pero ahora, la peor pesadilla se ha hecho realidad: los pajeños han superado el cerco, y la voz de alarma llega demasiado tarde. La guerra por el Imperio ha empezado.", "imagen3"));
        addItem(new BookItem(4, "Ready Player One", "Ernest Cline", creaDate(2013, 1, 7), "Estamos en el año 2044 y, como el resto de la humanidad, Wade Watts prefiere mil veces el videojuego de OASIS al cada vez más sombrío mundo real. Se asegura que esconde las diabólicas piezas de un rompecabezas cuya resolución conduce a una fortuna incalculable. Las claves del enigma están basadas en la cultura de finales del siglo XX y, durante años, millones de humanos han intentado dar con ellas, sin éxito. De repente, Wade logra resolver el primer rompecabezas del premio, y, a partir de ese momento, debe competir contra miles de jugadores para conseguir el trofeo. La única forma de sobrevivir es ganar; pero para hacerlo tendrá que abandonar su existencia virtual y enfrentarse a la vida y al amor en el mundo real, del que siempre ha intentado escapar.", "imagen4"));
        addItem(new BookItem(5, "Yo, robot", "Isaac Asimov", creaDate(2016, 11, 23), "Publicada por primera vez en 1950, cuando la electrónica digital estaba en su infancia, Yo, robot resultó ciertamente visionaria y tendría una influencia enorme no sólo en toda la ciencia ficción posterior, sino incluso en la propia ciencia de la robótica. Aquí formuló Issac Asomov por primera vez las tres leyes fundamentales de la robótica, de las que se valdría para plantear interrogantes que se adentran en el campo de la ética y de la psicología: ¿qué diferencia hay entre un robot inteligente y un ser humano?, ¿puede el creador de un robot predecir su comportamiento?, ¿debe la lógica determinar lo que es mejor para la humanidad? A través de una serie de historias conectadas entre sí por el personaje de la robopsicóloga Susan Calvin, en las que aparecen todo tipo de máquinas inteligentes -  robots que leen el pensamiento, robots que se vuelven locos, robots con sentido del humor o robots políticos-, Asimov inventa unos robots cada vez más perfectos, que llegan a convertirse en un desafío para sus creadores.", "imagen5"));
        addItem(new BookItem(6, "La guerra de los mundos", "H.G.Wells", creaDate(2015, 2, 5), "Las fábulas ideadas por H.G. Wells (1866-1946), uno de los padres, acaso el más notable, de la ciencia ficción, han demostrado a lo largo del tiempo mantener un vigor y tocar unos resortes del inconsciente humano que a menudo las han elevado a iconos del mundo moderno. La guerra de los mundos (1898), relato trepidante que narra la invasión de la Tierra por los marcianos y que supuso por primera vez la irrupción de seres de otros planetas en el nuestro, marcó en buena medida la fantasía del siglo xx y abrió un filón –el del contacto de los hombres con seres extraterrestres– que no tardó en convertirse en uno de los más importantes de la ciencia ficción, sirviendo de inspiración a numerosos artistas posteriores en los ámbitos de la radio, el cine, la literatura, el cómic y la televisión.", "imagen6"));
        addItem(new BookItem(7, "La luna es una cruel amante", "Robert A. Heinlein", creaDate(2009, 6, 3), "Aunque sus abuelos fueron recluidos en su día en la colonia, Mannie nació libre y eso supone una gran diferencia. Como contratista privado, hace negocios con la Autoridad pero no figura en su nómina. El régimen de Luna es severo e injusto, la revolución se masca en el ambiente y se habla incluso de derrocar a la odiada Autoridad. Cuando Mannie ayuda a la preciosa Wyoming Knott a escapar de los guardaespaldas del Guardián, se encuentra de alguna manera en el centro de una rebelión sin esperanza. Aunque Mannie tiene un arma secreta: Mike es el ordenador más inteligente de la colonia, está conectado a toda clase de equipos útiles... Y Mannie es el mejor amigo de Mike. La Luna es una Cruel Amante, ganadora del Premio Hugo, es una brillante obra de uno de los maestros más reconocidos de la cf, que mezcla un estilo elegante y de ritmo vertiginoso con personajes fascinantes, unos diálogos ingeniosos e ideas que hacen reflexionar. ", "imagen7"));
        addItem(new BookItem(8, "Tropas del espacio", "Robert A. Heinlein", creaDate(2006, 12, 31), "La Tierra, siglo XXIII: Johnnie Rico acaba de cumplir los dieciocho, y por fin se puede alistar en el Ejército para cumplir con el servicio de dos años, tras el cuál se convertirá en un ciudadano con derecho al voto. A instancias de un amigo, Rico se alista en la infantería móvil. Tras un duro periodo de instrucción en el campamento Arthur Currie, bajo las órdenes del sargento Zim, Rico se convirtió en un soldado cualificado. Mientras tanto, una especie alienígena con aspecto de insecto gigante ataca la Tierra con una violencia inusitada, convirtiendo la ciudad de Buenos Aires en un amasijo de escombros. Es el momento de que Johnnie Rico y sus compañeros prueben su valía en un combate real... en el espacio. ", "imagen8"));
        addItem(new BookItem(9, "El orgullo de Chanur", "C.J.Cherryh", creaDate(2003, 4, 12), "Los comerciantes hani y sus antiguos enemigos, los kif, coexisten en precaria paz en la estación Punto de Encuentro. Hasta que el Extraño aparece y provoca la gran conmoción que acabará poniendo en peligro el pacto interestelar entre diversas especies. La capitana hani Pyanfar Chanur deberá afrontar la persecución de los kif, con la ayuda de los mahendo sat y la constante presencia de los misteriosos knnn. Y todo ello sin olvidar la defensa de la mismísima casa de Chanur en su planeta natal.", "imagen9"));

    }

    static public Date creaDate(Integer anyo, Integer mes, Integer dia) {

        // al final ha sido posible solucionar el tema del año, pero seguía dando problema los meses que cuentan desde 0,
        // así que se corrige. No se deja tal cual porque si metemos un mes doce hace que la cuenta de años avance uno.

        Calendar cal = Calendar.getInstance();
        cal.set(anyo, mes - 1, dia);
        //Salida al log paera localizar los problemas de fecha
        //Date fecha = cal.getTime();
        //Log.e("Pruebas date    ", cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH));
        //Log.e("Pruebas date dos", new SimpleDateFormat("yyyy-MMM-dd").format(fecha));
        return cal.getTime();

    }

    /*
     * rutina que añade los items a la lista ITEMS y al Map ITEM_MAP
     *
     */
    private static void addItem(BookItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(Integer.toString(item.getIdentificador()), item);
    }
}