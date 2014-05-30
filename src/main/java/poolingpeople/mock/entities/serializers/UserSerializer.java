package poolingpeople.mock.entities.serializers;

import java.io.StringReader;
import java.lang.reflect.Field;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import poolingpeople.mock.entities.User;

public class UserSerializer implements ISerializer<User>{

	@Override
	public String serialize(User user, SerializationView view) {

		JsonObjectBuilder currentBuilder;

		switch (view) {
		case PRIVATE:
			currentBuilder = getPrivateSerialization(user);
			break;

		case PUBLIC:
			currentBuilder = getPublicSerialization(user);
			break;

		default:
			throw new ContextedRuntimeException("view not available").addContextValue("used view", view);
		}

		return currentBuilder.build().toString();
	}

	@Override
	public void load(User user, String json) {

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

	private JsonObjectBuilder getPrivateSerialization(User user){

		JsonObjectBuilder builder = getPublicSerialization(user);
		builder.add("email", user.getEmail());

		return builder;

	}

	private JsonObjectBuilder getPublicSerialization(User user){

		JsonObjectBuilder builder = Json.createObjectBuilder();

		builder.add("firstName", user.getFirstName());
		builder.add("lastName", user.getLastName());
		builder.add("id", user.getId());

		return builder;

	}
}
