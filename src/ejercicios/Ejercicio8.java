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

public class Ejercicio8 extends ConectorCustom {
	
	String db = "E8_GRANDES_ALMACENES";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio8() {
		
		System.out.println(db);
		
		tablas = new String[4];
		
		tablas[0] = "CREATE TABLE CAJEROS(\r\n"
				+ "Codigo INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "NomApells VARCHAR(255)\r\n"
				+ ")";
		
		tablas[1] = "CREATE TABLE PRODUCTOS(\r\n"
				+ "Codigo INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "Nombre VARCHAR(100),\r\n"
				+ "Precio INT\r\n"
				+ ")";
		
		tablas[2] = "CREATE TABLE MAQUINAS_REGISTRADORAS(\r\n"
				+ "Codigo INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "Piso INT\r\n"
				+ ");";
		
		tablas[3] = "CREATE TABLE VENTA(\r\n"
				+ "Cajero INT,\r\n"
				+ "Maquina INT,\r\n"
				+ "Producto INT,\r\n"
				+ "Key (Cajero, Maquina, Producto),\r\n"
				+ "FOREIGN KEY (Cajero) REFERENCES CAJEROS (Codigo) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "FOREIGN KEY (Maquina) REFERENCES MAQUINAS_REGISTRADORAS (Codigo) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "FOREIGN KEY (Producto) REFERENCES PRODUCTOS (Codigo) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "PRIMARY KEY (Cajero, Maquina, Producto)\r\n"
				+ ")";
		
		// CAJEROS
		
		inserciones.add(""
				+ "INSERT INTO CAJEROS (NomApells) VALUES (\"SergioA\"), (\"KatiaB\"), (\"IzanC\"), (\"AnnaB\"), (\"CarlaC\"), (\"JoseJ\"), (\"PedroP\"), (\"MariaM\"), (\"YleniaY\"), (\"RodrigoR\")"
				);
		
		// PRODUCTOS
		
		inserciones.add(""
				+ "INSERT INTO PRODUCTOS (Nombre, Precio) VALUES (\"Peine\", 10), (\"Cepillo\", 5), (\"Gafas\", 40), (\"Chaqueta\", 50), (\"Lavadora\", 100), (\"Juguete\", 20), (\"Destornillador\", 3), (\"Linterna\", 10), (\"Cable\", 2), (\"Enchufe\", 3)"
				);
		
		// MAQUINAS REGISTRADORAS
		
		inserciones.add(""
				+ "INSERT INTO MAQUINAS_REGISTRADORAS (Piso) VALUES (1), (2), (3), (4), (1), (2), (3), (4), (2), (4)"
				);
		
		// VENTAS
		
		inserciones.add(""
				+ "INSERT INTO VENTA VALUES (1, 1, 1) , (2, 2, 2), (3, 3, 3), (4, 4, 4), (5, 5, 5), (6, 6, 6), (7, 7, 7), (8, 8, 8), (9, 9, 9), (10, 10, 10)"
				);
		

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
