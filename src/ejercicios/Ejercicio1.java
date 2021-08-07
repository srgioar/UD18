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

public class Ejercicio1 extends ConectorCustom {
	
	String db = "E1_TIENDA_INFORMATICA";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio1() {
		
		System.out.println(db);
		
		tablas = new String[2];
		
		tablas[0] = "CREATE TABLE FABRICANTES (Codigo INT AUTO_INCREMENT PRIMARY KEY, Nombre VARCHAR(100))";
		
		tablas[1] = "CREATE TABLE ARTICULOS ("
				+ "Codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "Nombre VARCHAR(100),"
				+ "Precio INT(20),"
				+ "CodigoFabricante INT,"
				+ "KEY (CodigoFabricante),"
				+ "FOREIGN KEY (CodigoFabricante) REFERENCES FABRICANTES (Codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ")";
		
		// Fabricantes
		
		inserciones.add(""
				+ "INSERT INTO FABRICANTES (Nombre) VALUES (\"Fabricante Sergio\")"
				);
		
		inserciones.add(""
				+ "INSERT INTO FABRICANTES (Nombre) VALUES (\"Fabricante Javier\")"
				);
		
		inserciones.add(""
				+ "INSERT INTO FABRICANTES (Nombre) VALUES (\"Fabricante Javier\")"
				);
		
		inserciones.add(""
				+ "INSERT INTO FABRICANTES (Nombre) VALUES (\"Fabricante Laura\")"
				);
		
		inserciones.add(""
				+ "INSERT INTO FABRICANTES (Nombre) VALUES (\"Fabricante Tatiana\")"
				);
		
		// ARTICULOS
		
		inserciones.add(""
				+ "INSERT INTO ARTICULOS (Nombre, Precio, CodigoFabricante) VALUES (\"Articulo1\", 20, 1)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ARTICULOS (Nombre, Precio, CodigoFabricante)  VALUES (\"Articulo2\", 20, 2)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ARTICULOS (Nombre, Precio, CodigoFabricante)  VALUES (\"Articulo3\", 20, 3)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ARTICULOS (Nombre, Precio, CodigoFabricante)  VALUES (\"Articulo4\", 20, 4)"
				);
		
		inserciones.add(""
				+ "INSERT INTO ARTICULOS (Nombre, Precio, CodigoFabricante)  VALUES (\"Articulo5\", 20, 5)"
				);

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
