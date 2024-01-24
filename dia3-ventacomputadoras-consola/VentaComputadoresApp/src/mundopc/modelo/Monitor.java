<<<<<<< HEAD
package mundopc.modelo;
  public class Monitor {

      private final int idMonitor;
      private String marca;
      private double tamanio;
      private static int contadorMonitores;

      private Monitor(){
          idMonitor = ++contadorMonitores;
      }

      public Monitor(String marca, double tamanio){
          this();
          this.marca = marca;
          this.tamanio = tamanio;
      }

      @Override
      public String toString() {
          return "Monitor{" +
                  "idMonitor=" + idMonitor +
                  ", marca='" + marca + '\'' +
                  ", tamanio=" + tamanio +
                  '}';
      }
  }
=======
package mundopc.modelo;
  public class Monitor {

      private final int idMonitor;
      private String marca;
      private double tamanio;
      private static int contadorMonitores;

      private Monitor(){
          idMonitor = ++contadorMonitores;
      }

      public Monitor(String marca, double tamanio){
          this();
          this.marca = marca;
          this.tamanio = tamanio;
      }

      @Override
      public String toString() {
          return "Monitor{" +
                  "idMonitor=" + idMonitor +
                  ", marca='" + marca + '\'' +
                  ", tamanio=" + tamanio +
                  '}';
      }
  }
>>>>>>> a5d00601b59c4ef50c903a5a5f408a5e7a73ab8b
