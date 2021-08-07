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

public class Ejercicio9 extends ConectorCustom {
	
	String db = "E9_INVESTIGADORES";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio9() {
		
		System.out.println(db);
		
		tablas = new String[4];
		
		tablas[0] = "CREATE TABLE FACULTAD(\r\n"
				+ "Codigo INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "Nombre VARCHAR(100)\r\n"
				+ ")";
		
		tablas[1] = "CREATE TABLE INVESTIGADORES(\r\n"
				+ "DNI VARCHAR(9) PRIMARY KEY,\r\n"
				+ "NomApells VARCHAR(255),\r\n"
				+ "Facultad INT,\r\n"
				+ "Key (Facultad),\r\n"
				+ "FOREIGN KEY (Facultad) REFERENCES FACULTAD (Codigo) ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")";
		
		tablas[2] = "CREATE TABLE EQUIPOS(\r\n"
				+ "NumSerie CHAR(4) PRIMARY KEY,\r\n"
				+ "Nombre VARCHAR(255),\r\n"
				+ "Facultad INT,\r\n"
				+ "Key (Facultad),\r\n"
				+ "FOREIGN KEY (Facultad) REFERENCES FACULTAD (Codigo) ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")";
		
		tablas[3] = "CREATE TABLE RESERVA(\r\n"
				+ "DNI VARCHAR(9),\r\n"
				+ "NumSerie CHAR(4),\r\n"
				+ "Key (DNI, NumSerie),\r\n"
				+ "FOREIGN KEY (DNI) REFERENCES INVESTIGADORES (DNI) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "FOREIGN KEY (NuMSerie) REFERENCES EQUIPOS (NumSerie) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "PRIMARY KEY (DNI, NumSerie)\r\n"
				+ ")";
		
		// FACULTAD
		
		inserciones.add(""
				+ "INSERT INTO FACULTAD (Nombre) VALUES (\"Facultad1\"), (\"facultad2\"), (\"Facultad3\"), (\"Facultad4\"), (\"Facultad5\"), (\"Facultad6\"), (\"Facultad7\"), (\"Facultad8\"), (\"Facultad9\"), (\"Facultad10\")"
				);
		
		// INVESTIGADORES
		
		inserciones.add(""
				+ "INSERT INTO INVESTIGADORES VALUES (\"39930321K\", \"SergioA\", 1), (\"18684161L\", \"LaraA\", 1), (\"00668252X\", \"JaviB\", 2), (\"58319312Y\", \"CarlaC\", 3), (\"16730285Q\", \"JaviC\", 4), (\"67989561C\", \"LaraB\", 4), (\"51350558E\", \"Orto B\", 5), (\"06420608C\", \"Marina A\", 6), (\"86188982R\", \"Luis A\", 7), (\"77114087D\", \"Abby P\", 7)"
				);
		
		// EQUIPOS
		
		inserciones.add(""
				+ "INSERT INTO EQUIPOS VALUES (\"AB12\", \"EquipoA\", 1), (\"AB21\", \"EquipoB\", 2), (\"AB44\", \"EquipoC\", 3), (\"AB55\", \"EquipoD\", 4), (\"AB56\", \"EquipoD\", 5), (\"ABV4\", \"EquipoE\", 6)"
				);
		
		// RESERVA
		
		inserciones.add(""
				+ "INSERT INTO RESERVA VALUES (\"39930321K\", \"AB12\"), (\"18684161L\", \"AB44\"), (\"58319312Y\", \"AB56\"), (\"00668252X\", \"ABV4\"), (\"16730285Q\", \"AB56\"), (\"58319312Y\", \"AB21\")"
				);


		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
