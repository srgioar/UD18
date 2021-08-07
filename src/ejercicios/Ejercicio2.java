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

public class Ejercicio2 extends ConectorCustom {
	
	String db = "E2_EMPLEADOS";
	
	String[] tablas;
	//String[] inserciones = new String[5];
	ArrayList<String> inserciones = new ArrayList<String>();
	
	public Ejercicio2() {
		
		System.out.println(db);
		
		tablas = new String[2];
		
		tablas[0] = "CREATE TABLE DEPARTAMENTOS ("
				+ "Codigo INT AUTO_INCREMENT PRIMARY KEY NOT NULL,"
				+ "Nombre VARCHAR(100),"
				+ "Presupuesto INT"
				+ ")";
		
		tablas[1] = "CREATE TABLE EMPLEADOS (\r\n"
				+ "DNI VARCHAR(8) PRIMARY KEY NOT NULL,\r\n"
				+ "Nombre VARCHAR(100),\r\n"
				+ "Apellidos VARCHAR(255),\r\n"
				+ "Departamento INT,\r\n"
				+ "KEY (Departamento),\r\n"
				+ "FOREIGN KEY (Departamento) REFERENCES DEPARTAMENTOS (Codigo) ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ");";
		
		// Fabricantes
		
		inserciones.add(""
				+ "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES (\"Departamento1\", 200)"
				);
		
		inserciones.add(""
				+ "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES (\"Departamento2\", 200)"
				);
		
		inserciones.add(""
				+ "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES (\"Departamento3\", 200)"
				);
		
		inserciones.add(""
				+ "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES (\"Departamento4\", 200)"
				);
		
		inserciones.add(""
				+ "INSERT INTO DEPARTAMENTOS (Nombre, Presupuesto) VALUES (\"Departamento5\", 200)"
				);
		
		// ARTICULOS
		
		inserciones.add("INSERT INTO EMPLEADOS VALUES (\"39930321\", \"Sergio\", \"ARodriguez\", 1)"
				);
		
		inserciones.add(""
				+ "INSERT INTO EMPLEADOS VALUES (\"39330331\", \"Adrian\", \"Pobito\", 2)"
				);
		
		inserciones.add(""
				+ "INSERT INTO EMPLEADOS VALUES (\"49930321\", \"Laura\", \"Azul\", 3)"
				);
		
		inserciones.add(""
				+ "INSERT INTO EMPLEADOS VALUES (\"59930321\", \"Romina\", \"Valiente\", 4)"
				);
		
		inserciones.add(""
				+ "INSERT INTO EMPLEADOS VALUES (\"69930321\", \"Mauro\", \"Azur\", 5);"
				);

		super.openConnection();
		super.createDB(db);
		super.insertarTablasCustom(db, tablas);
		super.insertarRegistrosCustom(db, inserciones);
		super.selectCustom(db, tablas);
		
	}
	
	

	

}
