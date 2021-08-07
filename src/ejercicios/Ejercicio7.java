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

public class Ejercicio7 extends ConectorCustom {
	
	String db = "E7_CIENTIFICOS";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio7() {
		
		System.out.println(db);
		
		tablas = new String[3];
		
		tablas[0] = "CREATE TABLE CIENTIFICOS (\r\n"
				+ "DNI VARCHAR(9) PRIMARY KEY,\r\n"
				+ "NomApells VARCHAR(255)\r\n"
				+ ")";
		
		tablas[1] = "CREATE TABLE PROYECTO(\r\n"
				+ "Id CHAR(4) PRIMARY KEY,\r\n"
				+ "Nombre VARCHAR(255),\r\n"
				+ "Horas INT\r\n"
				+ ")";
		
		tablas[2] = "CREATE TABLE ASIGNADO_A(\r\n"
				+ "Cientifico VARCHAR(9),\r\n"
				+ "Proyecto CHAR(4),\r\n"
				+ "KEY (Cientifico, Proyecto),\r\n"
				+ "FOREIGN KEY (Cientifico) REFERENCES CIENTIFICOS (DNI) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "FOREIGN KEY (Proyecto) REFERENCES PROYECTO (ID) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "PRIMARY KEY (Cientifico, Proyecto)\r\n"
				+ ")";
		
		// CIENTIFICOS
		
		inserciones.add(""
				+ "INSERT INTO CIENTIFICOS VALUES (\"39930321K\", \"Sergio A\"), (\"44510991B\", \"Javi B\"), (\"24432910X\", \"Rosa A\"), (\"64470331C\", \"Marta B\"), (\"01531431E\", \"Rodrigo A\"), (\"75109845X\", \"Alberto A\"), (\"74158019Q\", \"Marcos Z\"), (\"50684531Y\", \"Laura B\"), (\"17319704Z\", \"Javier Z\"), (\"18684161L\", \"Cristina A\")"
				);
		
		// PROYECTOS
		
		inserciones.add(""
				+ "INSERT INTO PROYECTO VALUES (\"AA\", \"Proyecto1\", 100), (\"BB\", \"Proyecto2\", 100), (\"CC\", \"Proyecto3\", 900), (\"DD\", \"Proyecto4\", 300), (\"JJ\", \"Proyecto5\", 300), (\"HH\", \"Proyecto6\", 20), (\"XX\", \"Proyecto7\", 20), (\"BBX\", \"Proyecto8\", 30), (\"BVV\", \"Proyecto9\", 20), (\"ZXD\", \"Proyecto10\", 10)"
				);
		
		//ASIGNADO A
		
		inserciones.add(""
				+ "INSERT INTO ASIGNADO_A VALUES (\"39930321K\", \"AA\"), (\"44510991B\", \"BB\"), (\"24432910X\", \"CC\"), (\"64470331C\", \"DD\"), (\"01531431E\", \"JJ\"), (\"75109845X\", \"HH\"), (\"74158019Q\", \"XX\"), (\"50684531Y\", \"BBX\"), (\"17319704Z\", \"BVV\"), (\"18684161L\", \"ZXD\")"
				);
		

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
