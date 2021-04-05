package com.calendardemo.utility;

import java.util.List;




import javax.persistence.AttributeConverter;

import com.calendardemo.dto.Attendies;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


public class AttendiesConverter implements AttributeConverter<List<Attendies>, String> {

	@Override
	public String convertToDatabaseColumn(List<Attendies> attribute) {
		if (attribute == null || attribute.isEmpty())
			return null;
		return new Gson().toJson(attribute);
	}

	@Override
	public List<Attendies> convertToEntityAttribute(String dbData) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (dbData == null)
				return null;
			return mapper.readValue(dbData, new TypeReference<List<Attendies>>() {
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;

		}
	}

	
}
