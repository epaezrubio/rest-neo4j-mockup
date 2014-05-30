package poolingpeople.mock.entities.serializers;

import java.io.StringReader;
import java.lang.reflect.Field;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.apache.commons.lang3.exception.ContextedRuntimeException;

import poolingpeople.mock.entities.Task;

public class TaskSerializer implements ISerializer<Task>{

	@Override
	public String serialize(Task task, SerializationView view) {

		JsonObjectBuilder currentBuilder;

		switch (view) {
		case PRIVATE:
			currentBuilder = getPrivateSerialization(task);
			break;

		case PUBLIC:
			currentBuilder = getPublicSerialization(task);
			break;

		default:
			throw new ContextedRuntimeException("view not available").addContextValue("used view", view);
		}

		return currentBuilder.build().toString();
	}

	@Override
	public void load(Task task, String json) {

		JsonParser parser = Json.createParser(new StringReader(json));
		while (parser.hasNext()){
			if(parser.next().equals(JsonParser.Event.KEY_NAME)){
				String name = parser.getString();
				Event event = parser.next();
				try{
					Field field;
					field = this.getClass().getDeclaredField(name);

					field.setAccessible(true);
					Object value = null;

					switch(event){
					case VALUE_STRING:
						value = parser.getString();
						break;

					case VALUE_NUMBER:
						value = parser.getLong();
						break;

					default:
						break;

					}
					try {
						field.set(this, value);
					} catch (IllegalArgumentException | IllegalAccessException
							| SecurityException e) {
						throw new ContextedRuntimeException("Invalid type for argument")
						.addContextValue("field name", field.getName())
						.addContextValue("field type", field.getDeclaringClass().getSimpleName())
						.addContextValue("json value type", JsonParser.Event.VALUE_STRING); 
					}
				} catch (NoSuchFieldException e) {
					throw new ContextedRuntimeException("Invalid type for argument")
					.addContextValue("required field", name);
				} catch (SecurityException e) {
					throw new ContextedRuntimeException(e);
				}
			}
		}
	}

	private JsonObjectBuilder getPrivateSerialization(Task task){

		JsonObjectBuilder builder = getPublicSerialization(task);
		builder.add("date", task.getDate());

		return builder;

	}

	private JsonObjectBuilder getPublicSerialization(Task task){

		JsonObjectBuilder builder = Json.createObjectBuilder();

		builder.add("title", task.getTitle());
		builder.add("id", task.getId());

		return builder;

	}
}
