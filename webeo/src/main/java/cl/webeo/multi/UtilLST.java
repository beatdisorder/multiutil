package cl.webeo.multi;

public class UtilLST {
	private static final String lineSeparator = System.getProperty("line.separator");

	public static String getLinesLst(int fps, String formato, String baseString, int inicioCuenta, int finCuenta,
			int cantidadIteracion, boolean fillIndex, boolean fillIndexWitdhZero) {
		StringBuilder builder = new StringBuilder("MohoSwitch1").append(lineSeparator);
		builder.append("FPS " + fps).append(lineSeparator);
		builder.append(formato).append(lineSeparator);

		int cont = 1;
		for (int i = inicioCuenta; i <= finCuenta; i += cantidadIteracion) {
			builder.append(cont + " " + baseString + getNumber(i, finCuenta, fillIndex, fillIndexWitdhZero))
					.append(lineSeparator);
			cont++;
		}

		return builder.toString();
	}

	private static String getNumber(int index, int finCuenta, boolean fillIndex, boolean fillIndexWitdhZero) {
		String result = null;
		int iterator = String.valueOf(finCuenta).length() - String.valueOf(index).length();
		if (fillIndex) {
			result = "";
			String filler = fillIndexWitdhZero ? "0" : " ";
			for (int i = 0; i < iterator; i++) {
				result += filler;
			}
			result += index;
		}
		return result != null ? result : String.valueOf(index);
	}

	public static void main(String[] args) {
		System.out.println(getLinesLst(24, "jpg", "v", 1, 8223, 1, true, true));
	}
}
