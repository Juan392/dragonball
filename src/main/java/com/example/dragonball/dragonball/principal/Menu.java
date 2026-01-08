package com.example.dragonball.dragonball.principal;

import com.example.dragonball.dragonball.model.DatosPersonaje;
import com.example.dragonball.dragonball.model.DatosPlanetas;
import com.example.dragonball.dragonball.model.Personaje;
import com.example.dragonball.dragonball.repositorio.IRepository;
import com.example.dragonball.dragonball.service.ConsumoAPI;
import com.example.dragonball.dragonball.service.Convertidor;
import com.example.dragonball.dragonball.service.GeminiAI;
import org.hibernate.collection.spi.PersistentBag;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    //Establezco la consola
    private static Scanner console = new Scanner(System.in);
    //Variables para llamar a las clases de servicio
    private static ConsumoAPI consumoAPI = new ConsumoAPI();
    //url base
    static final String URl_BASE = "https://dragonball-api.com/api/";
    static  final String PERSONAJES = "characters/";
    static final String PLANETS = "planets/";
    private static  Convertidor convertidor= new Convertidor();
    private IRepository repository = null;

    public Menu(IRepository repository) {
        this.repository = repository;
    }

    public void mostrarMenu(){
        System.out.println("""
                                   _
                               -._ \\'.
                                \\ '.\\_\\_
                             _.--'  _   '.---.
                            /._   _<_)/)/ .-'
                            _.-'- ([d,p]? _.-       .;
                             '--.'-\\ _ /-'--      .:'
                               __  )'-'(  __    .:'
                            .-/  ]' -Y- '[ /\\ _:'
                           /\\|  | -----/ | ,r |
                           |  ,\\  \\'= /'  .:\\ "(
                           | / /\\; \\,/  .:'  |_|
                           \\ _ )<   /  :' \\ /__|
                            '__\\ {---:'-/  \\(  )
                            \\_ _|/_:'-__]   '-'
                              ) .:'    \\ \\
                             (L:/  ;      \\
                            .:~'   |  .   7
                          .:'  /   \\   ' /\\
                        .;'    |\\ . |;     )
                       ;'      | '  |\\'. _/|
                               /'.' (\\\\..  |
                              ( \\. ,|\\ '   /        * * * * * * * * * * * * * *
                              |\\_  / \\ ': /\\       *   𝘽 𝙞 𝙚 𝙣 𝙫 𝙚 𝙣 𝙞 𝙙 𝙤 𝙨   *
                              \\    | |\\  __/        * * * * * * * * * * * * * *
                              |\\   )  \\,___>
                              <-'-/    \\'  |
                              |_ /      |=j|
                           _.-' /       \\  (
                      snd '-----'        \\  \\
                                          '-'
                
                """);
        while (true){
            System.out.println("""
                \t\tSeleccione la opcion:
                \t\t1 - ➕Agregar personaje➕
                \t\t2 - ➕Agregar planeta➕
                \t\t3 - 🏆Mostrar los personajes por orden de fuerza hasta tu personaje🏆
                \t\t4 - 👊Hacer una pelea👊
                \t\t5 - ❌Salir❌""");
            var opcion = console.nextInt();
            console.nextLine();
            switch (opcion){
                case 1-> buscarPersonaje();
                case 2->buscarPlaneta();
                case 3->mostrarPersonajes();
                case 4->hacerPelea();
                case 5-> {
                    System.out.println("Gracias por usar mi programa.");
                    break;
                }
            }
        }


//

        //Mostrar los personajes por orden de fuerza hasta el mayor hasta ese id
//        for (int i = 1; i <= idPersonaje; i++) {
//            json = consumoAPI.consumirAPI(URl_BASE+ PERSONAJES + i);
//            personaje = convertidor.ConvertirDatos(json, DatosPersonaje.class);
//            personajes.add(personaje);
//        }
//
//        personajes.stream()
//                .sorted(Comparator.comparing(DatosPersonaje::ki).reversed())
//                .forEach(System.out::println);

        //Mostrar solo saiyans y nombre

//        Map<String,  String> saiyans = personajes.stream()
//                .filter(e -> e.raza().equals("Saiyan") && e.raza() != null)
//                .collect(Collectors.toMap(DatosPersonaje::nombre, DatosPersonaje::raza));
//        System.out.println(saiyans);

        //Ahora planetas



        //Ahora que muestre los planetas hasta llegar al elegido
//        List<DatosPlanetas> todosLosPlanetas = new ArrayList<>();
//        for (int i = 1; i <= idPlaneta; i++) {
//            json = consumoAPI.consumirAPI(URl_BASE + PLANETS + i);
//            planeta = convertidor.ConvertirDatos(json, DatosPlanetas.class);
//            todosLosPlanetas.add(planeta);
//        }

//        todosLosPlanetas.forEach(System.out::println);
//        //Para mapear los que estan destruidos
//
//        Map<String , Boolean> planeta_destruido = todosLosPlanetas.stream()
//                .filter(p -> p.desutruido())
//                .collect(Collectors.toMap(DatosPlanetas::nombre, DatosPlanetas::desutruido));
//        System.out.println(planeta_destruido);
    }

    private void hacerPelea() {
        System.out.println("Ingresa el nombre del personaje 1: ");
        var personaje1 = repository.findByNombreIgnoreCase(console.nextLine());
        System.out.println("Ingresa el nombre del personaje 1: ");
        var personaje2 = repository.findByNombreIgnoreCase(console.nextLine());
        var batalla = GeminiAI.batalla(personaje1,personaje2);
        System.out.println(batalla);
    }

    private void buscarPersonaje() {
        System.out.println("Ingrese un numero aleatorio menor a 20 para saber su personaje: ");
        var idPersonaje = console.nextInt();
        console.nextLine();
        var json = consumoAPI.consumirAPI(URl_BASE+ PERSONAJES + idPersonaje);
        var personajes = convertidor.ConvertirDatos(json, DatosPersonaje.class);
        System.out.println("Tu personaje: " + personajes);
        repository.save(new Personaje(personajes));
    }

    private void buscarPlaneta(){
        System.out.println("Ingrese un numero aleatorio del 1 al 20 para mostrar un planeta.");
        var idPlaneta = console.nextInt();
        console.nextLine();
        var json = consumoAPI.consumirAPI(URl_BASE + PLANETS + idPlaneta);
        var planeta = convertidor.ConvertirDatos(json, DatosPlanetas.class);
        System.out.println(planeta);
    }

    private void mostrarPersonajes(){
        List<Personaje> personajes = repository.findTopByOrderByKiDesc();
        personajes.forEach(e-> System.out.println(e.getNombre() +"-"+e.getKi()));
    }
}
