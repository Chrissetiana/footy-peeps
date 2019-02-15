package com.chrissetiana.footypeeps.data.remote;

import com.chrissetiana.footypeeps.util.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .addInterceptor(interceptor)
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//                    .registerTypeAdapter(String.class, new StringConverter())
//                    .registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory())
                    .serializeNulls()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(Config.BASE_URL)
//                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }

    /*public static class NullOnEmptyConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return new Converter<ResponseBody, Object>() {
                @Override
                public Object convert(ResponseBody body) throws IOException {
                    return body.contentLength() != 0 ? delegate.convert(body) : null;
                }
            };
        }
    }*/

    /*public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringAdapter();
        }
    }

    public static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }*/

    /*public static class StringConverter implements JsonSerializer<String>, JsonDeserializer<String> {
        public JsonElement serialize(String src, Type typeOfSrc, JsonSerializationContext context) {
            if ( src == null ) {
                return new JsonPrimitive("");
            } else {
                return new JsonPrimitive(src.toString());
            }
        }
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return json.getAsJsonPrimitive().getAsString();
        }
    }*/

    /*
public final class EmptyStringAsNullTypeAdapter<T>
        implements JsonDeserializer<T> {

    // Let Gson instantiate it itself
    private EmptyStringAsNullTypeAdapter() {
    }

    @Override
    public T deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        if ( jsonElement.isJsonPrimitive() ) {
            final JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
            if ( jsonPrimitive.isString() && jsonPrimitive.getAsString().isEmpty() ) {
                return null;
            }
        }
        return context.deserialize(jsonElement, type);
    }

}
And then just annotate the replies field:

@SerializedName("replies")
@JsonAdapter(EmptyStringAsNullTypeAdapter.class)
private CommentListing replies;
 */

    /*
    Create your own TypeAdapter

public class MyTypeAdapter extends TypeAdapter<TestObject>() {

    @Override
    public void write(JsonWriter out, TestObject value) throws IOException {
        out.beginObject();
        if (!Strings.isNullOrEmpty(value.test1)) {
            out.name("test1");
            out.value(value.test1);
        }

        if (!Strings.isNullOrEmpty(value.test2)) {
            out.name("test2");
            out.value(value.test1);
        }
        // similar check for otherObject
        out.endObject();
}

    @Override
    public TestObject read(JsonReader in) throws IOException {
        // do something similar, but the other way around
    }
}
You can then register it with Gson.

        Gson gson = new GsonBuilder().registerTypeAdapter(TestObject.class, new MyTypeAdapter()).create();
        TestObject obj = new TestObject();
        obj.test1 = "test1";
        obj.test2 = "";
        System.out.println(gson.toJson(obj));
        produces

        {"test1":"test1"}
     */
}

