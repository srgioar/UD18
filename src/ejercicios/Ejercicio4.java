package ejercicios;
import java.sql.Connection;
import java.util.ArrayList;

import conector.ConectorCustom;

/* 
 * 		openConnection();
		createDB("BD_prueba1");
		createTable("BD_prueba1","Tabla_1");
		insertData("BD_prueba1","Tabla_1","name", "lastname", "age", "H");
		getValues("BD_prueba1","Tabla_1");
		deleteRecord("BD_prueba1","Tabla_1", "1");
		closeConnection();
 * 
 * */

public class Ejercicio4 extends ConectorCustom {
	
	String db = "E4_CINE";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio4() {
		
		System.out.println(db);
		
		tablas = new String[2];
		
		tablas[0] = "CREATE TABLE PELICULAS (\r\n"
				+ "Codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "Nombre VARCHAR(100),\r\n"
				+ "CalificacionEdad INT NULL\r\n"
				+ ")";
		
		tablas[1] = "CREATE TABLE SALAS(\r\n"
				+ "Codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "Nombre VARCHAR(100),\r\n"
				+ "CodigoPelicula INT,\r\n"
				+ "Key (CodigoPelicula),\r\n"
				+ "FOREIGN KEY (CodigoPelicula) REFERENCES PELICULAS (Codigo) ON DELETE CASCADE ON UPDATE CASCADE \r\n"
				+ ")";
		
		// PELICULAS
		
		inserciones.add(""
				+ "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES (\"Pacific Rim\", 13)"
				);
		
		inserciones.add(""
				+ "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES (\"Alita\", 13)"
				);
		
		inserciones.add(""
				+ "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES (\"Toy Story\", 3)"
				);
		
		inserciones.add(""
				+ "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES (\"Avatar\", 7)"
				);
		
		inserciones.add(""
				+ "INSERT INTO PELICULAS (Nombre, CalificacionEdad) VALUES (\"Alvin y las Ardillas\", null)"
				);
		
		// SALAS
		
		inserciones.add(""
				+ "INSERT INTO SALAS (Nombre, CodigoPelicula) VALUES (\"Gavarres1\", 1)"
				);
		
		inserciones.add(""
				+ "INSERT INTO SALAS (Nombre, CodigoPelicula) VALUES (\"Gavarres2\", 2)"
				);
		
		inserciones.add(""
				+ "INSERT INTO SALAS (Nombre, CodigoPelicula) VALUES (\"Gavarres3\", 3)"
				);
		
		inserciones.add(""
				+ "INSERT INTO SALAS (Nombre, CodigoPelicula) VALUES (\"Gavarres4\", 4)"
				);
		
		inserciones.add(""
				+ "INSERT INTO SALAS (Nombre, CodigoPelicula) VALUES (\"Gavarres5\", 5)"
				);

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
