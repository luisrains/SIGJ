package py.com.sigj.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RenderingInfo {
	private Map<String, Object> mapa = new HashMap<String, Object>();

	public Map<String, Object> getMapa() {
		return mapa;
	}

	public void setMapa(Map<String, Object> mapa) {
		this.mapa = mapa;
	}

	public void add(String clave, Object valor) {
		this.mapa.put(clave, valor);
	}

	public Object get(String clave) {
		return this.mapa.get(clave);
	}

	public String infoToString() {
		String info = "";
		Iterator<String> it = mapa.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			info = info + " " + key + ": " + mapa.get(key);
		}
		return info;
	}

}
