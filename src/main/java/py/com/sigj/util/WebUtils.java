package py.com.sigj.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class WebUtils {

	private static final String PADDING_CHAR = "*";
	private static final int TARJETA_DIGITOS_VISIBLES = 4;
	private static final String ISO8601_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	private static final String DATE_FORMAT = "ddMMyyyy";
	private static final String WEB_DATE_FORMAT = "dd/MM/yyyy";
	public static final String DATETIME_PATTERN = "ddMMyyyyHH:mm:ss";
	// Comunes en más de un tipo de producto
	private static final String FECHA_APERTURA = "fecha_apertura";
	private static final String FECHA_ULTIMO_PAGO = "fecha_ultimo_pago";
	// CDA's
	private static final String FECHA_CIERRE = "fecha_cierre";
	// Constantes para movimientos
	private static final String FECHA_CONFIRMACION = "fecha_confirmacion";
	private static final String FECHA_HORA = "fecha_hora";
	private static final String NUMERO_CAJA = "nro_caja";
	private static final String OFICINA = "oficina";
	private static final String LISTA_TAGS = "lista_tags";
	// Constantes para tarjetas
	private static final String PROXIMO_VENCIMIENTO = "proximo_vencimiento";
	private static final String PROXIMO_CIERRE = "proximo_cierre";
	// Constante para mapa de productos
	private static final String PRODUCTS_MAP_KEY = "productsMap";
	// Constante para cuenta
	private static final String ACCOUNT_ADDITIONAL_INFO = "dato_adicional_cuenta";
	private static final String COD_ENT_PAG_SUELDO = "COD_ENT_PAG_SUELDO";
	private static final String COD_ENT_PAG_PROVEEDOR = "COD_ENT_PAG_PROVEEDOR";
	//
	private static final int BIG_DECIMAL_SCALE = 4;
	public static final int OP_NUMBER_SIZE = 6;

	// Regex
	private static final String LETTERS_REGEX = "^[a-zA-Z\b ]+$";
	private static final String NUMBERS_ONLY_REGEX = "^[0-9\b]+$";
	private static final String BUSSINESS_NAME_REGEX = "^[a-zA-Z0-9/&\b ]|[.]|[-]|[,]+$";
	protected final org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());

	// Acciones usadas para agrupar ciertos permisos, como pagos
	public enum GroupAction {
		PAGOS("pagos"), PAGO_TASAS("pago-tasas"), TRANSFERENCIAS("transferencias"), CONSULTA_PAGOS(
				"consulta-pagos"), CONSULTA_TRANSFERENCIAS("consulta-transferencias");

		private String nombre;

		private GroupAction(String nombre) {
			this.setNombre(nombre);
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public static GroupAction fromString(String value) {
			for (GroupAction ga : GroupAction.values()) {
				if (ga.nombre.equalsIgnoreCase(value)) {
					return ga;
				}
			}
			return null;
		}
	}

	public static void truncateCalendar(Calendar calActual) {
		calActual.set(Calendar.HOUR_OF_DAY, 0);
		calActual.set(Calendar.MINUTE, 0);
		calActual.set(Calendar.SECOND, 0);
		calActual.set(Calendar.MILLISECOND, 0);

	}

	public static String maskedNumberFromNumber(String number) {
		int longitud = number.length();
		if (longitud > TARJETA_DIGITOS_VISIBLES) {
			String ultimosDigitos = number.substring(longitud - TARJETA_DIGITOS_VISIBLES);
			String retorno = String.format("%" + (longitud) + "s", ultimosDigitos).replace(" ", PADDING_CHAR);
			return retorno;
		}
		return number;
	}

	public static Date getDate(String fecha) throws RuntimeException {

		if (fecha == null) {
			throw new RuntimeException();
		}
		try {
			Date date = new SimpleDateFormat(DATE_FORMAT).parse(fecha);

			return date;

		} catch (ParseException e) {

			throw new RuntimeException(e);
		}
	}

	public static Date getWebDate(String fecha) throws RuntimeException {

		if (fecha == null) {
			throw new RuntimeException();
		}
		try {
			Date date = new SimpleDateFormat(WEB_DATE_FORMAT).parse(fecha);

			return date;

		} catch (ParseException e) {

			throw new RuntimeException(e);
		}
	}

	public static String getStringWebDate(Date fecha) throws RuntimeException {

		if (fecha == null) {
			return "";
		}

		String strDate = new SimpleDateFormat(WEB_DATE_FORMAT).format(fecha);

		return strDate;
	}

	public static int getDaysBetweenDates(Date fecha1, Date fecha2) throws RuntimeException {

		if (fecha1 == null || fecha2 == null) {
			throw new RuntimeException();
		}
		try {
			long diff = fecha2.getTime() - fecha1.getTime();
			int cantDias = (int) Math.rint(diff / (1000 * 60 * 60 * 24));

			return cantDias;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static BigDecimal getBigDecimal(String s) throws RuntimeException {

		if (s == null) {
			throw new RuntimeException();
		}
		try {
			s = s.replaceAll(",", ".");
			BigDecimal monto = new BigDecimal(s);

			return monto.setScale(BIG_DECIMAL_SCALE);

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static int getInt(String s) throws RuntimeException {

		if (s == null) {
			throw new RuntimeException();
		}
		try {
			s = s.replaceAll(",", ".");
			int monto = Integer.parseInt(s);

			return monto;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static String getStringFromDate(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}

	public static Date getDateFromString(String data, String format) throws ParseException {
		DateFormat formatter = new SimpleDateFormat(format, Locale.US);
		Date date = formatter.parse(data);

		return date;
	}

	public static String getFechaFromDate(Date date) {
		String dateFormateado = getStringFromDate(date, DATE_FORMAT);
		return dateFormateado;
	}

	public static Date getHabilDayFromFechaValor(String fechaValor) {

		Calendar calActual = Calendar.getInstance();

		// calActual.add(Calendar.DAY_OF_MONTH, 2);SOLO P/PRUEBA
		int weekenDay = calActual.get(Calendar.DAY_OF_WEEK);

		switch (fechaValor) {
		case "0":

			if (weekenDay == 7) {// si es sabado se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 2);
			} else if (weekenDay == 1) {// si es domingo se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 1);
			}
			break;
		case "24":

			if (weekenDay == 6) {// si es viernes se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 2);
			} else if (weekenDay == 7) {// si es sabado se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 2);
			} else if (weekenDay == 1) {// si es domingo se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 1);
			}
			calActual.add(Calendar.DAY_OF_MONTH, 1);// se le suma 1 dia
			break;
		case "48":
			if (weekenDay == 6) {// si es viernes se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 2);
			} else if (weekenDay == 7) {// si es sabado se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 2);
			} else if (weekenDay == 1) {// si es domingo se corre a lunes
				calActual.add(Calendar.DAY_OF_MONTH, 1);
			}
			calActual.add(Calendar.DAY_OF_MONTH, 2);
			break;
		default:
			break;
		}

		Date fechaAcred = calActual.getTime();
		return fechaAcred;
	}

	public static ZipOutputStream compressFile(MultipartFile[] files, String zipFilePathName) throws Exception {

		String multipartFileName = null;
		// String[] srcFiles = { "C:/srcfile1.txt", "C:/srcfile2.txt",
		// "C:/srcfile3.txt"};

		try {

			// create byte buffer
			byte[] buffer = new byte[1024];

			FileOutputStream fos = new FileOutputStream(zipFilePathName);

			ZipOutputStream zos = new ZipOutputStream(fos);

			for (int i = 0; i < files.length; i++) {

				MultipartFile multipartFile = files[i];

				multipartFileName = multipartFile.getOriginalFilename();
				InputStream fis = multipartFile.getInputStream();
				zos.putNextEntry(new ZipEntry(multipartFileName));

				int length;

				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}

				zos.closeEntry();

				// close the InputStream
				fis.close();

			}

			// close the ZipOutputStream
			zos.close();

			return zos;

		} catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
			throw new Exception("ocurrio un error al intentar comprimir el archivo");
		}

	}

	public static byte[] compressFile(String[] content, String[] fileNames) throws Exception {

		try {

			// create byte buffer
			byte[] buffer = new byte[1024];

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			ZipOutputStream zos = new ZipOutputStream(baos);

			for (int i = 0; i < content.length; i++) {

				String strFile = content[i];
				String strFileName = fileNames[i];

				InputStream fis = new ByteArrayInputStream(strFile.getBytes());
				zos.putNextEntry(new ZipEntry(strFileName));

				int length;

				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}

				zos.closeEntry();

				// close the InputStream
				fis.close();

			}

			// close the ZipOutputStream
			zos.flush();
			zos.close();
			// close teh ByteArrayOutputStream
			baos.flush();
			baos.close();

			return baos.toByteArray();

		} catch (IOException ioe) {
			System.out.println("Error creating zip file: " + ioe);
			throw new Exception("ocurrio un error al intentar comprimir el archivo");
		}

	}

	public static File multipartToFile(MultipartFile multipartFile, String folderPath) throws IOException {

		String orgName = multipartFile.getOriginalFilename();

		String filePath = folderPath + orgName;
		File dest = new File(filePath);
		try {
			multipartFile.transferTo(dest);
		} catch (IllegalStateException e) {

			throw e;
		} catch (IOException e) {

			throw e;
		}
		return dest;
	}

	public static String getFormatNumber(BigDecimal number, String currency) throws Exception {
		try {
			NumberFormat nf = NumberFormat.getInstance(new Locale("es", "py"));

			if (currency != null && currency.trim().toUpperCase().contains("GS")) {
				nf.setMaximumFractionDigits(0);
			} else {
				nf.setMinimumFractionDigits(2);
			}
			return nf.format(number);
		} catch (Exception e) {
			throw new Exception("No se pudo formatear número");
		}
	}

	public static boolean isStringTriplicated(String str) {
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		boolean isTrip = false;
		for (char loop : str.toCharArray()) {
			Integer freq = charMap.get(loop);
			charMap.put(loop, (freq == null) ? 1 : freq + 1);
			if (charMap.get(loop) > 2) {
				isTrip = true;
			}
		}
		return isTrip;
	}

	public static Integer getInteger(String s) throws RuntimeException {

		if (s == null || s.equals("")) {
			return null;
		}
		try {
			Integer valor = new Integer(s);

			return valor;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static String formatOpNumber(String number) {
		String formattedResult = String.format("%" + OP_NUMBER_SIZE + "s", number).replace(' ', '0');

		return formattedResult;
	}

	public static String formatMontoToNumberString(String monto) {
		monto = monto.replace(".", "");
		monto = monto.replace(",", ".");
		return monto;
	}

	public static Date getDateNow() throws RuntimeException {

		try {
			Date today = Calendar.getInstance().getTime();

			return today;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static Date getDate(int mes, int anho) throws RuntimeException {

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.MONTH, mes);
			calendar.set(Calendar.YEAR, anho);
			Date date = calendar.getTime();

			return date;

		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	public static String unmaskedFormat(String cuenta) {
		if (cuenta == null) {
			return cuenta;
		}
		String cuentaLimpia = cuenta.trim().replace('.', '-').replace(' ', '-').replace('/', '-');
		if (cuentaLimpia.contains("-") || cuentaLimpia.contains(" ")) {
			int vPos = cuentaLimpia.lastIndexOf("-");
			if (vPos > 0) {

				cuentaLimpia = cuentaLimpia.substring(vPos + 1);

				return cuentaLimpia;
			}
		} else if (cuentaLimpia.substring(0, 2).equals("00")) {
			cuentaLimpia = String.valueOf(Integer.parseInt(cuentaLimpia));

			return cuentaLimpia;
		}

		return cuentaLimpia;
	}

	public static Date getDateTime(String fecha) throws RuntimeException {

		if (fecha == null || fecha.equals("")) {
			return null;
		}
		try {
			Date date = new SimpleDateFormat(DATETIME_PATTERN).parse(fecha);

			return date;

		} catch (ParseException e) {

			throw new RuntimeException(e);
		}
	}

	public static String getMontoAsString(String monto) {
		String resultado = monto.replace(".", "");
		return resultado.replace(",", ".");
	}

	// Validación de fecha de operación para pago de salarios
	public static boolean isFechaProcesoValida(String fechaProceso) {
		Calendar calActual = Calendar.getInstance();
		// setear la hora de la fecha actual a 00:00:00
		calActual.set(Calendar.HOUR_OF_DAY, 0);
		calActual.set(Calendar.MINUTE, 0);
		calActual.set(Calendar.SECOND, 0);
		calActual.set(Calendar.MILLISECOND, 0);
		Date fechaActual = new Date(calActual.getTimeInMillis());
		Date fechaOperacion = WebUtils.getDate(fechaProceso);

		return fechaActual.compareTo(fechaOperacion) <= 0;
	}

	public static Boolean validateLetters(String input) {
		return input.matches(LETTERS_REGEX);
	}

	public static Boolean validateNumbersOnly(String input) {
		return input.matches(NUMBERS_ONLY_REGEX);
	}

	public static Boolean validateBussinessName(String input) {
		return input.matches(BUSSINESS_NAME_REGEX);
	}

	public static String formatearNumeroTarjeta(String numeroTarjeta) {
		if (numeroTarjeta != null) {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < numeroTarjeta.length(); i++) {
				if (i % 4 == 0 && i != 0) {
					result.append(" ");
				}

				result.append(numeroTarjeta.charAt(i));
			}

			return result.toString();
		} else {
			return numeroTarjeta;
		}
	}

	// formatea monto según moneda
	public static String getMontoFormateado(BigDecimal monto, String moneda) {
		// formateador que usamos para enteros y decimales
		DecimalFormat formateador = formateador = new DecimalFormat("###,###.##");

		String montoFormateado = formateador.format(monto);

		return montoFormateado;
	}

	public static Integer getMonthsBetweenDates(Date beginningDate, Date endingDate) {
		if (beginningDate == null || endingDate == null) {
			return 0;
		}
		Calendar cal1 = new GregorianCalendar();
		cal1.setTime(beginningDate);
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(endingDate);
		return getMonthsBetweenDates(cal1, cal2);
	}

	private static Integer getMonthsBetweenDates(Calendar beginningDate, Calendar endingDate) {
		if (beginningDate == null || endingDate == null) {
			return 0;
		}
		int m1 = beginningDate.get(Calendar.YEAR) * 12 + beginningDate.get(Calendar.MONTH);
		int m2 = endingDate.get(Calendar.YEAR) * 12 + endingDate.get(Calendar.MONTH);
		return m2 - m1;
	}

}
