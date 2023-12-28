import java.util.Scanner;

public class Tamagotchi2 {

    private static final int MAX_ENERGIA = 100;
    private static final int MIN_ENERGIA = 0;

    private String nombre;
    private int energia;
    private double peso;
    private boolean dormido;
    private int humor;
    private int cantComer;

    // Constructor
    public Tamagotchi2(String nombre) {
        this.nombre = nombre;
        this.energia = MAX_ENERGIA / 2;  // Inicializar con la mitad de la energía máxima
        this.peso = 5.0;  // Peso inicial arbitrario
        this.dormido = false;
        this.humor = 3;  // Humor inicial neutro
        this.cantComer = 0;
    }

    // Métodos del Tamagotchi
    public void comer() {
        if (!dormido) {
            energia += 20;
            peso += 0.5;
            cantComer++;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha comido! Energía aumentada, peso aumentado.");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda comer.");
        }
    }

    public void dormir() {
        if (!dormido) {
            dormido = true;
            System.out.println("¡" + nombre + " está durmiendo!");
        } else {
            System.out.println("¡" + nombre + " ya está dormido!");
        }
    }

    public void despertar() {
        if (dormido) {
            dormido = false;
            System.out.println("¡" + nombre + " se ha despertado!");
        } else {
            System.out.println("¡" + nombre + " ya está despierto!");
        }
    }

    public void caminar() {
        if (!dormido) {
            energia -= 10;
            peso -= 0.2;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha caminado! Energía disminuida, peso disminuido.");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda caminar.");
        }
    }

    public void correr() {
        if (!dormido) {
            energia -= 30;
            peso -= 0.5;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha corrido! Energía disminuida mucho, peso disminuido mucho.");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda correr.");
        }
    }

    public void obtenerEnergia() {
        if (!dormido) {
            energia += 15;
            ajustarEstado();
            System.out.println("¡" + nombre + " ha obtenido energía!");
        } else {
            System.out.println("¡" + nombre + " está durmiendo! Despiértalo para que pueda obtener energía.");
        }
    }

    public boolean estaVivo() {
        return energia > MIN_ENERGIA && energia <= MAX_ENERGIA;
    }

    public void mostrarEstado() {
        System.out.println("Estado actual de " + nombre);
        System.out.println("Energía: " + energia);
        System.out.println("Peso: " + peso);
        System.out.println("Humor: " + obtenerEmojiHumor());
    }

    private String obtenerEmojiHumor() {
        return switch (humor) {
            case 1 -> "😞";
            case 2 -> "😒";
            case 3 -> "😐";
            case 4 -> "😊";
            case 5 -> "😎";
            default -> "Desconocido";
        };
    }

    private void ajustarEstado() {
        humor = calcularHumor();
    }

    private int calcularHumor() {
        int humorComida;
        if (cantComer >= 3) {
            humorComida = 5;  // Muy feliz si ha comido al menos 3 veces
        } else if (cantComer >= 1) {
            humorComida = 3;  // Neutro si ha comido al menos 1 vez
        } else {
            humorComida = 1;  // Triste si no ha comido
        }

        int humorEnergia;
        if (energia >= 85) {
            humorEnergia = 5;  // Muy feliz si la energía es alta
        } else if (energia >= 50) {
            humorEnergia = 3;  // Neutro si la energía es moderada
        } else {
            humorEnergia = 2;  // Otro estado si la energía es baja
        }

        int humorPeso;
        if (peso >= 8.0) {
            humorPeso = 1;  // Triste si el peso es alto
        } else if (peso >= 5.0) {
            humorPeso = 3;  // Neutro si el peso es moderado
        } else {
            humorPeso = 5;  // Muy feliz si el peso es bajo
        }

        // Combinar los estados de humor y asignar el peor de ellos
        int humorFinal = Math.min(humorComida, Math.min(humorEnergia, humorPeso));

        // Si el peso es muy bajo, actualizar el estado de humor a "Triste"
        if (peso < 3.0) {
            humorFinal = 1;  // Triste
        }

        return humorFinal;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de su Tamagotchi: ");
        String nombre = scanner.nextLine();

        Tamagotchi2 miTamagotchi = new Tamagotchi2(nombre);

        while (miTamagotchi.estaVivo()) {
            miTamagotchi.mostrarEstado();

            System.out.println("\nAcciones disponibles:");
            System.out.println("1. Comer");
            System.out.println("2. Dormir");
            System.out.println("3. Despertar");
            System.out.println("4. Caminar");
            System.out.println("5. Correr");
            System.out.println("6. Obtener Energía");
            System.out.println("7. Salir");

            System.out.print("Ingrese el número de la acción deseada: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    miTamagotchi.comer();
                    break;
                case 2:
                    miTamagotchi.dormir();
                    break;
                case 3:
                    miTamagotchi.despertar();
                    break;
                case 4:
                    miTamagotchi.caminar();
                    break;
                case 5:
                    miTamagotchi.correr();
                    break;
                case 6:
                    miTamagotchi.obtenerEnergia();
                    break;

                case 7:
                    miTamagotchi.mostrarEstado();
                    break;
                case 8:
                    System.out.println("¡Adiós! Gracias por cuidar de " + miTamagotchi.nombre);
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        System.out.println("¡" + miTamagotchi.nombre + " ha fallecido! 😢");
    }
}
