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

public class Ejercicio3 extends ConectorCustom {
	
	String db = "E3_ALMACENES";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio3() {
		
		System.out.println(db);
		
		tablas = new String[2];
		
		tablas[0] = "CREATE TABLE ALMACENES (\r\n"
				+ "Codigo INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "Lugar VARCHAR(100),\r\n"
				+ "Capacidad INT(6)\r\n"
				+ ")";
		
		tablas[1] = "CREATE TABLE CAJAS (\r\n"
				+ "NumReferencia INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "Contenido VARCHAR(100),\r\n"
				+ "Valor INT,\r\n"
				+ "Almacen INT,\r\n"
				+ "KEY (Almacen),\r\n"
				+ "FOREIGN KEY (Almacen) REFERENCES ALMACENES (Codigo) ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")";
		
		// ALMACENES
		
		inserciones.add(""
				+ "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES (\"Tarragona\", 50)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES (\"Madrid\", 440)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES (\"Burgos\", 30)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES (\"Barcelona\", 110)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ALMACENES (Lugar, Capacidad) VALUES (\"Valencia\", 120)"
				);
		
		// CAJAS
		
		inserciones.add(""
				+ "INSERT INTO CAJAS (Contenido, Valor, Almacen) VALUES (\"Herramientas\", \"8830\", 1)"
				);
		
		inserciones.add(""
				+ "INSERT INTO CAJAS (Contenido, Valor, Almacen) VALUES (\"Ropa\", \"2230\", 2)"
				);
		
		inserciones.add(""
				+ "INSERT INTO CAJAS (Contenido, Valor, Almacen) VALUES (\"Juguetes\", \"1330\", 3)"
				);
		
		inserciones.add(""
				+ "INSERT INTO CAJAS (Contenido, Valor, Almacen) VALUES (\"Comida\", \"2130\", 4)"
				);
		
		inserciones.add(""
				+ "INSERT INTO CAJAS (Contenido, Valor, Almacen) VALUES (\"Armas\", \"12230\", 5)"
				);

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
