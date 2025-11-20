package principal;

import clases.Producto;

public class MainEjercicioArrays {

	public static void main(String[] args) {
		
		Producto[] inventario = {
			    new Producto(3, 25.99),
			    new Producto(8, 14.50),
			};
		
	    double sumaImpar = sumaPreciosImpar(inventario);
	    System.out.println("Suma de precios con stock impar: " + sumaImpar);
	    
	    Producto productoMasCaro = productoMasCaro(inventario);
	    System.out.println("Producto más caro con stock > 5: " + productoMasCaro.getPrecio());
	    
	}
		
	private static double sumaPreciosImpar(Producto[] inventario) {
	    double total = 0;
	    for (int i = 0; i < inventario.length; i++) {
	        if (inventario[i] != null && inventario[i].getStock() % 2 != 0) {
	            total += inventario[i].getPrecio();
	        }
	    }
	    return total;
	}

	public static Producto productoMasCaro(Producto[] inventario) {
	    Producto maximo = null;

	    for (int i = 0; i < inventario.length; i++) {
	        if (inventario[i] != null && inventario[i].stockMayor()) {
	            if (maximo == null || inventario[i].getPrecio() > maximo.getPrecio()) {
	                maximo = inventario[i];
	            }
	        }
	    }

	    return maximo;
	}
	
	public static void desplazarNullsAlFinal(Producto[] inventario) {
		Producto[] temp = new Producto[inventario.length];
		int index = 0;
		for (Producto p : inventario) {
			if (p != null) {
				temp[index++] = p;
			}
		}

		for (int i = 0; i < inventario.length; i++) {
			inventario[i] = temp[i];
		}
	}

	public static void intercambiarExtremos(Producto[] inventario) {
		int indexMin = -1, indexMax = -1;
		double minPrecio = Double.MAX_VALUE;
		double maxPrecio = -Double.MAX_VALUE;

		for (int i = 0; i < inventario.length; i++) {
			Producto p = inventario[i];
			if (p != null) {
				if (p.getPrecio() < minPrecio) {
					minPrecio = p.getPrecio();
					indexMin = i;
				}
				if (p.getPrecio() > maxPrecio) {
					maxPrecio = p.getPrecio();
					indexMax = i;
				}
			}
		}

		if (indexMin != -1 && indexMax != -1) {
			Producto temp = inventario[indexMin];
			inventario[indexMin] = inventario[indexMax];
			inventario[indexMax] = temp;
		}
	}

	public static void imprimirInventario(Producto[] inventario) {
		for (Producto p : inventario) {
			System.out.println(p);
		}
	}


}
