package es.events.persistencia;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


// ********************    PATRON SINGLETON QUE DEVUELVE NUESTRO ENTITY MANAGER FACTORY:  ***************************
// ( HAGO EN PRIVADO Y STATIC EL ATRIBUTO SIEMPRE; Y UN METODO PUBLICO Y STATIC QUE DEVUELVA ESA REFERENCIA )

public class EMF {
		//1. DECLARACION emf QUE ES ATRIBUTO ESTATICO DE TIPO Entity...YA QUE SERÁ LA ÚNICA INSTANCIA EN LA APP; ADEMÁS, AL SER static, 
		//ES ACCESIBLE DESDE CUALQUIER PARTE DEL CODIGO USANDO LA CLASE EMF SIN NECESIDAD DE CREAR UNA INSTANCIA DE CLASE :
		private static EntityManagerFactory emf; 
		
		//2. ÚNICO CONSTRUCTOR PRIVADO:  
		//( PRIVADO: PARA QUE NO SE PUEDA CREAR INSTANCIAS DE ESTA CLASE DESDE FUERA DE LA PROPIA CLASE )
		private EMF() {
			
		}
		
		//3. METODO FACTORIA:  
		//( METODO PUBLICO STATIC QUE DEVUELVE LA ÚNICA INSTANCIA DEL ENTITY MANAGER FACTORY )
		public static EntityManagerFactory getInstance() {
			
			if(emf == null) { //SE COMPRUEBA. SI ES NULO, ES QUE AÚN NO SE CREÓ UNA INSTANCIA DEL EMF. EN ESTE CASO, SE CREA CON:
				emf = Persistence.createEntityManagerFactory("events"); // PARAMETRO EL persistnce.unit, SU NOMBRE events
			}
			//FINALMENTE, EL MET. DEVUELVE UNA INSTANCIA DEL EMF
			return emf;
		
	}

		//NOTA: Patron Singleton hace que la clase utilice un constructor privado y un método estático getInstance() 
		//para garantizar que solo existe una instancia del 	EntityManagerFactory en la aplicación.
}
