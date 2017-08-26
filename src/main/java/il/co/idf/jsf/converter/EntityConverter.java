package il.co.idf.jsf.converter;

import il.co.idf.model.GenericEntity;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.HashMap;
import java.util.Map;

@FacesConverter("entityConverter")
public class EntityConverter implements Converter {

	private static final String key = "com.example.jsf.EntityConverter";
	private static final String empty = "";

	private Map<String, Object> getViewMap(FacesContext context, Class entityClass) {
		Map<String, Object> viewMap = context.getViewRoot().getViewMap();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Map<Class, Map<String, Object>> classMap = (Map) viewMap.get(key);
		if (classMap == null) {
			classMap = new HashMap<>();
			classMap.put(entityClass, new HashMap<>());
			viewMap.put(key, classMap);
		} else {
			Map<String, Object> idMap = classMap.get(entityClass);
			if (idMap == null) {
				idMap = new HashMap<>();
				classMap.put(entityClass, idMap);
			}
		}
		return classMap.get(entityClass);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent c, String value) {
		if (value.isEmpty()) {
			return null;
		}
		String[] splittedValue = value.split("@");
		String id = splittedValue[0];
		String className = splittedValue[1];
		Class<?> aClass = null;
		try {
			aClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return getViewMap(context, aClass).get(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent c, Object value) {
		if (value == null || "".equals(value)) {
			return empty;
		}
		String id = Long.toString(((GenericEntity) value).getId());
		getViewMap(context, value.getClass()).put(id, value);
		return id + "@" + value.getClass().getName();
	}


}
