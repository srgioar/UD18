package main;

import conector.ConectorCustom;
import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;
import ejercicios.Ejercicio5;
import ejercicios.Ejercicio6;
import ejercicios.Ejercicio7;
import ejercicios.Ejercicio8;
import ejercicios.Ejercicio9;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Cada ejercicio hace sus inserts, si comentas se salta uno
		// Si lo dejas sin comentar puede hacer todos del tirón
		
		Ejercicio1 e1 = new Ejercicio1();
		Ejercicio2 e2 = new Ejercicio2();
		Ejercicio3 e3 = new Ejercicio3();
		Ejercicio4 e4 = new Ejercicio4();
		Ejercicio5 e5 = new Ejercicio5();
		Ejercicio6 e6 = new Ejercicio6();
		Ejercicio7 e7 = new Ejercicio7();
		Ejercicio8 e8 = new Ejercicio8();
		Ejercicio9 e9 = new Ejercicio9();
		
		//Cierro la conexión
		ConectorCustom.closeConnection();
	}

}
