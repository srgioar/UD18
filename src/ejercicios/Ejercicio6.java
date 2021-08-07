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

public class Ejercicio6 extends ConectorCustom {
	
	String db = "E6_PIEZAS_Y_PROVEEDORES";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio6() {
		
		System.out.println(db);
		
		tablas = new String[3];
		
		tablas[0] = "CREATE TABLE PROVEEDORES(\r\n"
				+ "Id CHAR(4) PRIMARY KEY,\r\n"
				+ "Nombre VARCHAR(100)\r\n"
				+ ")";
		
		tablas[1] = "CREATE TABLE PIEZAS(\r\n"
				+ "Codigo INT PRIMARY KEY AUTO_INCREMENT,\r\n"
				+ "Nombre VARCHAR(100)\r\n"
				+ ")";
		
		tablas[2] = "CREATE TABLE SUMINISTRA(\r\n"
				+ "CodigoPieza INT,\r\n"
				+ "IdProveedor CHAR(4),\r\n"
				+ "KEY (IdProveedor),\r\n"
				+ "KEY (CodigoPieza),\r\n"
				+ "PRIMARY KEY (IdProveedor, CodigoPieza),\r\n"
				+ "FOREIGN KEY (CodigoPieza) REFERENCES PIEZAS (Codigo) ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "FOREIGN KEY (IdProveedor) REFERENCES PROVEEDORES (Id) ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ")";
		
		// PIEZAS
		
		inserciones.add(""
				+ "INSERT INTO PIEZAS (Nombre) VALUES (\"Pieza1\"), (\"Pieza2\"), (\"Pieza3\"), (\"Pieza4\"), (\"Pieza5\"), (\"Pieza6\"), (\"Pieza7\"), (\"Pieza8\"), (\"Pieza9\"), (\"Pieza10\");"
				);
		
		// PROVEEDORES
		
		inserciones.add(""
				+ "INSERT INTO PROVEEDORES VALUES (\"AB11\", \"ProveedorA\"), (\"AB12\", \"ProveedorB\"), (\"AB13\", \"ProveedorC\"), (\"AB14\", \"ProveedorD\"), (\"AB16\", \"ProveedorE\"), (\"AB19\", \"ProveedorF\"), (\"AB20\", \"ProveedorG\"), (\"AB29\", \"ProveedorH\"), (\"BD99\", \"ProveedorI\"), (\"JBL1\", \"ProveedorJ\");"
				);
		

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
