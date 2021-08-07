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

public class Ejercicio5 extends ConectorCustom {
	
	String db = "E5_DIRECTORES_DESPACHOS";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio5() {
		
		System.out.println(db);
		
		tablas = new String[2];
		
		tablas[0] = "CREATE TABLE DESPACHOS(\r\n"
				+ "Numero INT AUTO_INCREMENT PRIMARY KEY,\r\n"
				+ "Capacidad INT\r\n"
				+ ")";
		
		tablas[1] = "CREATE TABLE DIRECTORES(\r\n"
				+ "DNI VARCHAR(9) PRIMARY KEY,\r\n"
				+ "NomApells VARCHAR(255),\r\n"
				+ "DNIJefe VARCHAR(9) NULL,\r\n"
				+ "DespachoJefe INT NULL,\r\n"
				+ "KEY (DNIJefe, DespachoJefe),\r\n"
				+ "FOREIGN KEY (DNIJefe) REFERENCES DIRECTORES (DNI) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "FOREIGN KEY (DespachoJefe) REFERENCES DESPACHOS (Numero) ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")";
		
		// DESPACHOS: Estos los meto del tirón
		
		inserciones.add(""
				+ "INSERT INTO DESPACHOS VALUES (1, 40), (2, 40), (3, 50), (4, 90), (5,30), (6,30), (7, 40), (8, 40), (9, 30), (10, 90)"
				);
		
		// DIRECTORES
		
		inserciones.add(""
				+ "INSERT INTO DIRECTORES VALUES (\"39930321K\", \"Sergio A\", \"39930321K\", 1)"
				);
		
		inserciones.add(""
				+ "INSERT INTO DIRECTORES VALUES (\"34400321B\", \"Javi B\", \"39930321K\", 4);"
				);
		
		inserciones.add(""
				+ "INSERT INTO DIRECTORES VALUES (\"34400321C\", \"Rocio E\", \"39930321K\", 2);"
				);
		
		inserciones.add(""
				+ "INSERT INTO DIRECTORES VALUES (\"34400321D\", \"Marcos J\", \"39930321K\", 1);"
				);
		

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
